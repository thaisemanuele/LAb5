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

/**
 *
 * @author Clayton
 */
public class ExtrasBD {
    
    /**
     * cria um select statement na view valor_patrocinios
     * @return details- arraylist com todo o conteudo de valor_patrocinios
     * @throws SQLException - se houver algum erro no SQL
     * @throws ParseException
     */
    public static ArrayList<String> fetchPat() throws SQLException, ParseException{
        String patrocinios = "SELECT * FROM valor_patrocinios";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(patrocinios);
        ArrayList<String> details = new ArrayList<>();
        StringBuilder label = new StringBuilder();
        label.append("Nome Evento\t" + "Edicao\t" + "Patrocinio\t\t" + "Patrocinador");
        details.add(label.toString());
        while (rs.next()){
            StringBuilder S = new StringBuilder();
            for(int i=1; i<=4;i++){
            
            S.append(rs.getString(i));
            S.append("\t");
            
           }
            
            
            details.add(S.toString());
            S.setLength(0);
        }
        return details;
    }
    
    /**
     * cria um select statement na view instituicao_art
     * @return details- arraylist com todo o conteudo de instituicao_art
     * @throws SQLException - se houver algum erro no SQL
     * @throws ParseException
     */
    public static ArrayList<String> fetchInstArt() throws SQLException, ParseException{
        String art = "SELECT * FROM instituicao_art";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(art);
        ArrayList<String> details = new ArrayList<>();
        StringBuilder label = new StringBuilder();
        label.append("Qdt de artigos\t" + "Instituição");
        details.add(label.toString());
        while (rs.next()){
            StringBuilder S = new StringBuilder();
            for(int i=1; i<=2;i++){
            
            S.append(rs.getString(i));
            S.append("\t");
            
           }
            
            
            details.add(S.toString());
            S.setLength(0);
        }
        return details;
    }
    
    /**
     * cria um select statement na view autores_instituicao
     * @return details- arraylist com todo o conteudo de autores_intituicao
     * @throws SQLException - se houver algum erro no SQL
     * @throws ParseException
     */
    
    public static ArrayList<String> fetchInstAut() throws SQLException, ParseException{
        String art = "SELECT * FROM autores_instituicao";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(art);
        ArrayList<String> details = new ArrayList<>();
        StringBuilder label = new StringBuilder();
        label.append(" qtd Autores\t"+"Instituição\t\t\t" +"Titulo do artigo");
        details.add(label.toString());
        while (rs.next()){
            StringBuilder S = new StringBuilder();
            for(int i=1; i<=3;i++){
            
            S.append(rs.getString(i));
            S.append("\t");
            
           }
            
            
            details.add(S.toString());
            S.setLength(0);
        }
        return details;
    }
    
}
