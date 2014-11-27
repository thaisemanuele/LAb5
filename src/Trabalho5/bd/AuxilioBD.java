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
    
    /**
     * recebe os parametros de entrada e cria um insert statement
     * para a tabela auxilio
     * @param cnpj - cnpj do patrocinador
     * @param codEv - codigo do evento
     * @param numEd - numero da edicao
     * @param idApr - id do apresentador
     * @param valor - valor do auxilio
     * @param dataInsc - data de recebimento do auxilio
     * @param tipoAux - tipo do auxilio
     * @throws SQLException - se houver um erro com o sql statement
     * @throws ParseException - se a data não estiver no formato correto
     */
    public static void inserir(String cnpj, Integer codEv, Integer numEd,Integer idApr,String valor,
        String dataInsc, String tipoAux) throws SQLException, ParseException{
            String insert = "INSERT INTO Auxilio VALUES( '"+cnpj+"', " + codEv + ", "+numEd+ ", "
                    + " " + codEv + ", "+numEd+ ", "+idApr+ ", "
                    + ""+valor+", TO_DATE('" +dataInsc+"','YYYY-MM-DD'), '" +tipoAux+"')";
        System.out.println("Insert statement: " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);

    }
    
    /**
     * Retorna uma lista de strings com os id dos apresentadores
     * @param codEv - codigo do evento
     * @param numEd - numero da edicao
     * @param tipoAux - tipo de auxllio
     * @return details - arraylist<String> com os idApr dos apresentadores
     * de acordo com os parametros de entrada
     * @throws SQLException - se houver um erro com o sql statement
     */
    public static ArrayList<String> buscarPorTipoAux(Integer codEv, Integer numEd, String tipoAux) 
            throws SQLException{
        
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
 
    /**
     * Retorna uma collection de strings com os dados de um auxilio de acordo com
     * os parametros de entrada
     * @param codEvApr - codigo do evento do apresentador
     * @param numEdApr -  numero da edicao do apresentador
     * @param idApr - id do apresentador
     * @param tipoAux - tipo de auxilio
     * @return details - arraylist com os dados de um auxilio
     * @throws SQLException - se houver um erro com o sql statement
     * @throws ParseException - se a data não estiver no formato correto
     */
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
        
    /**
     * Cria e executa um update statement na tabela auxilio
     * @param codEvApr - codigo do evento do apresentador
     * @param numEdApr -  numero da edicao do apresentador
     * @param idApr - id do apresentador
     * @param valorAux - valor do auxilio
     * @param dataAux - data do auxilio
     * @param tipoAux - tipo do auxilio
     * @throws SQLException - se houver um erro com o sql statement
     * @throws ParseException - se a data não estiver no formato correto
     */
    public static void atualizar(Integer codEvApr, Integer numEdApr, Integer idApr, String valorAux, 
                 String dataAux, String tipoAux) throws SQLException, ParseException{
        String selectTableSQL = "UPDATE Auxilio  SET valorAux = '"+valorAux+"', dataAux = TO_DATE('" +dataAux+"','YYYY-MM-DD')"
                + " WHERE codEvApr = " + codEvApr +" AND numEdApr = " 
                + numEdApr + " AND idApr = "+idApr  + " AND tipoAux = '"+tipoAux+"'";
        System.out.println("Update statemente: " + selectTableSQL);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(selectTableSQL);
    }
    
    /**
     * Cria e executa um delete statement na tabela auxilio
     * @param codEvApr - codigo do evento do apresentador
     * @param numEdApr - numero da edicao do apresentador
     * @param idApr - id do apresentador 
     * @param tipoAux - tipo de auxilio
     * @throws SQLException se houver algum erro no sql statement
     */
    public static void excluir(Integer codEvApr, Integer numEdApr, Integer idApr, String tipoAux) throws SQLException{
            String delete = "DELETE FROM Auxilio WHERE codEvApr = '"+codEvApr
                    +"' AND numEdApr = '" + numEdApr + "' and idApr = " 
                    +idApr  + " AND tipoAux = '"+tipoAux+"'";
            System.out.println("Delete statement: " + delete);
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate(delete);
        }
        
    /**
     * Cria e preenche uma comboBox com os cnpj dos patrocinadores de um dado evento e uma dada edicao
     * @param codEv - codigo do evento
     * @param numEd - numero da edicao
     * @return model - Combobox preenchida
     * @throws SQLException - se houver algum erro no sql statement
     */
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

    /**
     * Cria e preenche uma combobox com o nome dos patrocinadores de um dado evento e uma dada ediçao
     * @param codEv - codigo do evento
     * @param numEd - numero da edicao
     * @return model - Combobox preenchida
     * @throws SQLException - se houver algum erro no sql statement
     */
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

