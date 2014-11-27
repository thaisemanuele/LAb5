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
public class EscreveBD {
    
    /**
     * Cria e executa um insert statement de acordo com os parametros de entrada
     * @param idAut - id do autor
     * @param idArt - id do artigo
     * @throws SQLException se houver algum problema comsql statement
     * @throws ParseException
     */
    public static void inserir(Integer idAut, Integer idArt) throws SQLException, ParseException{
        String insert = "INSERT INTO Escreve VALUES( " +idAut+ ", "+idArt+")";
        System.out.println("Insert statement: " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);
    }
    
    /**
     * Cria e executa um delete statement 
    * @param idAut - id do autor
     * @param idArt - id do artigo
     * @throws SQLException se houver algum problema comsql statement
     */
     public static void excluir(Integer idAut, Integer idArt) throws SQLException{
        String delete = "DELETE FROM Escreve WHERE idAut = '"+idAut+"' AND idArt = '"+idArt+"'";
        System.out.println("delete statement " + delete);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(delete);
    }
    
    /**
     * Cria e retorna uma DefaultCombobox com o id dos artigos de acordo com o id
     * do autor
     * @param idAut - id do autor
     * @return model - combobox com os id dos artigos
     * @throws SQLException - quando houver algum erro com o sql
     * @throws ParseException
     */
    public static DefaultComboBoxModel getArtigos(Integer idAut) throws SQLException, ParseException{
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String select = "SELECT idArt FROM Escreve WHERE idAut = " +idAut;
        System.out.println("Select statement: " + select);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(select);
        model.addElement(" --- ");
        while(rs.next()){
            model.addElement(rs.getString("idArt"));
        }
        return model;
    }
    
    /**
     * retorna o id dos autores de acordo com os id dos autores
     * @param idArt - id do artigo
     * @return - combobox com os id dos autores
     * @throws SQLException
     * @throws ParseException
     */
    public static DefaultComboBoxModel getAuthors(Integer idArt) throws SQLException, ParseException{
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String select = "SELECT idAut FROM Escreve WHERE idArt = " +idArt;
        System.out.println("select statement " + select);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(select);
        model.addElement(" --- ");
        while(rs.next()){
            model.addElement(PessoaBD.getEmailById(Integer.parseInt(rs.getString("idAut"))));
        }
        return model;
    }
    
}
