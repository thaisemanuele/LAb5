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
    
    public static void inserir(Integer codEv, Integer numEd,Integer idPart,
        String dataInsc, Integer tipoApresentador) throws SQLException, ParseException{
            String insert = "INSERT INTO Inscrito VALUES( " 
                + codEv + ", "+numEd+ ", "+idPart+ ",TO_DATE('" +dataInsc+"','YYYY-MM-DD'), " +tipoApresentador+")";
        System.out.println("insert statement " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);

    }
    
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
    
    public static DefaultComboBoxModel getApr(Integer codEv, Integer numEd) throws SQLException, ParseException{
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String selectTableSQL = "SELECT idPart FROM Inscrito WHERE codEv = " + codEv +" AND numEd = " + numEd +" AND tipoApresentador = '1'";
        System.out.println(selectTableSQL);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        model.addElement(" --- ");
        while(rs.next()){
            model.addElement(PessoaBD.getEmailById(Integer.parseInt(rs.getString("idPart"))));
        }
        rs.close();
        return model;
    }
    
    public static void atualizar(Integer codEv, Integer numEd,Integer idPart,
        String dataInsc, Integer tipoApresentador) throws SQLException{
        String update = "UPDATE Inscrito SET dataInsc = TO_DATE('" +dataInsc+"','YYYY-MM-DD')"
                + ",tipoApresentador = " +tipoApresentador+ 
                " WHERE numEd = '" + numEd + "' and idPart = '" + idPart +"' and codEv = '" + codEv + "'";
        System.out.println("insert statement " + update);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(update);
    }
    
    public static void excluir(Integer codEv, Integer numEd,Integer idPart) throws SQLException{
        String delete = "DELETE FROM Inscrito WHERE numEd = '" + numEd +"' and idPart = '" + idPart + "' and codEv = '" + codEv + "'";
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(delete);
    }
    
    
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
