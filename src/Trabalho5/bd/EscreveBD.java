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
public class EscreveBD {
    
    public static void inserir(Integer idAut, Integer idArt) throws SQLException, ParseException{
        String insert = "INSERT INTO Escreve VALUES( " +idAut+ ", "+idArt+")";
        System.out.println("insert statement " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);
    }
    
}
