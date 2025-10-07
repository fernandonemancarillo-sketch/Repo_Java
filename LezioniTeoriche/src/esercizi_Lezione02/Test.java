package esercizi_Lezione02;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Scegle un opizione: 1-Saluto, 2-Mostra a data, 3-Esci");
		int menu = scan.nextInt();
		scan.nextLine();
		
		//Esercizi 7
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
		
		

	}

}
