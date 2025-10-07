package lezione02_statement;

import java.util.*;

public class While_Statement {
	public static void main(String[] args) {
		//Con i while siamo nell'ambito dei cicli indefiniti
		int i = 0;
		while (i<10) {
			System.out.println("Ciao" + i);
			i++;
		};
		
		//DO-WHILE
		//Il do while prima esegue qualcosa poi lo controlla. Almeno una volta l'operazione all'interno del do viene eseguita.
		
		int d=11;
		
		do {
			int risultato = d*5;
			System.out.println("5 x " + d + " = " + risultato);
			d++;
		}while (d<=10);
		
		//Esempio con lo scanner. L'utente non entra fin quando la pass non è correta
		Scanner scan = new Scanner(System.in);
		
		String password = "";
		while (!password.equals("mammaMia")) {
			System.out.println("Segna sbagliatta");
			password = scan.nextLine();
		}
		System.out.println("Welcome");
		
		
	}

}
