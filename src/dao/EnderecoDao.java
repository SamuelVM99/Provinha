package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import classe.*;

public class EnderecoDao {
	
	private Connection connection;

	public EnderecoDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/PROVINHA", "root", "sa280499");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserir(Endereco endereco) {
		String sql = "INSERT INTO ENDERECO (CEP, LOGRADOURO, NUMERO, BAIRRO, CIDADE, UF, PAIS, PESSOA_ID)"
				+ " VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, endereco.getCep());
			stmt.setString(2, endereco.getLogradouro());
			stmt.setString(3, endereco.getNumero());
			stmt.setString(4, endereco.getBairro());
			stmt.setString(5, endereco.getCidade());
			stmt.setString(6, endereco.getUf());
			stmt.setString(7, endereco.getPais());
			stmt.setInt(8, endereco.getIdPessoa());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Erro Endereco DAO: " + e.getMessage());
		}
	}
	
}
