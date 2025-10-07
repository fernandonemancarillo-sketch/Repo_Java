package esercizi_Lezione02;
import java.util.*;
public class Esercizi {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		//Esercizio 1
		
		boolean membroFedeltà = false;
		double acquisto = 0;
		double spesa = 300.86;
		double sconto = 0;
		
		if (acquisto>=100 || membroFedeltà) {
			sconto = spesa * 0.15;
			System.out.println("Tuo sconto è di 15%: €" + sconto);
			spesa -= sconto;
		}
		System.out.println("La tua spesa è: €" + spesa);
		
		//Esercizio 2
		System.out.println("Inserisce un numero tra 10 e 20");
		int num = scan.nextInt();
		while (num>=20 || num<=10) {
			if(num<10) {
				System.out.println("Numero troppo basso, prova un'altro");
				num = scan.nextInt();
				scan.nextLine();
				
			}else {
			System.out.println("Numero troppo alto, prova un'altro");
			num = scan.nextInt();
			scan.nextLine();
			}
		}
		System.out.println("Good job");
		
		//Esercizio 3
		System.out.println("Inserisce il voto");
		int voto = scan.nextInt();
		scan.nextLine();
		
		if (voto>=90) {
			System.out.println("Il uo voto è: A. Molto buono.");
		}else if (voto>=80) {
			System.out.println("Il tuo voto è: B. Buono.");
		}else if (voto>=70) {
			System.out.println("Il uo voto è: C. Meh.");
		}else {
			System.out.println("Il uo voto è: F. Non va bene.");
		}
		
		//Esercizio 4 
		System.out.println("Inserisce il numero di un mese.");
		int mese = scan.nextInt();
		scan.nextLine();
		switch(mese) {
		case 1,2,12: System.out.println("Inverno");
		break;
		case 3,4,5: System.out.println("Primavera");
		break;
		case 6,7,8: System.out.println("Estate");
		break;
		case 9,10,11: System.out.println("Autunno");
		break;
		default: System.out.println("Mese invalido");
		}
		
		
		//Esercizi 5
		for (int i = 1; i<=100; i++) {
			if (i%15==0) {
				System.out.println(i + " Zoom Boom");
			}else if (i%5==0) {
				System.out.println(i+" Boom");
			}else if (i%3==0) {
				System.out.println(i+" Zoom");
			}
				System.out.println(i);
		}
		
		//Esercizi 6	
	    System.out.println("Scrive 'fine' per fermare la calcolatrice. O un operatore matematico: /, *, -, +");
		String oper = scan.nextLine();
		while(!oper.equals("fine")) {
			System.out.println("Add due numeri, per favore ");
			double num1 = scan.nextInt();
			scan.nextLine();
			System.out.println("Il primo numero è: " + num1);
			double num2 = scan.nextInt();
			scan.nextLine();
			System.out.println("Il secondo numero è: " + num2);
			switch(oper) {
				case"/": System.out.println(num1 + " / " + num2 + " è: " +(num1/num2));
				break;
				case"*": System.out.println(num1 + " * " + num2 + " è: " +(num1*num2));
				break;
				case"-": System.out.println(num1 + " - " + num2 + " è: " +(num1-num2));
				break;
				case"+": System.out.println(num1 + " + " + num2 + " è: " +(num1+num2));
				break;
				default: System.out.println("Non ha scelto un operatore.");
				break;
			}
					
			System.out.println("Scrive 'fine' per fermare la calcolatrice. O un operatore matematico: /, *, -, +");
			oper = scan.nextLine();
					
			}
		
		//Esercizi 7
		
		System.out.println("Scegle un opizione: 1-Saluto, 2-Mostra a data, 3-Esci");
		int menu = scan.nextInt();
		scan.nextLine();
		do {
			if (menu ==1) {
			System.out.println("Ciao!");
			}else if (menu==2) {
				System.out.println("Oggi è: 07/10/2025");
			}
				System.out.println("Scegle un opizione: 1-Saluto, 2-Mostra a data, 3-Esci");
			menu = scan.nextInt();
			scan.nextLine();

		}while (menu!=3);
		
		System.out.println("The end!!!!!");
				

	}
	

}
