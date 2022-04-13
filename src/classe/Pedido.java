package classe;

public class Pedido {
	
	private static int idStatic = 1;
	private int idPessoa = 0;
	private int id = 0;
	private String data;
	private String valor;
	private String descricao;
	
	public Pedido(int idPessoa, String data, String valor, String descricao) {
		this.idPessoa = idPessoa;
		this.id = idStatic;
		this.data = data;
		this.valor = valor;
		this.descricao = descricao;
		idStatic = idStatic++;
	}
	
	public int getIdPessoa() {
		return this.idPessoa;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
