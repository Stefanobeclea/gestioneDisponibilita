package it.prova.gestionedisponibilita.repository;

import org.springframework.data.repository.CrudRepository;

import it.prova.gestionedisponibilita.model.Dottore;

public interface DottoreRepository extends CrudRepository<Dottore, Long>{
	Dottore findByCodiceDipendente(String codiceDipendenteInput);
}
