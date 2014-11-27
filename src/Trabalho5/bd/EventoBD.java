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
 * @author Clayton
 */
public class EventoBD {
    
    public Integer codEv;
    public String nomeEv;
    public String descricaoEv;
    public String website;
    public int totalArtigosApresentados;
    public static int seqCodEv;
    
    
    public EventoBD(Integer codEv, String nomeEv, String descricaoEv, String website){
        this.codEv = codEv;
        this.nomeEv = nomeEv;
        this.descricaoEv = descricaoEv;
        this.website = website;
        this.totalArtigosApresentados = 0;
        
    }
    
    private EventoBD(Integer codEv, String nomeEv, String descricaoEv, String website, Integer TotalArtigosApresentados){
        this.codEv = codEv;
        this.nomeEv = nomeEv;
        this.descricaoEv = descricaoEv;
        this.website = website;
        this.totalArtigosApresentados = TotalArtigosApresentados;
        
    }
    
    /**
     * Cria e executa um insert statement na tabela de evento
     * @param nomeEv - nome do evento
     * @param descricaoEv - descrição do evento
     * @param website -website do evento
     * @throws SQLException - se houver algum erro com o sql
     */
    public static void inserir(String nomeEv, String descricaoEv, String website) throws SQLException{
        
        String insert = "INSERT INTO Evento VALUES( " + getSeq() + ", '" +nomeEv+ "','" +descricaoEv+ "', '" +website+"', " + 0 +" )";
        System.out.println("Insert statement: " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);

    }
    
    /**
     * cria um update statement na tabela evento
     * @param codEv - codigo do evento
     * @param nomeEv = nome do evento
     * @param descricaoEv - descricao do evento
     * @param website - website do evento
     * @throws SQLException - se houver algum erro com o sql
     */
    public static void atualizar(Integer codEv, String nomeEv, String descricaoEv, String website) throws SQLException{
        String update = "UPDATE Evento SET nomeEv = '" +nomeEv+ "',descricaoEv = '" +descricaoEv+ "',websiteEv = '" +website+ "' WHERE codEv = '" + codEv + "'";
        System.out.println("Update statement: " + update);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(update);
    }
    
    /**
     * cria e executa um delete statement
     * @param codEv - codigo do evento
     * @throws SQLException
     */
    public static void excluir(Integer codEv) throws SQLException{
        String delete = "DELETE FROM Evento WHERE codEv = '" + codEv + "'";
        System.out.println("Delete statement: " + delete);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(delete);
    }
    
    /**
     * cria e executa um select statement
     * @param codEv -codigo do evento
     * @return evento - objeto do tipo evento
     * @throws SQLException
     * @throws ParseException
     */
    public static EventoBD buscar(Integer codEv) throws SQLException, ParseException{
        String selectTableSQL = "SELECT codEv, nomeEv, descricaoEv, website, totalArtigosApresentados, tipo FROM Evento WHERE codEv = '" + codEv + "'";
        System.out.println("Select statement " + selectTableSQL);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
             
        if (rs.next()) return new EventoBD(rs.getInt("codeEv"), rs.getString("nomeEv"),rs.getString("descricaoEv"), rs.getString("website"),rs.getInt("totalArtigosApresentados"));
        else return null;
    }
    
    /**
     * retorna um arraylist de strings de acordo com o parametro de entrada
     * @param codEv - codigo do evento
     * @return details - arraylist de string com os dados de um evento
     * de acordo com a entrada
     * @throws SQLException - se der erro no sql
     * @throws ParseException
     */
    public static ArrayList<String> fetchEvent(String codEv) throws SQLException, ParseException{
        String selectTableSQL = "SELECT codEv, nomeEv, descricaoEv, websiteEv FROM Evento WHERE codEv = '" + codEv + "'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<>();
        rs.next();
        for(int i=1; i<=4;i++){
            
            details.add(rs.getString(i));
        }
        return details;
    }
    
    /**
     * retorna o proximo numero na sequencia de eventos
     * @return details - arraylist de string com os dados de um evento
     * @throws SQLException - se der erro no sql
     */
    private static Integer getSeq()throws SQLException{
        String selectSql = "SELECT max(codEv) from Evento";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        if(rs.next()){
            seqCodEv = rs.getInt(1);
        }
       return seqCodEv + 1;  
    }
    
    /**
     * cria e retorna uma combobox com os codigos dos eventos
     * @return model - combobox com os cofigos dos eventos
     * @throws SQLException - se der algum erro no sql
     */
    public static DefaultComboBoxModel getEventsCode() throws SQLException{
         int i=1;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox codes = new JComboBox();
        codes.isEditable();
        String selectSql = "SELECT codEv from Evento";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        model.addElement(" --- ");
        while(rs.next()){
            
            model.addElement(rs.getString("codEv"));
            i++;
        }
       return model;
    }
     
    /**
     * Cria e retorna um combobox com os nomes dos eventos
     * @return model - comboBox com 0s nomes dos eventos
     * @throws SQLException
     */
    public static DefaultComboBoxModel getEventsName() throws SQLException{
         int i=1;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String selectSql = "SELECT NomeEv from Evento";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        model.addElement(" --- ");
        while(rs.next()){
            
            model.addElement(rs.getString("NomeEv"));
            i++;
        }
       return model;
    }
    
    /**
     * retorna arraylist com os cadoas do evento
     * @param nomeEv - nome do evento
     * @return details - arraylist com os dados de ume evento de acordo com o dado
     * de entrada
     * @throws SQLException
     * @throws ParseException
     */
    public static ArrayList<String> fetchNameEvent(String nomeEv) throws SQLException, ParseException{
        String selectTableSQL = "SELECT codEv, nomeEv, descricaoEv, websiteEv FROM Evento WHERE nomeEv = '" + nomeEv + "'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<>();
        rs.next();
        for(int i=1; i<=4;i++){
            
            details.add(rs.getString(i));
        }
        return details;
    }
     
    /**
     * de acordo com o parametro de entrada retorna o codigo do evento
     * @param name - nome do evento
     * @return id - codigo do evento
     * @throws SQLException
     */
    public static Integer getCodeByName(String name) throws SQLException{
        Integer id = -1;
        String selectSql = "SELECT codEv from Evento WHERE nomeEv = '"+name+"'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        if(rs.next()){
            id = Integer.parseInt(rs.getString("codEv"));
        }
       return id;
    }
     
    /**
     * de acordo com o codigo de entrada encontra o nome do evento
     * @param code - codigo do evento
     * @return i nome do evento
     * @throws SQLException
     */
    public static String getNameByCode(String code) throws SQLException{
        String name = null;
        String selectSql = "SELECT nomeEv from Evento WHERE codEv = '"+code+"'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        if(rs.next()){
            name = rs.getString("nomeEv");
        }
       return name;
    }
}
