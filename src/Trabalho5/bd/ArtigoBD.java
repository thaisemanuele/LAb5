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
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

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
    
    public static ArrayList<String> buscar(Integer idArt) throws SQLException, ParseException{
        String selectTableSQL = "SELECT tituloArt, TO_CHAR(dataApresArt, 'DD-MM-YYYY'),"
                + "TO_CHAR(horaApresArt, 'HH24:MI'), codEv, numEd,idApr"
                + " FROM Artigo WHERE idArt = " + idArt;
        System.out.println(selectTableSQL);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<String>();
        rs.next();
        for(int i=1; i<=6;i++){
            
            details.add(rs.getString(i));
        }
        rs.close();
        return details;
    }
    
    public static DefaultComboBoxModel getArtigos(Integer codEv, Integer numEd) throws SQLException, ParseException{
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String selectTableSQL = "SELECT idArt FROM Artigo WHERE codEv = " + codEv +" AND numEd = " + numEd + "";
        System.out.println(selectTableSQL);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        model.addElement(" --- ");
        while(rs.next()){
            model.addElement(rs.getString("idArt"));
        }
        rs.close();
        return model;
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
