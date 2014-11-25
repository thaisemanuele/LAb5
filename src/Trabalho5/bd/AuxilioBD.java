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

public class AuxilioBD {
    
    public static void inserir(String cnpj, Integer codEv, Integer numEd,Integer idApr,String valor,
        String dataInsc, String tipoAux) throws SQLException, ParseException{
            String insert = "INSERT INTO Auxilio VALUES( '"+cnpj+"', " + codEv + ", "+numEd+ ", "
                    + " " + codEv + ", "+numEd+ ", "+idApr+ ", "
                    + ""+valor+", TO_DATE('" +dataInsc+"','YYYY-MM-DD'), '" +tipoAux+"')";
        System.out.println("Insert statement: " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);

    }
    
    public static ArrayList<String> buscarPorTipoAux(Integer codEv, Integer numEd, String tipoAux) 
            throws SQLException, ParseException{
        
        String selectTableSQL = "SELECT idApr "
                + " FROM Auxilio WHERE codEvApr = " + codEv +" AND numEdApr = " + numEd + "" 
                + " AND tipoAux = '"+tipoAux+"'";
        System.out.println("Select statement " + selectTableSQL);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<>();
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
        ArrayList<String> details = new ArrayList<>();
        rs.next();
        for(int i=1; i<=9;i++){
            details.add(rs.getString(i));
        }
        rs.close();
        return details; 
     }
        
        public static void atualizar(Integer codEvApr, Integer numEdApr, Integer idApr, String valorAux, 
                 String dataAux, String tipoAux) throws SQLException, ParseException{
        String selectTableSQL = "UPDATE Auxilio  SET valorAux = '"+valorAux+"', dataAux = TO_DATE('" +dataAux+"','YYYY-MM-DD')"
                + " WHERE codEvApr = " + codEvApr +" AND numEdApr = " 
                + numEdApr + " AND idApr = "+idApr  + " AND tipoAux = '"+tipoAux+"'";
        System.out.println("Update statemente: " + selectTableSQL);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(selectTableSQL);
     }
        
        public static DefaultComboBoxModel getCnpjPat(Integer codEv, Integer numEd) throws SQLException{
         int i=1;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
          String selectSQL = "SELECT cnpjPat FROM Patrocinio "
                + "WHERE codEv = " + codEv + " AND numEd = " +numEd+ "";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSQL);
        model.addElement(" --- ");
        while(rs.next()){
            
            model.addElement(rs.getString("cnpjPat"));
            i++;
        }
       return model;
    }
        public static DefaultComboBoxModel getNamePat(Integer codEv, Integer numEd) throws SQLException{
         int i=1;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
          String selectSQL = "SELECT cnpjPat FROM Patrocinio "
                + "WHERE codEv = " + codEv + " AND numEd = " +numEd+ "";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSQL);
        model.addElement(" --- ");
        while(rs.next()){
            
            model.addElement(PatrocinadorBD.getName(rs.getString("cnpjPat")));
            i++;
        }
       return model;
    }
 }

