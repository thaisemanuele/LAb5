/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho5.bd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Clayton
 */
public class dbConnection {

    private static Connection conn;

    
    public String driver = "oracle.jdbc.driver.OracleDriver";
    public String url = ("jdbc:oracle:thin:@grad.icmc.usp.br:15214:orcl14"); // url fora do lab
    public String url2 = ("jdbc:oracle:thin:@grad.icmc.usp.br:15214:orcl14"); // url dentro do lab
    public String username = "a7161591";
    public String password = "a7161591";
    private CallableStatement enable_stmt;
    private CallableStatement disable_stmt;
    private CallableStatement show_stmt;
    public static Statement createStatement() throws SQLException {
        return conn.createStatement();
    }
    
    public dbConnection() throws Exception {

		// carrega a o Driver na memória
                //memoria da JVM e carrega as demais classes que
		// sao necessarias para o funcionamento do BD
		Class.forName(driver);
                //estabelece conexão com o Banco
		dbConnection.conn = DriverManager.getConnection(
				url, username, password);
                //cria o sql statement
                Statement stmt = conn.createStatement();
               


    	}
    /*função baseada em https://asktom.oracle.com/pls/asktom/f?p=100:11:0::::P11_QUESTION_ID:45027262935845*/

    /**
     *
     * @param s
     * @return dbmsOutput
     * @throws Exception
     */
    
    public ArrayList<String> dbmsOutput(String s) throws Exception {

		// carrega a classe org.postgresql.Driver na
		// memoria da JVM e carrega as demais classes que
		// sao necessarias para o funcionamento do BD
		Class.forName(driver);
		// ela usa a classe org.postgresql.Driver para
		// chegar na PGConnection e criar uma conexao
		dbConnection.conn = DriverManager.getConnection(
				url, username, password);
               
                Statement stmt = conn.createStatement();
                //cria um CallableStatement para poder usar stored procedures
                enable_stmt  = conn.prepareCall( "begin dbms_output.enable(:1); end;" );
                disable_stmt = conn.prepareCall( "begin dbms_output.disable; end;" );
                ArrayList<String> output = new ArrayList<>();
                output = dbOutput(s);
                return output;
                


    	}
    
    /**
     *
     * @param sql
     * @return boolean
     * @throws Exception
     * cria um bd statement
     */
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
        
    
     public ArrayList<String> dbOutput(String s) throws Exception {  

        show_stmt = conn.prepareCall(
                "declare "
                + "    l_line varchar2(255); "
                + "    l_done number; "
                + "    l_buffer long; "
                + "begin "
                + "  loop "
                + "    exit when length(l_buffer)+255 > :maxbytes OR l_done = 1; "
                + "    dbms_output.get_line( l_line, l_done ); "
                + "    l_buffer := l_buffer || l_line || chr(10); "
                + "  end loop; "
                + " :done := l_done; "
                + " :buffer := l_buffer; "
                + "end;");
        
        Statement stmt = conn.createStatement();
        String call = new String();
        call = "begin "+s+"; end;";
        enable( 1000000 );
        stmt.execute( call );
        stmt.close();
        show_stmt.registerOutParameter(2, java.sql.Types.INTEGER);
        show_stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        int done = 0;
        ArrayList<String> dbms = new ArrayList<>();
        
        for (;;) {
            show_stmt.setInt(1, 32000);
            show_stmt.executeUpdate();
            dbms.add(show_stmt.getString(3));
            if ((done = show_stmt.getInt(2)) == 1) {
                break;
            }
        }
        dbmsClose();
        return dbms;
        
    }       
    
    public void enable(int size) throws SQLException {
        enable_stmt.setInt(1, size);
        enable_stmt.executeUpdate();

    }

    
    public void dbmsClose() throws SQLException{
        enable_stmt.close();
        disable_stmt.close();
        show_stmt.close();
    }
    
}
