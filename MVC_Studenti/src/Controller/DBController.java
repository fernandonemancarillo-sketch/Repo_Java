package Controller;

import Model.Studente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DBController {
    private static final String CSV_SEPARATOR = ",";
    private String filePath;
    
    public DBController(String filePath) {
        this.filePath = filePath;
    }
    
    public void loadStudentiDaCSV(StudenteController studenteCtrl) {
        File file = new File(filePath);
        
        if (!file.exists()) {
            System.out.println("File CSV non trovato: " + filePath);
            System.out.println("Verrà creato un nuovo file al salvataggio.");
            return;
        }
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            int lineNumber = 0;
            
            while ((line = br.readLine()) != null) {
                lineNumber++;
                
                if (lineNumber == 1 && line.toLowerCase().contains("nome")) {
                    continue;
                }
                
                // Salta righe vuote
                if (line.trim().isEmpty()) {
                    continue;
                }
                
                String[] dati = line.split(CSV_SEPARATOR);
                
                if (dati.length < 4) {
                    System.out.println("Riga " + lineNumber + " ignorata: dati incompleti");
                    continue;
                }
                
                String nome = dati[0].trim();
                String cognome = dati[1].trim();
                String codFiscale = dati[2].trim();
                String corsoIscritto = dati[3].trim();
                
                studenteCtrl.addStudente(nome, cognome, codFiscale, corsoIscritto);
            }
            
            System.out.println("Studenti caricati con successo dal file: " + filePath);
            
        } catch (FileNotFoundException e) {
            System.out.println("Errore: File non trovato - " + filePath);
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Errore durante la chiusura del file: " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * Salva gli studenti dal StudenteController nel file CSV
     * Sovrascrive il file esistente
     */
    public void saveStudentiInCSV(StudenteController studenteCtrl) {
        BufferedWriter bw = null;
        
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            
            // Scrive l'header
            bw.write("nome,cognome,codFiscale,corsoIscritto");
            bw.newLine();
            
            // Ottiene la lista di studenti
            List<Studente> studenti = studenteCtrl.getStudenti();
            
            if (studenti.isEmpty()) {
                System.out.println("Nessuno studente da salvare.");
            } else {
                // Scrive ogni studente
                for (Studente studente : studenti) {
                    String line = String.format("%s,%s,%s,%s",
                        studente.getNome(),
                        studente.getCognome(),
                        studente.getCodFiscale(),
                        studente.getCorsoIscritto()
                    );
                    bw.write(line);
                    bw.newLine();
                }
                
                System.out.println("Studenti salvati con successo nel file: " + filePath);
                System.out.println("Totale studenti salvati: " + studenti.size());
            }
            
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file: " + e.getMessage());
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Errore durante la chiusura del file: " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * Aggiunge uno studente al file CSV senza sovrascrivere i dati esistenti
     */
    public void appendStudenteInCSV(Studente studente) {
        BufferedWriter bw = null;
        
        try {
            File file = new File(filePath);
            boolean fileExists = file.exists();
            
            // true = append mode
            bw = new BufferedWriter(new FileWriter(filePath, true));
            
            // Se il file non esiste, aggiungi l'header
            if (!fileExists) {
                bw.write("nome,cognome,codFiscale,corsoIscritto");
                bw.newLine();
            }
            
            // Aggiungi lo studente
            String line = String.format("%s,%s,%s,%s",
                studente.getNome(),
                studente.getCognome(),
                studente.getCodFiscale(),
                studente.getCorsoIscritto()
            );
            bw.write(line);
            bw.newLine();
            
            System.out.println("Studente aggiunto al CSV: " + studente.getNome() + " " + studente.getCognome());
            
        } catch (IOException e) {
            System.out.println("Errore durante l'aggiunta dello studente al file: " + e.getMessage());
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Errore durante la chiusura del file: " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * Conta il numero di studenti nel file CSV
     */
    public int contaStudentiNelCSV() {
        int count = 0;
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty() && !line.toLowerCase().contains("nome,cognome")) {
                    count++;
                }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + filePath);
            return 0;
        } catch (IOException e) {
            System.out.println("Errore durante la lettura: " + e.getMessage());
            return 0;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Errore durante la chiusura: " + e.getMessage());
                }
            }
        }
        
        return count;
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public String getFilePath() {
        return filePath;
    }
}