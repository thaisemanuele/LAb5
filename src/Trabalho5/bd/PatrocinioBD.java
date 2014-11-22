/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Trabalho5.bd;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gabriela
 */
public class PatrocinioBD {
    
        public static void inserir(String cnpj, Integer codEv, Integer numEd, String valorPat, String data) throws SQLException{
        
        String insert = "INSERT INTO Patrocinio VALUES( " + cnpj + ", " +codEv+ "," +numEd+ ", " +valorPat+", " + 0 +",  TO_DATE('" +data+"','YYYY-MM-DD'))";
        System.out.println("insert statement " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);

    }
    
}
