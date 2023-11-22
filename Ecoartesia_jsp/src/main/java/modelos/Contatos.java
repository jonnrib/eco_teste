package modelos;

public class Contatos {
	
	// Attributes
	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String mensagem;

	
	// Constructor
	public Contatos() {
	}

	public Contatos(int id, String nome, String email, String telefone, String mensagem) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.mensagem = mensagem;
	}

	public Contatos(String nome, String email, String telefone, String mensagem) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.mensagem = mensagem;
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	// toString
	@Override
	public String toString() {
		return "Contatos [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", mensagem=" + mensagem + "]";
	}
	
}