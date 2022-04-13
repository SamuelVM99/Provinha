package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDb {

	private static ConexaoDb conexao = null;

	public static ConexaoDb getInstance() {
		if (conexao == null) {
			conexao = new ConexaoDb();
		}
		return conexao;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost/PROVINHA", "root", "sa280499");
	}

}
