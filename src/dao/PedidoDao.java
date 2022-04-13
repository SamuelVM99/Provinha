package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import classe.*;

public class PedidoDao {

	private Connection connection;

	public PedidoDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PROVINHA", "root", "sa280499");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void inserir(Pedido pedido) {
		String sql = "INSERT INTO PEDIDO (DATA, VALOR, DESCRICAO, PESSOA_ID) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, pedido.getData());
			stmt.setString(2, pedido.getValor());
			stmt.setString(3, pedido.getDescricao());
			stmt.setInt(4, 1);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Erro Pedido DAO:" + e.getMessage());
		}
	}
	
}
