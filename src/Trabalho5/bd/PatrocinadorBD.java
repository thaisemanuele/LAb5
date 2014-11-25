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
 * @author Gabriela
 */
public class PatrocinadorBD {
    
    public static void inserir(String cnpjPat, String razaoSocialPat, String telefone, String endereco) throws SQLException{
        
        String insert = "INSERT INTO Patrocinador VALUES( '"+cnpjPat+"', '"+razaoSocialPat+"',"
                + "'"+telefone+"', '" +endereco+"')";
        System.out.println("Insert statement: " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);

    }
    
     public static void atualizar(String cnpj, String nomePat, String tel, String end) throws SQLException{
        String update = "UPDATE Patrocinador SET razaoSocialPat = '" +nomePat+ "', telefonePat = '" 
                +tel+ "', enderecoPat = '" +end+ "' WHERE cnpjPat = '" + cnpj + "'";
        System.out.println("Update statement: " + update);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(update);
    }
     
        public static void excluir(String cnpj) throws SQLException{
        String delete = "DELETE FROM Patrocinador WHERE cnpjPat = '" + cnpj + "'";
        System.out.println("Delete statement: " + delete);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(delete);
    } 
    
    public static DefaultComboBoxModel getPatName() throws SQLException{
         int i=1;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String selectSql = "SELECT razaoSocialPat from Patrocinador";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        model.addElement(" --- ");
        while(rs.next()){
            
            model.addElement(rs.getString("razaoSocialPat"));
            i++;
        }
       return model;
    }
    
        public static String getCnpjByName(String name) throws SQLException{
        String id = null;
        String selectSql = "SELECT cnpjPat from Patrocinador WHERE razaoSocialPat = '"+name+"'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        if(rs.next()){
            id = rs.getString("cnpjPat");
        }
       return id;
    }
        
        
        public static String getName(String cnpjPat) throws SQLException{
            String id = null;
            String selectSql = "SELECT razaoSocialPat from Patrocinador WHERE cnpjPat = '"+cnpjPat+"'";
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectSql);
            if(rs.next()){
                id = rs.getString("razaoSocialPat");
            }
            return id;
        }
    
    public static ArrayList<String> fetchNamePat(String nomePat) throws SQLException, ParseException{
        String selectTableSQL = "SELECT cnpjPat, razaoSocialPat, telefonePat, enderecoPat FROM Patrocinador "
                + "WHERE razaoSocialPat = '" + nomePat + "'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<>();
        rs.next();
        for(int i=1; i<=4;i++){
            
            details.add(rs.getString(i));
        }
        return details;
    }
    
    
}
