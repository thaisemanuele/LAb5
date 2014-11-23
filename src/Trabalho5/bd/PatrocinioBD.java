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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Gabriela
 */
public class PatrocinioBD {
    
        public static void inserir(String cnpj, Integer codEv, Integer numEd, String valorPat, String data) throws SQLException{
        
            String insert = "INSERT INTO Patrocinio VALUES( '" + cnpj + "', " +codEv+ "," +numEd+ ", " +valorPat+", " + 0 +",  TO_DATE('" +data+"','YYYY-MM-DD'))";
            System.out.println("insert statement " + insert);
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate(insert);
        }
        
        public static ArrayList<String> buscar(String cnpjPat, Integer codEv,Integer numEd) throws SQLException, ParseException{
            
            String selectTableSQL = "SELECT cnpjPat, codEv, numEd, valorPat, saldoPat,"
                    + "TO_CHAR(dataPat, 'DD-MM-YYYY') " 
                    +"FROM Patrocinio WHERE cnpjPat = '"+cnpjPat+"' AND numEd = '" + numEd + "' and codEv = '" + codEv + "'";
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            ArrayList<String> details = new ArrayList<String>();
            rs.next();
            for(int i=1; i<=6;i++){

                details.add(rs.getString(i));
            }
            return details;
        }
        
        public static void atualizar(String cnpjPat, Integer codEv, Integer numEd, String valorPat, 
                String dataPat) throws SQLException{
            
            String update = "UPDATE Patrocinio SET valorPat = " 
                    +valorPat+ ", dataPat = TO_DATE('" +dataPat+"','YYYY-MM-DD')"+
                    " WHERE cnpjPat = '"+cnpjPat+"' AND numEd = " + numEd + " and codEv = " + codEv + "";
            System.out.println("update statement " + update);
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate(update);
        }
        
        public static void excluir(String cnpjPat,Integer codEv, Integer numEd) throws SQLException{
            String delete = "DELETE FROM Patrocinio WHERE cnpjPat = '"+cnpjPat+"' AND numEd = '" + numEd + "' and codEv = '" + codEv + "'";
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate(delete);
        }
    
        
        public static DefaultComboBoxModel buscarPat(Integer codEv, Integer numEd)throws SQLException{
            
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            String selectSql = "SELECT cnpjPat FROM Patrocinio WHERE codEv = "
                    +codEv+" AND numEd = "+numEd;
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectSql);
            model.addElement(" --- ");
            while(rs.next()){
                
                model.addElement(PatrocinadorBD.getName(rs.getString("cnpjPat")));
            }
             return model;
        
        }
    
}