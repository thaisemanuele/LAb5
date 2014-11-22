/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho5.bd;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

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
    
}
