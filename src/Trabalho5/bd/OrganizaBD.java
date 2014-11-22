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
        System.out.println("insert statement " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);
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
