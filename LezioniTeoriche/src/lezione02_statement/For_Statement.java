package lezione02_statement;

public class For_Statement {
	public static void main(String[] args) {
		//FOR: cicli definiti, il numero di giri è un numero finito
		for(int i = 0; i<3; i++) {
			System.out.println("Ciao " + i);
		}
		
		System.out.println("FOR INVERSO");
		//FOR inverso
		for (int i = 2; i>=0; i--) {
			System.out.println("Ciao " + i);
		}
		
		int sum = 0;
		for (int i = 1; i<=100; i++) {
			sum+=i;
		}
		System.out.println(sum);

	}
}
