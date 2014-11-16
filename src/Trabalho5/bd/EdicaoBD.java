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
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Thais
 */
public class EdicaoBD {
    
    public Integer codEv;
    public Integer numEd;
    public String descricaoEd;
    public String dataIni;
    public String dataFim;
    public String localEd;
    public String taxaEd;
   

    public EdicaoBD(Integer codEv, Integer numEd, String descricaoEd, String dataIni, String dataFim, String localEd, String taxaEd) {
        this.codEv = codEv;
        this.numEd = numEd;
        this.descricaoEd = descricaoEd;
        this.dataIni = dataIni;
        this.dataFim = dataFim;
        this.localEd = localEd;
        this.taxaEd = taxaEd;
    }
  
    public static void inserir(Integer codEv, Integer numEd, String descricaoEd, 
            String dataIni, String dataFim, String localEd, String taxaEd) throws SQLException{
        
        String insert = "INSERT INTO Edicao VALUES( " 
                + codEv + ", "+ numEd +", '" +descricaoEd+ "','" 
                    +dataIni+ "','"+dataFim+"','"+localEd+"','"+taxaEd+"')";
        System.out.println("insert statement " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);

    }
    
    public static void atualizar(Integer codEv, Integer numEd,String descricaoEd, 
            String dataInicioEd, String dataFimEd, String localEd, String taxaEd) throws SQLException{
        String update = "UPDATE Edicao SET descricaoEd = '" 
                +descricaoEd+ "',dataInicioEd = '" +dataInicioEd+"',dataFimEd = '" +dataFimEd+
                "',localEd = '" +localEd+"',taxaEd = '" +taxaEd+ 
                " WHERE numEd = '" + numEd + "' and codEv = '" + codEv + "'";
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(update);
    }
    
    public static void excluir(Integer codEv, Integer numEd) throws SQLException{
        String delete = "DELETE FROM Edicao WHERE numEd = '" + numEd + "' and codEv = '" + codEv + "'";
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(delete);
    }
    
    public static void buscar(Integer codEv, Integer numEd) throws SQLException, ParseException{
        String selectTableSQL = "SELECT descricaoEd, dataInicioEd, dataFimEd, localEd, taxaEd  "
                + " FROM Edicao WHERE numEd = '" + numEd + "' and codEv = '" + codEv + "'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
    }
    
    public static DefaultComboBoxModel getEditions(Integer codEv) throws SQLException{
         int i=1;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String selectSql = "SELECT NumEd from Edicao WHERE codEv = '" + codEv + "'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        model.addElement(" --- ");
        while(rs.next()){
            
            model.addElement(rs.getString("NumEd"));
            i++;
        }
       return model;
    }
}