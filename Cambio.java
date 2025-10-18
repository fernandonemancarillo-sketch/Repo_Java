package lezione04_Classi;

import java.util.*;

public class Cambio {
	String nameUser;
	int ageUser;
	int nameAccount;
	double balanceDollar;
	double balanceEuro;
	
	public Cambio () {}

	public Cambio(String nameUser, int ageUser, double balanceDollar) {
	
		this.nameUser = nameUser;
		this.ageUser = ageUser;
		this.nameAccount = this.ageUser*56;
		this.balanceDollar = balanceDollar;
	};
	
	Scanner scan = new Scanner(System.in);
	
	public void checkAccount () {
		System.out.println("C/C: "+ this.nameAccount);
		checkDollar();		
		checkEuro();
	}
	
	public void checkDollar() {
		System.out.println("Balance: $" + this.balanceDollar);
	}
	
	public void checkEuro() {
		System.out.println("Balance: €" + this.balanceEuro);
	}
	
	public void convertEuro() {
		if (this.balanceDollar<0.0) {
			System.out.println("Sorry insuficient funds.");
			checkDollar();
		}
		System.out.println("How many $'s would you like to convert to €'s:");
		double convert = scan.nextDouble();
		scan.nextLine();
		if (convert>this.balanceDollar) {
			System.out.println("Sorry insuficient funds.");
			checkDollar();			
		}else if (convert<0.0) {
			System.out.println("Number chosen to low.");
			checkDollar();
		}else {
			this.balanceEuro = this.balanceEuro + convert*0.85;
			this.balanceDollar -=convert;
			checkAccount();
		}
		
	}
	
	public void convertDollar() {
		if (this.balanceEuro<0.0) {
			System.out.println("Sorry insuficient funds.");
			checkEuro();
		}
		System.out.println("How many €'s would you like to convert to $'s:");
		double convert = scan.nextDouble();
		scan.nextLine();
		if (convert>this.balanceEuro) {
			System.out.println("Sorry insuficient funds.");
			checkEuro();
		}else if (convert<0.0) {
			System.out.println("Number chosen to low.");
			checkEuro();
		}else {
			this.balanceDollar = this.balanceDollar + convert/0.85;
			this.balanceEuro -=convert;
			checkAccount();
		}
		
		
	}
	
	public void UI() {
		boolean cmd = true;
		
		System.out.println("Welcome " + this.nameUser);
		System.out.println("------------------------------");
		while (cmd) {
			System.out.println("------------------------------");
			System.out.println("Choose an action:");
			System.out.println("A to check your account.");
			System.out.println("B to check you euro balance.");
			System.out.println("C to check you dollar balance.");
			System.out.println("D to convert euro to dollars");
			System.out.println("E to convert dollars to euros");
			System.out.println("Q to quit the exchange");
			String act = scan.nextLine();
			
			switch (act.toUpperCase()) {
			case "A":
				checkAccount();
			break;
			case "B":
				checkEuro();
				break;
			case "C":
				checkDollar();
				break;
			case "D":
				convertDollar();
				break;
			case "E":
				convertEuro();
				break;
			case "Q":
				cmd = false;
				System.out.println("See you soon.");
				System.out.println("------------------------------");
			break;
			default: System.out.println("Command not understood.");
			}
		}
	}
	
	
	

}
