package it.prova.gestionedisponibilita.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestionedisponibilita.controller.api.exception.DottoreNotFoundException;
import it.prova.gestionedisponibilita.controller.api.exception.IdNotNullForInsertException;
import it.prova.gestionedisponibilita.dto.DottoreDTO;
import it.prova.gestionedisponibilita.model.Dottore;
import it.prova.gestionedisponibilita.service.DottoreService;

@RestController
@RequestMapping("dottore")
public class DottoreController {
	
	@Autowired
	DottoreService dottoreService;
	
	@GetMapping
	public List<DottoreDTO> getAll() {
		return DottoreDTO.createDottoreDTOListFromModelList(dottoreService.listAllElements());
	} 
	
	@GetMapping("/{id}")
	public DottoreDTO findById(@PathVariable(value = "id", required = true) long id) {
		Dottore dottore = dottoreService.caricaSingoloElemento(id);

		if (dottore == null)
			throw new DottoreNotFoundException("Dottore not found con id: " + id);

		return DottoreDTO.buildDottoreDTOFromModel(dottore);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DottoreDTO createNew(@Valid @RequestBody DottoreDTO dottoreInput) {
		if(dottoreInput.getId() != null)
			throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");
		
		Dottore dottoreInserito = dottoreService.inserisciNuovo(dottoreInput.buildDottoreModel());
		return DottoreDTO.buildDottoreDTOFromModel(dottoreInserito);
	}
	
	@PutMapping("/{id}")
	public DottoreDTO update(@Valid @RequestBody DottoreDTO dottoreInput, @PathVariable(required = true) Long id) {
		Dottore dottore = dottoreService.caricaSingoloElemento(id);

		if (dottore == null)
			throw new DottoreNotFoundException("Dottore not found con id: " + id);

		dottoreInput.setId(id);
		Dottore dottoreAggiornato = dottoreService.aggiorna(dottoreInput.buildDottoreModel());
		return DottoreDTO.buildDottoreDTOFromModel(dottoreAggiornato);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable(required = true) Long id) {
		Dottore dottore = dottoreService.caricaSingoloElemento(id);

		if (dottore == null)
			throw new DottoreNotFoundException("Dottore not found con id: " + id);

		dottoreService.rimuovi(dottore);
	}
}
