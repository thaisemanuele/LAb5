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
    public String username = "a6453087";
    public String password = "a6453087";
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
                //
                enable_stmt  = conn.prepareCall( "begin dbms_output.enable(:1); end;" );
                disable_stmt = conn.prepareCall( "begin dbms_output.disable; end;" );


    	}
    
    /**/

    /**
     *função baseada em https://asktom.oracle.com/pls/asktom/f?p=100:11:0::::P11_QUESTION_ID:45027262935845
     * canaliza o DbmsOutput para um arraylist<string>
     * @param s
     * @return output
     * @throws Exception se ocorrer o driver não conseguir conectar
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
                //DbmsOutput dbmsOutput = new DbmsOutput( conn );
                Statement stmt = conn.createStatement();
                enable_stmt  = conn.prepareCall( "begin dbms_output.enable(:1); end;" );
                disable_stmt = conn.prepareCall( "begin dbms_output.disable; end;" );
                ArrayList<String> output = new ArrayList<>();
                output = dbOutput(s);
                return output;
                /*
                this.stringqvcquer = dmsOutput(s);
                */


    	}
    
    /**
     * Cria o statement de acordo com a string de entrada
     * retorna true se o comando for bem sucedido e false caso contrario
     * @param sql
     * @return ret
     * @throws Exception
     */
    public boolean execute(String sql) throws Exception {
		Statement stmt = dbConnection.conn.createStatement();
		boolean ret = stmt.execute(sql); // insert, create table
		stmt.close();
		return ret;
	}

    /**
     * retorna o result set da query de entrada
     * @param sql
     * @return ResultSet
     * @throws Exception se ocorrer algum erro com o sql
     */
    public ResultSet query(String sql) throws Exception {
		Statement stmt = dbConnection.conn.createStatement();
		return stmt.executeQuery(sql); // select * from msn_user;
	}

    /**
     * comando para fechar a conexão com o banco
     * @throws Exception se o banco ja estiver sido fechado
     */
    public void close() throws Exception {
		dbConnection.conn.close();
	}
        
    /**
     * executa o statemente que canaliza o dbmsoutput para um arrayList
     * @param s
     * @return dbms
     * @throws Exception caso haja um erro com o BD
     */
    public ArrayList<String> dbOutput(String s) throws Exception {  
        //prepara a chamada do stored procedure
        show_stmt = conn.prepareCall(
                //imita a estrutura de uma execução de pl/sql
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
        // cria o statement 
        Statement stmt = conn.createStatement();
        String call = new String();
        //monta a chamada do procedimento
        call = "begin "+s+"; end;";
        //habilita a canalização do dbmsoutput para o arraylist
        enable( 1000000 );
        stmt.execute( call );
        stmt.close();
        show_stmt.registerOutParameter(2, java.sql.Types.INTEGER);
        show_stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        int done = 0;
        ArrayList<String> dbms = new ArrayList<>();
        //loop enquanto houver texto no dbmsoutput pega 255 bytes de texto por linha
        for (;;) {
            show_stmt.setInt(1, 32000);
            show_stmt.executeUpdate();
            dbms.add(show_stmt.getString(3));
            if ((done = show_stmt.getInt(2)) == 1) {
                break;
            }
        }
        //fecha a canalização do dbms
        dbmsClose();
        return dbms;
        
    }       
    
    /**
     * habilita a canalização do dbmsoutput
     * e seta o tamanho do buffer utilizado
     * @param size
     * @throws SQLException se houver erro na execução da query
     */
    public void enable(int size) throws SQLException {
        enable_stmt.setInt(1, size);
        enable_stmt.executeUpdate();

    }

    /**
     * fecha a canalização do dbmsoutput
     * @throws SQLException
     */
    public void dbmsClose() throws SQLException{
        enable_stmt.close();
        disable_stmt.close();
        show_stmt.close();
    }
    
}
