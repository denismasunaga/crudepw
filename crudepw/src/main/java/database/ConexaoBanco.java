package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Carro;

public class ConexaoBanco {
	
	private Connection conn;
	
	public ConexaoBanco() {

	}
	
	public Connection obterConexao() throws SQLException {
		if(conn == null) {
			conn = conectarBanco();
			return conn;
		} else {
			return conn;
		}
	}
	
	private static Connection conectarBanco() throws SQLException {
		
	    return DriverManager.getConnection("jdbc:sqlite:/Users/denismasunaga/Faculdade/PW/crudepw/MySQLiteDB");
	}
	
}
