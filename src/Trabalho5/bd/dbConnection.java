/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho5.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gabriela
 */
public class dbConnection {

    private static Connection conn;

    
    public String driver = "oracle.jdbc.driver.OracleDriver";
    public String url = ("jdbc:oracle:thin:@grad.icmc.usp.br:15214:orcl14"); // final
    public String username = "a7694220";
    public String password = "a7694220";
    
     public static Statement createStatement() throws SQLException {
        return conn.createStatement();
    }
    
    public dbConnection() throws Exception {

		// carrega a classe org.postgresql.Driver na
		// memoria da JVM e carrega as demais classes que
		// sao necessarias para o funcionamento do BD
		Class.forName(driver);
		// ela usa a classe org.postgresql.Driver para
		// chegar na PGConnection e criar uma conexao
		dbConnection.conn = DriverManager.getConnection(
				url, username, password);
	}
    
    public boolean execute(String sql) throws Exception {
		Statement stmt = dbConnection.conn.createStatement();
		boolean ret = stmt.execute(sql); // insert, create table
		stmt.close();
		return ret;
	}

	public ResultSet query(String sql) throws Exception {
		Statement stmt = dbConnection.conn.createStatement();
		return stmt.executeQuery(sql); // select * from msn_user;
	}

	public void close() throws Exception {
		dbConnection.conn.close();
	}
    
}
