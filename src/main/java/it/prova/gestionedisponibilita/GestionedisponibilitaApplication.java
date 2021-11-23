package it.prova.gestionedisponibilita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.gestionedisponibilita.model.Dottore;
import it.prova.gestionedisponibilita.service.DottoreService;

@SpringBootApplication
public class GestionedisponibilitaApplication implements CommandLineRunner{

	@Autowired
	DottoreService dottoreService;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionedisponibilitaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// Popolo DB
		dottoreService.inserisciNuovo(new Dottore("MARO001", "Mario", "Rossi", true, false));
		dottoreService.inserisciNuovo(new Dottore("FRATO21", "Francesco", "Totti", true, true));
		dottoreService.inserisciNuovo(new Dottore("LUPE321", "Luigino", "Peppe", false, false));

	}

}
