package lezione02_statement;
import java.util.Scanner;

public class Sanner_Esempio {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //ATT: Scanner va importato da java.util, il System.in sono gli input di sistema, cioè quelli che scrivel'utente
		
		System.out.println("Ciao, inserisci il tuo nome: ");
		String mioNome = scan.nextLine();
		
		System.out.println("Benvenuto " + mioNome);
		
		//Posso utilizzare lo stessso scanner per inserire cose diverse.
		System.out.println("Inserisci la tua età: ");
		int miaEta = scan.nextInt();
		
		System.out.println("Hai " + miaEta + " anni.");
		
		System.out.println("Inserisci la tua altezza (in metri):");
		double miaAlt = scan.nextDouble();
		
		System.out.println("Sei alto: " + miaAlt + " metri");
		
		
	}

}
