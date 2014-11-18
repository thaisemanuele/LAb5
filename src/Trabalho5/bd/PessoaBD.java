/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho5.bd;

import static Trabalho5.bd.EventoBD.seqCodEv;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Thais
 */
public class PessoaBD {
    
    public static void inserir(String nomePe, String emailPe, String instituicaoPe,
            String telefonePe, String nacionalidadePe, String enderecoPe,
            Integer tipoOrganizador, Integer tipoParticipante, Integer tipoAutor) throws SQLException, ParseException{
        Integer idPe = getSeq();
        String insert = "INSERT INTO Pessoa VALUES( " 
                + idPe + ", '"+ nomePe +"', '" +emailPe+ "', '" +instituicaoPe+"',"+"'" +telefonePe
                +"','"+nacionalidadePe+"','"+enderecoPe+"',"+tipoOrganizador+
                ","+tipoParticipante+","+tipoAutor+")";
        System.out.println("insert statement " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);

    }
    
    public static void atualizar(Integer idPe, String nomePe, String emailPe, String instituicaoPe,
            String telefonePe, String nacionalidadePe, String enderecoPe,
            Integer tipoOrganizador, Integer tipoParticipante, Integer tipoAutor) throws SQLException{
        String update = "UPDATE Pessoa SET nomePe = '" 
                +nomePe+ "',emailPe = '" +emailPe+"',instituicaoPe = '" +instituicaoPe+"',telefonePe= '"
                +telefonePe+"',nacionalidadePe = '" +nacionalidadePe+"',enderecoPe = '" +enderecoPe+
                "',tipoOrganizador = " +tipoOrganizador+",tipoParticipante = " +tipoParticipante+
                ",tipoAutor = " +tipoAutor+
                " WHERE idPe = " + idPe +"";
        System.out.println("insert statement " + update);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(update);
    }
    
    public static void excluir(Integer idPe) throws SQLException{
        String delete = "DELETE FROM Pessoa WHERE idPe = '" + idPe + "'";
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(delete);
    }
    
    public static ArrayList<String> buscar(Integer idPe) throws SQLException, ParseException{
        String selectTableSQL = "SELECT idPe, nomePe, emailPe, instituicaoPe, telefonePe, nacionalidadePe,"
                + " enderecoPe,tipoOrganizador, tipoParticipante, tipoAutor"
                + " FROM Pessoa WHERE idPe = " + idPe +"";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<String>();
        rs.next();
        for(int i=1; i<=10;i++){
            
            details.add(rs.getString(i));
        }
        return details;
    }
    
    private static Integer getSeq()throws SQLException{
        String selectSql = "SELECT max(idPe) from Pessoa";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        int seqIdPe = -1;
        if(rs.next()){
            seqIdPe = rs.getInt(1);
        }
       return seqIdPe + 1;  
    }
    
    public static ArrayList<String> searchByEmail(String emailPe) throws SQLException, ParseException{
        String selectTableSQL = "SELECT idPe, nomePe, emailPe, instituicaoPe, telefonePe, nacionalidadePe,"
                + " enderecoPe,tipoOrganizador, tipoParticipante, tipoAutor"
                + " FROM Pessoa WHERE emailPe = '" + emailPe +"'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<String>();
        rs.next();
        for(int i=1; i<=10;i++){
            
            details.add(rs.getString(i));
        }
        return details;
    }
    
    public static DefaultComboBoxModel getIdPe() throws SQLException{
         int i=1;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox codes = new JComboBox();
        codes.isEditable();
        String selectSql = "SELECT idPe from Pessoa";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        model.addElement(" --- ");
        while(rs.next()){
            System.out.println(rs.getString("idPe"));
            model.addElement(rs.getString("idPe"));
            i++;
        }
       return model;
    }
    
    public static Integer getIdByEmail(String email) throws SQLException{
        Integer id = -1;
        String selectSql = "SELECT idPe from Pessoa WHERE emailPe = '"+email+"'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        if(rs.next()){
            id = Integer.parseInt(rs.getString("idPe"));
        }
       return id;
    }
    
    public static DefaultComboBoxModel getEmailPe() throws SQLException{
         int i=1;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox codes = new JComboBox();
        codes.isEditable();
        String selectSql = "SELECT emailPe from Pessoa ORDER BY emailPe ASC";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        model.addElement(" --- ");
        while(rs.next()){
            System.out.println(rs.getString("emailPe"));
            model.addElement(rs.getString("emailPe"));
            i++;
        }
       return model;
    }
}
