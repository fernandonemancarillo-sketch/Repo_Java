package Controller;
import Model.Studente;
import Model.Corso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class StudenteController {
	private List<Studente> studenti;
	private CorsoController corsoController;
	public StudenteController() {
		this.studenti = new ArrayList<>();
		
	}
	
	public void setCorsoController(CorsoController corsoCtrl) {
        this.corsoController = corsoCtrl;
    }
	
	public void addStudente(String nome, String cognome, String cf, String titoloCorso) {
		
		if (this.studenti.isEmpty()) {
			Studente student = new Studente(nome,cognome,cf,titoloCorso);
			studenti.add(student);
			System.out.println(student.toString()); 
			
		}else {
			if(getStudente(cf)==null) {
				Studente student = new Studente(nome,cognome,cf,titoloCorso);
				studenti.add(student);
				System.out.println(student.toString()); 
			}else {
				System.out.println("Studente già inscritto.");
			}
			
		}

	}
	
	public void removeStudente (String cf) {
		if (getStudente(cf)==null) {
			System.out.println("Studenti non trovato");
		}else {
			studenti.remove(getStudente(cf));
			System.out.println("Studente rimosso con successo.");
		}
	}
	
	public void descStudente() {
		if (studenti.isEmpty()) {
			System.out.println("Non ci sono studenti iscritti");
		}else {
			for (Studente studente : studenti) {
				System.out.println(studente.toString()); 
			}
		}
		
	}
	
	public Studente getStudente(String cf) {
		boolean esiste = false;
		int dove = -1;
		if (studenti.isEmpty()) {
			return null;
		}
		for(Studente studente : studenti) {
			if (studente.getCodFiscale().equals(cf)) {
				dove = studenti.lastIndexOf(studente);
				esiste = true;
			}
		}
		if (esiste) {
			return studenti.get(dove);
		}else {
			return null;
		}

	}

	public List<Studente> getStudenti() {
		return studenti;
	}
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
