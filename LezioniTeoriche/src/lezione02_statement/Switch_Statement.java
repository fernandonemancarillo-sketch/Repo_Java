package lezione02_statement;

public class Switch_Statement {
	public static void main(String[] args) {
		//Lo switch mi permette di valutare, in base ai casi, il valore di una variabile
		
		int giornoDellaSettimana = 2;
		
		switch (giornoDellaSettimana) {
		case 1: System.out.println("Lunedì");
		break;
		case 2: System.out.println("Martedì");
		break;
		case 3: System.out.println("Mercoledì");
		break;
		case 4: System.out.println("Giovedì");
		break;
		case 5: System.out.println("Venerdì");
		break;
		case 6: System.out.println("Sabato");
		break;
		case 7: System.out.println("Domenica");
		break;
		default:
			System.out.println("Non riconosco il valore");
			break;
		
		}
		
		//Con le Stringhe
		String giorno = "Martedì";
		switch (giorno) {
		case "Lunedì": System.out.println();
		case "Martedì": System.out.println();
		case "Mercoledì": System.out.println();
		case "Giovedì": System.out.println();
		case "Venerdì": System.out.println();
		case "Sabato": System.out.println();
		case "Domenica": System.out.println();
		default:
			System.out.println("Giorno non valido");
		
		}
	}

}
