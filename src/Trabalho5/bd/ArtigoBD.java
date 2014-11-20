/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho5.bd;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

/**
 *
 * @author Thais
 */
public class ArtigoBD {
    
    public static void inserir(String tituloArt, String dataApresArt, String horaApresArt, 
            Integer codEv, Integer numEd,Integer idApr) throws SQLException, ParseException{
            String insert = "INSERT INTO Artigo VALUES( " +
                getSeq()+ ", '"+tituloArt+"',TO_DATE('" +dataApresArt+"','YYYY-MM-DD'), TO_DATE('"
                    +horaApresArt+"', 'HH24:MI')"+ ", "+codEv + ", "+numEd+ ", "+idApr+")";
        System.out.println("insert statement " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);

    }
    
    private static Integer getSeq()throws SQLException{
        String selectSql = "SELECT max(idArt) from Artigo";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        int seqIdPe = -1;
        if(rs.next()){
            seqIdPe = rs.getInt(1);
        }
       return seqIdPe + 1;  
    }
}
