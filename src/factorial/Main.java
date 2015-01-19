package factorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 *Autor - Botnaru Elvis
 *Pentastagiu 2015, Problema Nr.4
 *Acest fisier are in vedere citirea unui numar de la tastiera;
 *Calcularea factorialului pentru 1!..n!, unde n este numarul citit
 *Impartirea factorialului rezultat in digits si calcularea sumei digitilor
 *Identificarea sirului de digiti care au sume identice,dar lungime mai mare
 *Afisarea sume si sirul de digiti care au aceeasi suma dar lungimea cea mai mare.
 */

public class Main {

	public static void main(String[] args) {
			Apel();		
	}
	
	public static int Factorial(int numar) {
		int rez = 1;
		
		//calculul factorial
		for (int i = 1; i <= numar; i++) {
			rez *= i;
		}
		return rez;
	}

	public static int[] DigitEste(int n) {
		
		String str = Integer.toString(n);
		int[] digits = new int[str.length()];
		
		//salvarea digits in vector
		for (int i = 0; i < str.length(); ++i) {
			digits[i] = Integer.parseInt(str.substring(i, i + 1));
		}

		System.out.println("Digit este: " + Arrays.toString(digits));

		return digits;
	}

	public static int Suma(int[] digits) {
		int sum = 0;
		
		//calculul sumei din vectorul digits
		for (int i = 0; i < digits.length; i++) {
			sum = sum + digits[i];
		}

		System.out.println("Suma este: " + sum);
		return sum;
	}
	
	public static void Apel() {
		
		Scanner citireNumar = new Scanner(System.in);
		System.out.println("Un numar:");
		int numar = 1;
		int rez = 0;
		int flag = 0;

		List<Integer> lst1 = new ArrayList<Integer>();
		List<Integer> lst2 = new ArrayList<Integer>();

		// citire numar
		try {
			numar = citireNumar.nextInt();
			if (numar < 1) {
				System.out.println("Doar numere/cifre > 1");
			}
		} catch (Exception e) {
			flag = 2;
			System.err.println("Eroare la citire numar : " + e.getMessage());
			e.printStackTrace();
		}
		// inchidere Scanner
		citireNumar.close();
		
		// apel facorial, in cazul in care s-a trecut validarea
		if (flag == 0) {
			for (int i = 1; i <= numar; i++) {
				rez = Factorial(i);
				System.out.println("Factorial pentru numarul: " + i + " este: " + rez);
				
				//convertire factorial in digit si salvarea lungimii in lista
				lst1.add(Suma(DigitEste(rez)));
				String string = Integer.toString(rez);
				lst2.add(string.length());
			}
			//afisare lungime pentru fiecare factorial(secventa de digits)
			for (int i = 0; i < lst1.size(); i++) {
				System.out.println("Elementul(suma) : " + lst1.get(i) + " are lungimea: " + lst2.get(i));
			}
		} else {
			System.out.println("S-a produs o eroare!!");
		}
	}
}
