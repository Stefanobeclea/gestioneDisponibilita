package it.prova.gestionedisponibilita.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dottore")
public class Dottore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codiceDipendente")
	private String codiceDipendente;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "inServizio")
	private boolean inServizio;
	
	@Column(name = "inVisita")
	private boolean inVisita;
	
	public Dottore() {
		// TODO Auto-generated constructor stub
	}

	public Dottore(Long id, String codiceDipendente, String nome, String cognome, boolean inServizio,
			boolean inVisita) {
		super();
		this.id = id;
		this.codiceDipendente = codiceDipendente;
		this.nome = nome;
		this.cognome = cognome;
		this.inServizio = inServizio;
		this.inVisita = inVisita;
	}

	public Dottore(String codiceDipendente, String nome, String cognome, boolean inServizio, boolean inVisita) {
		super();
		this.codiceDipendente = codiceDipendente;
		this.nome = nome;
		this.cognome = cognome;
		this.inServizio = inServizio;
		this.inVisita = inVisita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodiceDipendente() {
		return codiceDipendente;
	}

	public void setCodiceDipendente(String codiceDipendente) {
		this.codiceDipendente = codiceDipendente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public boolean isInServizio() {
		return inServizio;
	}

	public void setInServizio(boolean inServizio) {
		this.inServizio = inServizio;
	}

	public boolean isInVisita() {
		return inVisita;
	}

	public void setInVisita(boolean inVisita) {
		this.inVisita = inVisita;
	}
}
