package classe;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class Pessoa {

	private static int idStatic = 1;
	private int id = 0;
	private String nome;
	private String email;
	private String telefone;
	private String nascimento;
	private String cpf;
	private Endereco endereco;
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Pessoa(String nome, String email, String telefone, String nascimento, String cpf,
			String cep, String logradouro, String numero, String bairro, String cidade,
			String uf, String pais, int idPessoa) {
		this.id = idStatic;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.cpf = cpf;
		idPessoa = id;
		this.endereco = new Endereco(idPessoa, cep, logradouro, numero, bairro, cidade, uf, pais);
		idStatic++;
	}
	
	public Pedido getPedido(int index) {
		return this.pedidos.get(index);
	}
	
	public List getPedidos() {
		return this.pedidos;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	public int getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return this.telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNascimento() {
		return this.nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Endereco getEndereco() {
		return this.endereco;
	}
}
