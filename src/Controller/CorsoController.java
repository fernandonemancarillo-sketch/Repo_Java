package Controller;
import Model.Studente;
import Model.Corso;
import java.util.ArrayList;
import java.util.List;

public class CorsoController {
    private List<Corso> corsi;
    private StudenteController studenteCtrl;
    
    public CorsoController(StudenteController studenteCtrl) {
        this.corsi = new ArrayList<>();
        this.studenteCtrl = studenteCtrl;
    }
    
    public void addCorso(String titolo) {
    	if (corsi.isEmpty()) {
    		Corso nuovoCorso = new Corso(titolo);
            corsi.add(nuovoCorso);
            System.out.println("Corso creato: " + nuovoCorso.toString());
		}else {
    	boolean esiste = true;
        for (Corso corso : corsi) {
            if (corso.getTitolo().equals(titolo)) {
            	System.out.println("Corso " + corso.getTitolo() +" di codice: " + corso.getCodice() + " già esistente.");
                esiste = false;
            }
        }
		if (esiste) {
			Corso nuovoCorso = new Corso(titolo);
		    corsi.add(nuovoCorso);
		    System.out.println("Corso creato: " + nuovoCorso.toString());
		}
		}
    }
        
    
    
    public void addStudenteAlCorso(String cf, int codiceDelCorso) {
        Studente studente = studenteCtrl.getStudente(cf);
        Corso corso = getCorsobyCodice(codiceDelCorso);
        if (studente == null || corso == null) {
            System.out.println("Studente/Corso non trovato.");
           
        }else {
        	corso.addStudente(studente);
            studente.setCorsoIscritto(corso.getTitolo());
            System.out.println("Studente " + studente.getNome() + " aggiunto al corso " + corso.getTitolo());
        }        
        
    }
    
    public void removeStudente(String cf) {
        Studente studente = studenteCtrl.getStudente(cf);
        
        if (studente == null) {
            System.out.println("Studente non trovato.");
            
        }else {
            for (Corso corso : corsi) {
                if (corso.getStudenti().contains(studente)) {
                    corso.removeStudente(studente);
                    System.out.println("Studente " + studente.getNome() + " rimosso dal corso " + corso.getTitolo());
                }
            
            }
        }
        
        
    }
    
    public Corso getCorsobyCodice(int codice) {
        for (Corso corso : corsi) {
            if (corso.getCodice() == codice) {
                return corso;
            }
        }
        return null;
    }
    
    public void descCorsi() {
        if (corsi.isEmpty()) {
            System.out.println("Nessun corso disponibile.");
            
        }else {
        	
        	System.out.println("Lista Corsi: ");
            for (Corso corso : corsi) {
                System.out.println(corso.toString());
            }        
        }
    }
    
    public List<Corso> getCorsi() {
        return corsi;
    }
}
