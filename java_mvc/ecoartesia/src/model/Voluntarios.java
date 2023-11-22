package model;

public class Voluntarios {

	// ATRIBUTOS
	private int id;
	private String disponibilidade;
	private String interesses;
	private String nome;
	private String email;
	
	// CONSTRUTORES
	public Voluntarios() {
	}

	public Voluntarios(int id, String nome, String email, String disponibilidade, String interesses ) {
        this.id = id;
		this.nome = nome;
		this.email = email;
		this.disponibilidade = disponibilidade;
		this.interesses = interesses;
	}

	public Voluntarios(String nome, String email, String disponibilidade, String interesses) {

		this.nome = nome;
		this.email = email;
		this.disponibilidade = disponibilidade;
		this.interesses = interesses;
	}
	
	//GETTERS & SETTERS
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

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getInteresses() {
		return interesses;
	}

	public void setInteresses(String interesses) {
		this.interesses = interesses;
	}

	
	// TOOSTRING
	@Override
	public String toString() {
		return "Voluntarios [disponibilidade=" + disponibilidade + ",interesses=" + interesses +", nome=" + nome + ", email=" + email + "]";
	}
	
	
	
	
}