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
 * @author thatitis
 */
public class ExtrasBD {
    
    public static ArrayList<String> fetchPat() throws SQLException, ParseException{
        String patrocinios = "SELECT * FROM valor_patrocinios";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(patrocinios);
        ArrayList<String> details = new ArrayList<>();
        StringBuilder label = new StringBuilder();
        label.append("Nome Evento\t" + "Edicao\t" + "Patrocinador\t\t" + "Patrocinio");
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
