package Model;

import java.util.ArrayList;
import java.util.List;

public class Corso {
	private static int count = 0;
    private String titolo;
    private int codice;
    private List<Studente> studenti;
    
    public Corso() {}
    
    public Corso(String titolo) {
        this.titolo = titolo.toUpperCase();
        this.codice = ++count;
        this.studenti = new ArrayList<>();
    }
    
    public String getTitolo() {
        return titolo;
    }

    public int getCodice() {
        return codice;
    }

    public int getNumPartecipanti() {
        return this.studenti.size();
    }
    
    public void addStudente(Studente studente) {
        if (!studenti.contains(studente)) {
            this.studenti.add(studente);
        }
    }
    
    public void removeStudente(Studente studente) {
        this.studenti.remove(studente);
    }
    
    public List<Studente> getStudenti() {
        return studenti;
    }

    @Override
    public String toString() {
    	String desc= String.format("Corso: %s, codice: %x, c'è  %d inscritti",titolo, codice,getNumPartecipanti());
		return desc;
    }
}