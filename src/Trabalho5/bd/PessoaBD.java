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
public class PessoaBD {
    /**
      *Cria e executa um insert statement na tabela pessoa
      * @param nomePe - nome da pessoa
      * @param emailPe - email da pessoa
      * @param instituicaoPe - instituicao a qual a pessoa pertence
      * @param telefonePe - telefone da pessoa
      * @param nacionalidadePe - nacionalidade da pessoa
      * @param enderecoPe - endereco da pessoa
      * @param tipoOrganizador
      * @param tipoParticipante
      * @param tipoAutor
      * @throws SQLException
      * @throws ParseException
      */
    public static void inserir(String nomePe, String emailPe, String instituicaoPe,
            String telefonePe, String nacionalidadePe, String enderecoPe,
            Integer tipoOrganizador, Integer tipoParticipante, Integer tipoAutor) throws SQLException, ParseException{
        Integer idPe = getSeq();
        String insert = "INSERT INTO Pessoa VALUES( " 
                + idPe + ", '"+ nomePe +"', '" +emailPe+ "', '" +instituicaoPe+"',"+"'" +telefonePe
                +"','"+nacionalidadePe+"','"+enderecoPe+"',"+tipoOrganizador+
                ","+tipoParticipante+","+tipoAutor+")";
        System.out.println("Insert statement: " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);

    }
    
    /**
      *Cria um update statement na tabela pessoa
      * @param idPe - id da pessoa
      * @param nomePe - nome da pessoa
      * @param emailPe - email da pessoa
      * @param instituicaoPe - instituicao a qual a pessoa pertence
      * @param telefonePe - telefone da pessoa
      * @param nacionalidadePe - nacionalidade da pessoa
      * @param enderecoPe - endereco da pessoa
      * @param tipoOrganizador
      * @param tipoParticipante
      * @param tipoAutor
      * @throws SQLException
      */
    public static void atualizar(Integer idPe, String nomePe, String emailPe, String instituicaoPe,
            String telefonePe, String nacionalidadePe, String enderecoPe,
            Integer tipoOrganizador, Integer tipoParticipante, Integer tipoAutor) throws SQLException{
        String update = "UPDATE Pessoa SET nomePe = '" 
                +nomePe+ "',emailPe = '" +emailPe+"',instituicaoPe = '" +instituicaoPe+"',telefonePe= '"
                +telefonePe+"',nacionalidadePe = '" +nacionalidadePe+"',enderecoPe = '" +enderecoPe+
                "',tipoOrganizador = " +tipoOrganizador+",tipoParticipante = " +tipoParticipante+
                ",tipoAutor = " +tipoAutor+
                " WHERE idPe = " + idPe +"";
        System.out.println("Update statement: " + update);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(update);
    }
    
    
    /**
      *Cria e executa um delete statement na tabela pessoa
      * @param idPe - id da pessoa
      * @throws SQLException
      */
     public static void excluir(Integer idPe) throws SQLException{
        String delete = "DELETE FROM Pessoa WHERE idPe = '" + idPe + "'";
        System.out.println("Delete statement: " + delete);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(delete);
    }
    
     /**
      * retorna um arraylist de strings de acordo com o id da pessoa
      * @param idPe - id da pessoa
      * @return details - arraylist de string com os dados de uma pessoa dado seu id
      * @throws SQLException
      * @throws ParseException
      */
    public static ArrayList<String> buscar(Integer idPe) throws SQLException, ParseException{
        String selectTableSQL = "SELECT idPe, nomePe, emailPe, instituicaoPe, telefonePe, nacionalidadePe,"
                + " enderecoPe,tipoOrganizador, tipoParticipante, tipoAutor"
                + " FROM Pessoa WHERE idPe = " + idPe +"";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<>();
        rs.next();
        for(int i=1; i<=10;i++){
            
            details.add(rs.getString(i));
        }
        rs.close();
        return details;
    }
    
    /**
     * retorna o proximo numero na sequencia de pessoa
     * @return o proximo inteiro da sequencia 
     * @throws SQLException - se der erro no sql
     */
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
    
    /**
      * retorna um arraylist de strings de acordo com o email da pessoa
      * @param emailPe - email da pessoa
      * @return details - arraylist de string com os dados de uma pessoa dado seu email
      * @throws SQLException
      * @throws ParseException
      */
    public static ArrayList<String> searchByEmail(String emailPe) throws SQLException, ParseException{
        String selectTableSQL = "SELECT idPe, nomePe, emailPe, instituicaoPe, telefonePe, nacionalidadePe,"
                + " enderecoPe,tipoOrganizador, tipoParticipante, tipoAutor"
                + " FROM Pessoa WHERE emailPe = '" + emailPe +"'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<>();
        rs.next();
        for(int i=1; i<=10;i++){
            
            details.add(rs.getString(i));
        }
        rs.close();
        return details;
    }
    
    /**
      * retorna uma comboBox com os id das pessoas
      * @return model - combobox com os id das pessoas
      * @throws SQLException
      */
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
            
            model.addElement(rs.getString("idPe"));
            i++;
        }
       return model;
    }
    
    /**
     * retorna o id da pessoa de acordo com seu email
     * @param email - email da pessoa
     * @return o id da pessoa 
     * @throws SQLException - se der erro no sql
     */
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
    
    /**
     * retorna o email da pessoa de acordo com seu id
     * @param idPe - id da pessoa
     * @return o email da pessoa 
     * @throws SQLException - se der erro no sql
     */
    public static String getEmailById(Integer idPe) throws SQLException{
        String email = new String();
        String selectSql = "SELECT emailPe from Pessoa WHERE idPe = "+idPe+"";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        if(rs.next()){
            email = rs.getString("emailPe");
        }
       return email;
    }
    
    /**
      * retorna uma comboBox com os emails das pessoas
      * @return model - combobox com os emails das pessoas
      * @throws SQLException
      */
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
            
            model.addElement(rs.getString("emailPe"));
            i++;
        }
       return model;
    }
    
    /**
      * retorna uma comboBox com os emails dos autores (pessoas com tipoAutor = 1)
      * @return model - combobox com os emails dos autores
      * @throws SQLException
      */
    public static DefaultComboBoxModel getAuthors()throws SQLException{
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox codes = new JComboBox();
        codes.isEditable();
        String selectSql = "SELECT emailPe from Pessoa WHERE tipoAutor ='1' ORDER BY emailPe ASC";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        model.addElement(" --- ");
        while(rs.next()){
            
            model.addElement(rs.getString("emailPe"));
        }
       return model;
    }
    
    /**
      * retorna uma comboBox com os emails dos organizadores (pessoas com tipoOrganizador = 1)
      * @return model - combobox com os emails dos organizadores
      * @throws SQLException
      */
    public static DefaultComboBoxModel getOrgs()throws SQLException{
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox codes = new JComboBox();
        codes.isEditable();
        String selectSql = "SELECT emailPe from Pessoa WHERE tipoOrganizador ='1' ORDER BY emailPe ASC";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        model.addElement(" --- ");
        while(rs.next()){
            
            model.addElement(rs.getString("emailPe"));
        }
       return model;
    }
}
