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

/**
 *
 * @author Gabriela
 */

public class AuxilioBD {
    
    
    public static ArrayList<String> buscarPorTipoAux(Integer codEv, Integer numEd, String tipoAux) 
            throws SQLException, ParseException{
        
        String selectTableSQL = "SELECT idApr "
                + " FROM Auxilio WHERE codEvApr = " + codEv +" AND numEdApr = " + numEd + "" 
                + " AND tipoAux = '"+tipoAux+"'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<String>();
        while(rs.next()){  
            details.add(rs.getString("idApr"));
        }
        rs.close();
        return details;
    }
        public static ArrayList<String> buscar(Integer codEvApr, Integer numEdApr, Integer idApr, 
                 String tipoAux) throws SQLException, ParseException{
        String selectTableSQL = "SELECT cnpjPat, codEvPat, numEdPat, codEvApr, numEdApr, "
                + "idApr, valorAux, TO_CHAR(dataAux, 'DD-MM-YYYY'), tipoAux"
                + " FROM Auxilio WHERE codEvApr = " + codEvApr +" AND numEdApr = " 
                + numEdApr + " AND idApr = "+idApr  + " AND tipoAux = '"+tipoAux+"'";
        System.out.println(selectTableSQL);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<String>();
        rs.next();
        for(int i=1; i<=9;i++){
            details.add(rs.getString(i));
        }
        rs.close();
        return details; 
     }
 }

