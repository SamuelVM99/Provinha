package classe;

public class Endereco {
	
	private static int idStatic = 1;
	private int id = 0;
	private int idPessoa = 0;
	private String cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;
	
	public Endereco(int idPessoa, String cep, String logradouro, String numero, String bairro, String cidade, String uf, String pais) {
		this.idPessoa = idPessoa;
		this.id = idStatic;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
		idStatic = idStatic++;
	}

	public int getId() {
		return id;
	}
	public int getIdPessoa() {
		return this.idPessoa;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
}