/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho5.bd;

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
public class InscritoBD {
    
    /**
     *Cria e executa um insert statement na tabela inscrito
     * @param codEv
     * @param numEd
     * @param idPart
     * @param dataInsc
     * @param tipoApresentador
     * @throws SQLException
     * @throws ParseException
     */
    public static void inserir(Integer codEv, Integer numEd,Integer idPart,
        String dataInsc, Integer tipoApresentador) throws SQLException, ParseException{
            String insert = "INSERT INTO Inscrito VALUES( " 
                + codEv + ", "+numEd+ ", "+idPart+ ",TO_DATE('" +dataInsc+"','YYYY-MM-DD'), " +tipoApresentador+")";
        System.out.println("Insert statement: " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);

    }
    
    /**
     * cria e retorna um arraylist de string com os dados de um inscrito de acordo com os parametros de entrada
     * @param codEv
     * @param numEd
     * @param idPart
     * @return details - arraylist de strings com os dados de um particante
     * @throws SQLException
     * @throws ParseException
     */
    public static ArrayList<String> buscar(Integer codEv, Integer numEd,Integer idPart) throws SQLException, ParseException{
        String selectTableSQL = "SELECT codEv, numEd, idPart, TO_CHAR(dataInsc, 'DD-MM-YYYY'), tipoApresentador"
                + " FROM Inscrito WHERE codEv = " + codEv +" AND numEd = " + numEd + ""
                + " AND idPart = "+idPart;
        System.out.println(selectTableSQL);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<String>();
        rs.next();
        for(int i=1; i<=5;i++){
            
            details.add(rs.getString(i));
        }
        rs.close();
        return details;
    }
    
    /**
     * busca o id de todos os inscritos em um dado evento e edição
     * @param codEv
     * @param numEd
     * @return details- arraylist com os id de particpantes de acordo com a entrada
     * @throws SQLException
     * @throws ParseException
     */
    public static ArrayList<String> buscarInscritos(Integer codEv, Integer numEd) throws SQLException, ParseException{
        String selectTableSQL = "SELECT idPart "
                + " FROM Inscrito WHERE codEv = " + codEv +" AND numEd = " + numEd + "";
        System.out.println(selectTableSQL);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<String>();
        while(rs.next()){  
            details.add(rs.getString("idPart"));
        }
        rs.close();
        return details;
    }
    
    /**
     * busca o id de todos os apresentadores em um dado evento e edição
     * @param codEv
     * @param numEd
     * @return model - comboBox com os id dos participantes
     * @throws SQLException
     * @throws ParseException
     */
    public static DefaultComboBoxModel getApr(Integer codEv, Integer numEd) throws SQLException, ParseException{
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String selectTableSQL = "SELECT idPart FROM Inscrito WHERE codEv = " + codEv +" AND numEd = " + numEd +" AND tipoApresentador = '1'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        model.addElement(" --- ");
        while(rs.next()){
            model.addElement(PessoaBD.getEmailById(Integer.parseInt(rs.getString("idPart"))));
        }
        rs.close();
        return model;
    }
    
    
    /**
     * busca o id de todos os autores em um dado evento e edição
     * @param codEv
     * @param numEd
     * @return model - comboBox com os id dos participantes
     * @throws SQLException
     * @throws ParseException
     */
    public static DefaultComboBoxModel getAut(Integer codEv, Integer numEd) throws SQLException, ParseException{
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String selectTableSQL = "SELECT idPart FROM Inscrito WHERE codEv = " + codEv +" AND numEd = " + numEd ;
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        model.addElement(" --- ");
        while(rs.next()){
            ArrayList<String> details = PessoaBD.buscar(Integer.parseInt(rs.getString("idPart")));
            Integer tipoAut = Integer.parseInt(details.get(9));
            if(tipoAut==1){
                model.addElement(PessoaBD.getEmailById(Integer.parseInt(rs.getString("idPart"))));
            }
        }
        rs.close();
        return model;
    }
    
    /**
     * cria um update statement na tabela inscrito
     * @param codEv
     * @param numEd
     * @param idPart
     * @param dataInsc
     * @param tipoApresentador
     * @throws SQLException
     */
    public static void atualizar(Integer codEv, Integer numEd,Integer idPart,
        String dataInsc, Integer tipoApresentador) throws SQLException{
        String update = "UPDATE Inscrito SET dataInsc = TO_DATE('" +dataInsc+"','YYYY-MM-DD')"
                + ",tipoApresentador = " +tipoApresentador+ 
                " WHERE numEd = '" + numEd + "' and idPart = '" + idPart +"' and codEv = '" + codEv + "'";
        System.out.println("insert statement " + update);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(update);
    }
    
   /**
     * cria e executa um delete statement na tabela inscrito
     * @param codEv
     * @param numEd
     * @param idPart
     * @throws SQLException
     */
    public static void excluir(Integer codEv, Integer numEd,Integer idPart) throws SQLException{
        String delete = "DELETE FROM Inscrito WHERE numEd = '" + numEd +"' and idPart = '" + idPart + "' and codEv = '" + codEv + "'";
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(delete);
    }
    
   /**
     * busca os eventos de um dado participante
     * @param idPart
     * @return model - comboBox com os codigos dos eventos
     * @throws SQLException
     */
    public static DefaultComboBoxModel getPartEvents(Integer idPart) throws SQLException{
        int i=1;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox ev = new JComboBox();
        ev.isEditable();
        String selectSql = "SELECT codEv from Inscrito WHERE idPart = "+idPart+"";
        System.out.println(selectSql);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        model.addElement(" --- ");
        while(rs.next()){
            System.out.println(rs.getString("codEv"));
            model.addElement(EventoBD.getNameByCode(rs.getString("codEv")));
            i++;
        }
       return model;
    }
    
    /**
     * busca os participantes de um dado evento
     * @param codEv
     * @param numEd
     * @return model - comboBox com os id dos participantes
     * @throws SQLException
     */
    public static DefaultComboBoxModel getEventParts(Integer codEv, Integer numEd) throws SQLException{
        int i=1;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox ev = new JComboBox();
        ev.isEditable();
        String selectSql = "SELECT idPart from Inscrito WHERE codEv = "+codEv+" AND numEd="+numEd+"";
        System.out.println(selectSql);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        model.addElement(" --- ");
        while(rs.next()){
            System.out.println(rs.getString("idPart"));
            model.addElement(PessoaBD.getEmailById(Integer.parseInt(rs.getString("idPart"))));
            i++;
        }
       return model;
    }
    
    
   /**
     * busca os participantes de uma dada edicao
     * @param codEv
     * @param numEd
     * @return model - comboBox com os id dos participantes
     * @throws SQLException
     */
    public static DefaultComboBoxModel getEditionParts(Integer codEv, Integer numEd) throws SQLException{
        int i=1;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox ev = new JComboBox();
        ev.isEditable();
        String selectSql = "SELECT idPart from Inscrito WHERE numEd = "+numEd+" AND codEv ="+codEv+"";
        System.out.println(selectSql);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        model.addElement(" --- ");
        while(rs.next()){
            System.out.println(rs.getString("idPart"));
            model.addElement(PessoaBD.getEmailById(Integer.parseInt(rs.getString("idPart"))));
            i++;
        }
       return model;
    }
    
    
    
   /**
     * busca as edicoes de um dado participante
     * @param codEv
     * @param idPart
     * @return model - comboBox com as edicoes
     * @throws SQLException
     */
    public static DefaultComboBoxModel getPartEditions(Integer codEv, Integer idPart) throws SQLException{
        int i=1;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox ev = new JComboBox();
        ev.isEditable();
        String selectSql = "SELECT numEd from Inscrito WHERE idPart = "+idPart+" AND codEv ="+codEv+"";
        System.out.println(selectSql);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        model.addElement(" --- ");
        while(rs.next()){
            System.out.println(rs.getString("numEd"));
            model.addElement(rs.getString("numEd"));
            i++;
        }
       return model;
    }   
}
