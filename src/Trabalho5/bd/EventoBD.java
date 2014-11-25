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
    
    public static void inserir(String nomeEv, String descricaoEv, String website) throws SQLException{
        
        String insert = "INSERT INTO Evento VALUES( " + getSeq() + ", '" +nomeEv+ "','" +descricaoEv+ "', '" +website+"', " + 0 +" )";
        System.out.println("Insert statement: " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);

    }
    
    public static void atualizar(Integer codEv, String nomeEv, String descricaoEv, String website) throws SQLException{
        String update = "UPDATE Evento SET nomeEv = '" +nomeEv+ "',descricaoEv = '" +descricaoEv+ "',websiteEv = '" +website+ "' WHERE codEv = '" + codEv + "'";
        System.out.println("Update statement: " + update);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(update);
    }
    
    public static void excluir(Integer codEv) throws SQLException{
        String delete = "DELETE FROM Evento WHERE codEv = '" + codEv + "'";
        System.out.println("Delete statement: " + delete);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(delete);
    }
    
    public static EventoBD buscar(Integer codEv) throws SQLException, ParseException{
        String selectTableSQL = "SELECT codEv, nomeEv, descricaoEv, website, totalArtigosApresentados, tipo FROM Evento WHERE codEv = '" + codEv + "'";
        System.out.println("Select statement " + selectTableSQL);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
             
        if (rs.next()) return new EventoBD(rs.getInt("codeEv"), rs.getString("nomeEv"),rs.getString("descricaoEv"), rs.getString("website"),rs.getInt("totalArtigosApresentados"));
        else return null;
    }
    
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
    
    private static Integer getSeq()throws SQLException{
        String selectSql = "SELECT max(codEv) from Evento";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        if(rs.next()){
            seqCodEv = rs.getInt(1);
        }
       return seqCodEv + 1;  
    }
    
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
