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
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Thais
 */
public class OrganizaBD {
    
    public static void inserir(Integer idOrg, Integer codEv, Integer numEd, String cargoOrg) throws SQLException, ParseException{
        String insert = "INSERT INTO Organiza VALUES( " +idOrg+ ", "+codEv+ ", "+numEd+ ", '"+cargoOrg+"')";
        System.out.println("Insert statement: " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);
    }
    
    public static void atualizar(Integer idOrg, Integer codEv,Integer numEd, String cargoOrg) throws SQLException{
        String update = "UPDATE Organiza SET cargoOrg = '" 
                +cargoOrg+ "' WHERE idOrg = " + idOrg +" AND codEv = "+codEv+" AND numEd = "+numEd;
        System.out.println("Update statement: " + update);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(update);
    }
    
    public static void excluir(Integer idOrg, Integer codEv,Integer numEd) throws SQLException{
        String delete = "DELETE FROM Organiza WHERE idOrg = '" 
                + idOrg +"' and codEv = '" + codEv + "' and numEd = '" + numEd + "'";
        System.out.println("Delete statement: " + delete);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(delete);
    }
    
    public static DefaultComboBoxModel getOrgs(Integer codEv, Integer numEd) throws SQLException{
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String selectSql = "SELECT idOrg from Organiza WHERE codEv = "+codEv+" AND numEd = "+numEd;
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        model.addElement(" --- ");
        while(rs.next()){
            model.addElement(PessoaBD.getEmailById(Integer.parseInt(rs.getString("idOrg"))));
        }
       return model;
    }
    
    public static String getCargo(Integer codEv, Integer numEd, Integer idOrg) throws SQLException{
        String cargo = new String();
        String selectSql = "SELECT cargoOrg from Organiza WHERE codEv = "
                +codEv+" AND numEd = "+numEd+" AND idOrg = "+idOrg;
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        if(rs.next()){
            cargo = rs.getString("cargoOrg");
        }
       return cargo;
    }
}
