package it.prova.gestionedisponibilita.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.gestionedisponibilita.model.Dottore;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DottoreDTO {

	private Long id;

	@NotBlank(message = "{codiceDipendente.notblank}")
	private String codiceDipendente;

	@NotBlank(message = "{nome.notblank}")
	private String nome;

	@NotBlank(message = "{cognome.notblank}")
	private String cognome;

	private boolean inServizio;
	private boolean inVisita;

	public DottoreDTO() {
		// TODO Auto-generated constructor stub
	}

	public DottoreDTO(Long id, String codiceDipendente, String nome, String cognome, boolean inServizio,
			boolean inVisita) {
		super();
		this.id = id;
		this.codiceDipendente = codiceDipendente;
		this.nome = nome;
		this.cognome = cognome;
		this.inServizio = inServizio;
		this.inVisita = inVisita;
	}

	public DottoreDTO(String codiceDipendente, String nome, String cognome, boolean inServizio, boolean inVisita) {
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
	public Dottore buildDottoreModel() {
		return new Dottore(this.id, this.codiceDipendente ,this.nome, this.cognome, this.inServizio, this.inVisita);
	}

	public static DottoreDTO buildDottoreDTOFromModel(Dottore dottoreModel) {
		DottoreDTO result = new DottoreDTO(dottoreModel.getId(), dottoreModel.getCodiceDipendente(), dottoreModel.getNome(),
				dottoreModel.getCognome(), dottoreModel.isInServizio(), dottoreModel.isInVisita());
		return result;
	}
	public static List<DottoreDTO> createDottoreDTOListFromModelList(List<Dottore> modelListInput) {
		return modelListInput.stream().map(dottoreEntity -> {
			DottoreDTO result = DottoreDTO.buildDottoreDTOFromModel(dottoreEntity);
			
			return result;
		}).collect(Collectors.toList());
	}

}
