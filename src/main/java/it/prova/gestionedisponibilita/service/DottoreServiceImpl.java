package it.prova.gestionedisponibilita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionedisponibilita.model.Dottore;
import it.prova.gestionedisponibilita.repository.DottoreRepository;

@Service
public class DottoreServiceImpl implements DottoreService{

	@Autowired
	DottoreRepository repository;
	
	@Override
	public List<Dottore> listAllElements() {
		return (List<Dottore>)repository.findAll();
	}

	@Override
	public Dottore caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Dottore aggiorna(Dottore dottoreInstance) {
		return repository.save(dottoreInstance);
	}

	@Override
	public Dottore inserisciNuovo(Dottore dottoreInstance) {
		return repository.save(dottoreInstance);
	}

	@Override
	public void rimuovi(Dottore dottoreInstance) {
		repository.delete(dottoreInstance);
		
	}

}
