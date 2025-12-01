package View;
import Controller.*;

public class Main {
    public static void main(String[] args) {
        // Cria os controllers
        StudenteController stdCtrl = new StudenteController();
        CorsoController corsoCtrl = new CorsoController(stdCtrl);
        stdCtrl.setCorsoController(corsoCtrl);
        
        // Cria o DBController com o caminho do file CSV
        DBController dbCtrl = new DBController("studenti.csv");
        
        System.out.println("=== CARICANDO STUDENTI DA CSV ===");
        dbCtrl.loadStudentiDaCSV(stdCtrl);
        
        // Se il file non esisteva o era vuoto, aggiungi alcuni studenti
        if (stdCtrl.getStudenti().isEmpty()) {
            System.out.println("\n=== AGGIUNGENDO NUOVI STUDENTI ===");
            stdCtrl.addStudente("Nando", "Neman", "123", "Java");
            stdCtrl.addStudente("Lily", "Bayraktar", "456", "Business");
            stdCtrl.addStudente("Pedro", "Carillo", "789", "Aereo");
            stdCtrl.addStudente("Maria", "Rossi", "111", "Python");
        }
        
        stdCtrl.descStudente();
        
        corsoCtrl.addCorso("Java Avanzato");
        corsoCtrl.addCorso("Business Administration");
        corsoCtrl.addCorso("Ingegneria Aerospaziale");
        corsoCtrl.addCorso("Python Programming");
        
        corsoCtrl.addStudenteAlCorso("123", 1);
        corsoCtrl.addStudenteAlCorso("456", 2);
        corsoCtrl.addStudenteAlCorso("789", 3);
        corsoCtrl.addStudenteAlCorso("111", 4);
        
        dbCtrl.saveStudentiInCSV(stdCtrl);
        
        stdCtrl.addStudente("Giovanni", "Bianchi", "222", "Database");
        
        dbCtrl.saveStudentiInCSV(stdCtrl);
        
        int numeroStudenti = dbCtrl.contaStudentiNelCSV();
        System.out.println("Totale studenti nel file CSV: " + numeroStudenti);
        
        stdCtrl.removeStudente("456");
        
        dbCtrl.saveStudentiInCSV(stdCtrl);
        
        stdCtrl.descStudente();
        corsoCtrl.descCorsi();
    }
}