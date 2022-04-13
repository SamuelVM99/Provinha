package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classe.Pessoa;

public class PessoaDao {
	
	private Connection connection;

	public PessoaDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PROVINHA", "root", "sa280499");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void inserir(Pessoa pessoa) {
		String sql = "INSERT INTO PESSOA (NOME, EMAIL, TELEFONE, DATA_NASCIMENTO, CPF) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getTelefone());
			stmt.setString(4, pessoa.getNascimento());
			stmt.setString(5, pessoa.getCpf());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void selecionar() {
		String sql = "SELECT * FROM PESSOA";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String nome = rs.getString("NOME");
				System.out.println(nome);
			}
		} catch (Exception e) {
			System.out.println("Erro Pessoa DAO: " + e.getMessage());
		}
	}
	
	public static void main() {
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = new Pessoa("Samuel", "teste@teste.com", "99238845", "28/04/1999", "11241849960", "85807590",
				"teste", "teste", "teste", "Teste", "teste", "teste", 1);
		
		pessoaDao.inserir(pessoa);
		pessoaDao.selecionar();
		
	}
	
}
