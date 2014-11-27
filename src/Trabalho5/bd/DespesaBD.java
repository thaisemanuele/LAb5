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

/**
 *
 * @author Thais
 */
public class DespesaBD {
    
    public static void inserir(Integer codEv, Integer numEd, String cnpjPat, 
            String dataDesp, String valorDesp, String descricaoDesp ) throws SQLException{
        
            String insert = "INSERT INTO Despesa VALUES( "+getSeq()+", "+codEv+ ", " +numEd+ ", '"
                    + cnpjPat +"', '"+codEv+"', '"+numEd+"', TO_DATE('" +dataDesp+"','YYYY-MM-DD'), " +
                    valorDesp+", '" + descricaoDesp +"')";
            System.out.println("Insert statement: " + insert);
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate(insert);
    }
    
    public static ArrayList<String> buscar(Integer codDesp, Integer codEv,Integer numEd) throws SQLException, ParseException{
            
            String selectTableSQL = "SELECT TO_CHAR(dataDesp, 'DD-MM-YYYY'), valorDesp, descricaoDesp " 
                    +"FROM Despesa WHERE codDesp = '"+codDesp+"' AND numEd = '" + numEd + "' and codEv = '" + codEv + "'";
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            ArrayList<String> details = new ArrayList<>();
            rs.next();
            for(int i=1; i<=3;i++){

                details.add(rs.getString(i));
            }
            return details;
        }
    
    public static void atualizar(Integer codDesp, Integer codEv,Integer numEd, String dataDesp,
            String valorDesp, String descricaoDesp) throws SQLException{
            
            String update = "UPDATE Despesa SET valorDesp = " 
                    +valorDesp+ ", dataDesp = TO_DATE('" +dataDesp+"','YYYY-MM-DD')"
                    +", descricaoDesp = '"+descricaoDesp+
                    "' WHERE codDesp = '"+codDesp+"' AND numEd = " + numEd + " and codEv = " + codEv + "";
            System.out.println("Update statement: " + update);
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate(update);
        }
    
    public static void excluir(Integer codDesp, Integer codEv,Integer numEd) throws SQLException{
            String delete = "DELETE FROM Despesa WHERE codDesp = '"+codDesp+"' AND numEd = '" + numEd + "' and codEv = '" + codEv + "'";
            System.out.println("Delete statement: " + delete);
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate(delete);
        }
    
    public static DefaultComboBoxModel getCodes(Integer codEv, Integer numEd, String cnpjPat)throws SQLException{
            
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String selectSql = "SELECT codDesp FROM Despesa WHERE codEv = "
                +codEv+" AND numEd = "+numEd+" AND cnpjPat = '"+cnpjPat+"'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        model.addElement(" --- ");
        while(rs.next()){
                
            model.addElement(rs.getString("codDesp"));
        }
        return model;
    }
    
    private static Integer getSeq()throws SQLException{
        String selectSql = "SELECT max(codDesp) from Despesa";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        int seq = -1;
        if(rs.next()){
            seq = rs.getInt(1);
        }
       return seq + 1;  
    }
}
