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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Clayton
 */
public class EventoBD {
    /*codEv NUMBER(4) NOT NULL,                       	 -- Chave Primária
    nomeEv VARCHAR2(40) NOT NULL, 		-- Campo de valor único, não devem haver nomes iguais 
    descricaoEv VARCHAR2(400),
    websiteEv VARCHAR2(40),
    totalArtigosApresentadosEv NUMBER(4) DEFAULT 0, 	-- atributo derivado armazena o numero de artigos apresentados em todas edições do evento
     */
    public Integer codEv;
    public String nomeEv;
    public String descricaoEv;
    public String website;
    public int totalArtigosApresentados;
    public static int seqCodEv;
    
    
    public EventoBD(Integer codEv, String nomeEv, String descricaoEv, String website){
        this.codEv = codEv;
        this.nomeEv = nomeEv;
        this.descricaoEv = descricaoEv;
        this.website = website;
        this.totalArtigosApresentados = 0;
        
    }
    
    private EventoBD(Integer codEv, String nomeEv, String descricaoEv, String website, Integer TotalArtigosApresentados){
        this.codEv = codEv;
        this.nomeEv = nomeEv;
        this.descricaoEv = descricaoEv;
        this.website = website;
        this.totalArtigosApresentados = TotalArtigosApresentados;
        
    }
    
    public static void inserir(String nomeEv, String descricaoEv, String website) throws SQLException{
        
        String insert = "INSERT INTO Evento VALUES('" + getSeq()+ "','" +nomeEv+ "','" +descricaoEv+ "','" +website+" )";
        System.out.println("insert statement" + insert);
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(insert);
    }
    
    public static void atualizar(Integer codEv, String nomeEv, String descricaoEv, String website) throws SQLException{
        String update = "UPDATE Evento SET nomeEv = '" +nomeEv+ "',descricaoEv = '" +descricaoEv+ "',website = '" +website+ " WHERE codEv = '" + codEv + "'";
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(update);
    }
    
    public static void excluir(Integer codEv) throws SQLException{
        String delete = "DELETE FROM Evento WHERE codEv = '" + codEv + "'";
        Statement statement = dbConnection.createStatement();
        statement.executeUpdate(delete);
    }
    
    public static EventoBD buscar(Integer codEv) throws SQLException, ParseException{
        String selectTableSQL = "SELECT codEv, nomeEv, descricaoEv, website, totalArtigosApresentados, tipo FROM Evento WHERE codEv = '" + codEv + "'";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
             
        if (rs.next()) return new EventoBD(rs.getInt("codeEv"), rs.getString("nomeEv"),rs.getString("descricaoEv"), rs.getString("website"),rs.getInt("totalArtigosApresentados"));
        else return null;
    }
    private static Integer getSeq()throws SQLException{
        String selectSql = "SELECT max(codEv) from Evento";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql);
        seqCodEv = rs.getInt("codEv");
        return seqCodEv + 1;
        
        
        
    }
    
}
