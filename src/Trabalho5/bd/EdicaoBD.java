/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho5.bd;

import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
  
    /**
     * Cria e executa um insert statement
     * @param codEv -codigo do evento
     * @param numEd - numero da edicao
     * @param descricaoEd - descrição do evento
     * @param dataInicioEd - data de inicio da edição do evento
     * @param dataFimEd -  data de fim da edição do evento
     * @param localEd -  local da edição
     * @param taxaEd - taxa da edição
     * @throws SQLException - se houver algum erro com o sql statemente
     * @throws ParseException - se a data estiver no formato incorreto
     */
    public static void inserir(Integer codEv, Integer numEd, String descricaoEd, 
            String dataInicioEd, String dataFimEd, String localEd, String taxaEd) throws SQLException, ParseException{
        String insert = "INSERT INTO Edicao VALUES( " 
                + codEv + ", "+ numEd +", '" +descricaoEd+ "',TO_DATE('" +dataInicioEd+"','YYYY-MM-DD')"+",TO_DATE('" +dataFimEd+"','YYYY-MM-DD')" +",'"+localEd+"',"+taxaEd+","+0+","+0+")";
        System.out.println("Insert statement: " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);

    }
    
    /**
     * Cria e executa um update statement
     * @param codEv
     * @param numEd
     * @param descricaoEd
     * @param dataInicioEd
     * @param dataFimEd
     * @param localEd
     * @param taxaEd
     * @throws SQLException
     */
    public static void atualizar(Integer codEv, Integer numEd,String descricaoEd, 
            String dataInicioEd, String dataFimEd, String localEd, String taxaEd) throws SQLException{
        String update = "UPDATE Edicao SET descricaoEd = '" 
                +descricaoEd+ "',dataInicioEd = TO_DATE('" +dataInicioEd+"','YYYY-MM-DD')"+",dataFimEd = TO_DATE('" +dataFimEd+"','YYYY-MM-DD')"+
                ",localEd = '" +localEd+"',taxaEd = " +taxaEd+ 
                " WHERE numEd = '" + numEd + "' and codEv = '" + codEv + "'";
        System.out.println("insert statement " + update);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(update);
    }
    
    /**
     * Cria e executa um delete stqtemente de acordo com a entrada
     * @param codEv
     * @param numEd
     * @throws SQLException
     */
    public static void excluir(Integer codEv, Integer numEd) throws SQLException{
        String delete = "DELETE FROM Edicao WHERE numEd = '" + numEd + "' and codEv = '" + codEv + "'";
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(delete);
    }
    
    /**
     * Cria e retorna um arraylist com os dados de um evento de acordo com os parametros de entrada
     * @param codEv
     * @param numEd
     * @return details - arraylist com os dados de um evento
     * @throws SQLException
     * @throws ParseException
     */
    public static ArrayList<String> buscar(Integer codEv, Integer numEd) throws SQLException, ParseException{
        String selectTableSQL = "SELECT codEv, numEd, descricaoEd, TO_CHAR(dataInicioEd, 'DD-MM-YYYY'), "
                + "TO_CHAR(dataFimEd, 'DD-MM-YYYY'), localEd, TO_CHAR ( taxaEd, 'FML999G999D99'), saldoFinanceiroEd, qtdArtigosApresentadosEd"
                + " FROM Edicao WHERE numEd = '" + numEd + "' and codEv = '" + codEv + "'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<String>();
        rs.next();
        for(int i=1; i<=9;i++){
            
            details.add(rs.getString(i));
        }
        return details;
    }
    
    /**
     * Cria e retorna uma combobox com os numeros de edicao de acordo com o parametro de entrada
     * @param codEv - codigo do evento
     * @return model - combobox com os numeros de edicao
     * @throws SQLException
     */
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
