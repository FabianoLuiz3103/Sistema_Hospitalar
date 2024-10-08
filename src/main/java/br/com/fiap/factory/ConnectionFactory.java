package br.com.fiap.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	static final String URL = "";
	static final String USERNAME = "";
	static final String PASSWORD = "";
	
	public Connection conexao() throws ClassNotFoundException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(SQLException e) {
			System.out.println("\n\bERRO AO CONECTAR!");
			throw new RuntimeException(e);
		}
	}

}
