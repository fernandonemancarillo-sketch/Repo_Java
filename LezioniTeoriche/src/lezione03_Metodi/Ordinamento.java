package lezione03_Metodi;
import java.util.*;

public class Ordinamento {
	public static void main(String[] args) {
		//crescente
		int[] a = {5,9,6,10,7,11};
		int[] b = {9,3,5,7,1};
		int[] c = {5,9,11,0,1,40};
		
		esercizio1Cresc (a);
		esercizio1Cresc (b);
		esercizio1Cresc (c);
		
		esercizio1Desc(a);
		esercizio1Desc(b);
		esercizio1Desc(c);
		
		
		
		
	}
	
	public static void esercizio1Cresc (int[] a) {
		
		
		boolean order =true;
		
		while (order) {
			for (int i = 1; i<a.length; i++) {
				if (a[i]<a[i-1]) {
					int temp = a[i];
					a[i]=a[i-1];
					a[i-1]=temp;
					order = false;
				}
			}	
			for (int j = 1; j<a.length; j++) {
				if (a[j]<a[j-1]) {
					order = true;
				}
			}
		}
		System.out.println("Array in modo crescente");
		System.out.println(Arrays.toString(a));
		
	}
	public static void esercizio1Desc (int[] a) {
		boolean order =true;
		
		while (order) {
			for (int i = 1; i<a.length; i++) {
				if (a[i]>a[i-1]) {
					int temp = a[i-1];
					a[i-1]=a[i];
					a[i]=temp;
					order = false;
				}
			}	
			for (int j = 1; j<a.length; j++) {
				if (a[j]>a[j-1]) {
					order = true;
				}
			}
		}
		
		System.out.println("Array in modo decrescente");
		System.out.println(Arrays.toString(a));
		
	}
	

}


