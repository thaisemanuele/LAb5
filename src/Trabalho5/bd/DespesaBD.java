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
    
    /**
    * recebe os parametros de entrada e cria um insert statement
     * para a tabela despesa
     * @param codEv - codigo do evento
     * @param numEd - numedo da edicao
     * @param cnpjPat - cnpj do patrocinador
     * @param dataDesp - data da despesa
     * @param valorDesp - valor da despesa
     * @param descricaoDesp - descrição da despesa
     * @throws SQLException - se houver algo errado com o sql statement
     */
    public static void inserir(Integer codEv, Integer numEd, String cnpjPat, 
            String dataDesp, String valorDesp, String descricaoDesp ) throws SQLException{
        
            String insert = "INSERT INTO Despesa VALUES( "+getSeq()+", "+codEv+ ", " +numEd+ ", '"
                    + cnpjPat +"', '"+codEv+"', '"+numEd+"', TO_DATE('" +dataDesp+"','YYYY-MM-DD'), " +
                    valorDesp+", '" + descricaoDesp +"')";
            System.out.println("Insert statement: " + insert);
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate(insert);
    }
    
    /**
     * Cria e retorna um conjunto de strings com os dados de uma despesa
     * de acordo com os parametros de entrada
     * @param codDesp - codigo da despesa
     * @param codEv - codigo do evento
     * @param numEd - numero da edição
     * @return details - lista de strings com os dados de uma despesa
     * @throws SQLException
     * @throws ParseException
     */
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
    
    /**
     * Cria e executa um update statement na tabela despesa
     * @param codDesp - codigo da despesa
     * @param codEv - codigo do evento
     * @param numEd - numero da edição
     * @param dataDesp - data da despesa
     * @param valorDesp = valor da despesa
     * @param descricaoDesp = descrição da despesa
     * @throws SQLException - se houver algum erro com o sql statement
     */
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
    
    /**
     * Cria e executa um delete statement
     * @param codDesp - codigo da despesa
     * @param codEv = codigo do evento
     * @param numEd - numero da edição
     * @throws SQLException  - se houver algo errado com a query
     */
    public static void excluir(Integer codDesp, Integer codEv,Integer numEd) throws SQLException{
            String delete = "DELETE FROM Despesa WHERE codDesp = '"+codDesp+"' AND numEd = '" + numEd + "' and codEv = '" + codEv + "'";
            System.out.println("Delete statement: " + delete);
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate(delete);
        }
    
    /**
     * Cria e retorna um combobox com os codigos das despesas de acordo com os parametro de entrada
     * @param codEv - codigo do evento 
     * @param numEd - numero da edição
     * @param cnpjPat - cnpj do patrocinador
     * @return
     * @throws SQLException
     */
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
    /**
     * encontra o maior valor da sequencia de despesas e retorna ela +1
     * @return seq - retorna o maior valor armazenado no cadastro+1
     * @throws SQLException - se houver problemas com o sql statement
     */  
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
