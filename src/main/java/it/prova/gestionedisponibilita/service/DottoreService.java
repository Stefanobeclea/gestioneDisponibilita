package it.prova.gestionedisponibilita.service;

import java.util.List;

import it.prova.gestionedisponibilita.model.Dottore;

public interface DottoreService {
	List<Dottore> listAllElements();

	Dottore caricaSingoloElemento(Long id);

	Dottore aggiorna(Dottore dottoreInstance);

	Dottore inserisciNuovo(Dottore dottoreInstance);

	void rimuovi(Dottore dottoreInstance);

}
