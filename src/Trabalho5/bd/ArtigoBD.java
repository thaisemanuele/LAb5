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
public class ArtigoBD {
    
    /**
     * recebe os parametro de entrada e cria um insert statement
     * para a tabela artigo
     * @param tituloArt
     * @param dataApresArt
     * @param horaApresArt
     * @param codEv
     * @param numEd
     * @param idApr
     * @throws SQLException se houver um erro com o sql statement
     * @throws ParseException se um dos parametros não for do tipo correto
     */
    public static void inserir(String tituloArt, String dataApresArt, String horaApresArt, 
            Integer codEv, Integer numEd,Integer idApr) throws SQLException, ParseException{
            String insert = "INSERT INTO Artigo VALUES( " +
                getSeq()+ ", '"+tituloArt+"',TO_DATE('" +dataApresArt+"','YYYY-MM-DD'), TO_DATE('"
                    +horaApresArt+"', 'HH24:MI')"+ ", "+codEv + ", "+numEd+ ", "+idApr+")";
        System.out.println("Insert statement: " + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);

    }
    
    /**
     * recebei idArt e monta um select statement para a tabela artigo
     * @param idArt - id do artigo buscado
     * @return details - strings com os dados da tupla selecionada
     * @throws SQLException - se houver algum problema com o sql statmente
     * @throws ParseException se houver algum dos parametros não for do tipo correto
     */
    public static ArrayList<String> buscar(Integer idArt) throws SQLException, ParseException{
        String selectTableSQL = "SELECT tituloArt, TO_CHAR(dataApresArt, 'DD-MM-YYYY'),"
                + "TO_CHAR(horaApresArt, 'HH24:MI'), codEv, numEd,idApr"
                + " FROM Artigo WHERE idArt = " + idArt;
        System.out.println("Select statement " + selectTableSQL);
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        ArrayList<String> details = new ArrayList<>();
        rs.next();
        for(int i=1; i<=6;i++){
            
            details.add(rs.getString(i));
        }
        rs.close();
        return details;
    }
    
    /**
     *  cria um update statement para a tabela artiga com os parametro enviados 
     * @param idArt - id do artigo
     * @param tituloArt - titulo do artigo
     * @param dataApresArt - data da apresentação no formato yyyy-mm-dd
     * @param horaApresArt - hora da apresentacao no formato HH24:MI
     * @param codEv - codigo do evento
     * @param numEd - numero da edicao
     * @param idApr - id do apresentador
     * @throws SQLException - se houver problemas com sql statemente
     * @throws ParseException - se houver um parametro incorreto
     */
    public static void atualizar(Integer idArt, String tituloArt, String dataApresArt, String horaApresArt, 
        Integer codEv, Integer numEd,Integer idApr) throws SQLException, ParseException{
            String update = "UPDATE Artigo SET tituloArt = '"+tituloArt+"',dataApresArt = TO_DATE('" +dataApresArt+"','YYYY-MM-DD'), "
                + "horaApresArt = TO_DATE('"+horaApresArt+"', 'HH24:MI')"+ ", codEv = "+codEv 
                + ", numEd = "+numEd+ ", idApr = "+idApr+" WHERE idArt = " +idArt;
            System.out.println("Update statement: " + update);
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate(update);

    }
    
    /**
     * cria e executa um delete statemente na tabela artigo
     * @param idArt - id do artigo a ser exluido
     * @throws SQLException se houver algum erro com o sql statemnte
     */
    public static void excluir(Integer idArt) throws SQLException{
        String delete = "DELETE FROM Artigo WHERE idArt = '" + idArt + "'";
        System.out.println("Delete statement: " + delete);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(delete);
    }
    
    /**
     * retorna um modelo de combobox com todos os artigos de acordo com o evento e a edicao
     * @param codEv - codigo do evento
     * @param numEd - numedo da edicao
     * @return model - ComboBoxModel
     * @throws SQLException - se houver algum erro com o sql statement que busca os artigos
     */
    public static DefaultComboBoxModel getArtigos(Integer codEv, Integer numEd) throws SQLException{
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
    
    /**
     * cria e retorna um combobox preenchido com todos os artigos 
     * @return model - ComboBoxModel
     * @throws SQLException - se houver problemas com o sql statement
     * @throws ParseException
     */
    public static DefaultComboBoxModel getAllArtigos() throws SQLException, ParseException{
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String selectTableSQL = "SELECT idArt FROM Artigo ";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        model.addElement(" --- ");
        while(rs.next()){
            model.addElement(rs.getString("idArt"));
        }
        rs.close();
        return model;
    }
    
    /**
     * encontra o maior valor da sequencia de artigos 
     * @return seqIdpe - retorna o maior valor armazenado no cadastro+1
     * @throws SQLException - se houver problemas com o sql statement
     */  
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
