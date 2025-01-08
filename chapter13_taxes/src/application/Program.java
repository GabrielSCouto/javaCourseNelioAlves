package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.NaturalPerson;
import entities.Person;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Person> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int amount = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < amount; i++) {
			System.out.println("Tax payer #" + (i+1) + " data:");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Annual earnings: ");
			double earnings = sc.nextDouble();
			sc.nextLine();
			char ch;
			do {
				System.out.print("Individual ou Company? ( i / c ) ");
				ch = sc.next().charAt(0);
				switch (ch) {
				case 'i':
					System.out.print("Healthcare expanses: ");
					double expanse = sc.nextDouble();
					sc.nextLine();
					list.add(new NaturalPerson(name, earnings, expanse));
					break;	
				case 'c':
					System.out.print("Amount of employees: ");
					int employees = sc.nextInt();
					sc.nextLine();
					list.add(new LegalPerson(name, earnings, employees));
					break;
				default:
					System.out.println("Insira o tipo correto!");
					break;
				} 
			} while (ch != 'i' && ch != 'c');
		}
		
		double total = 0.0;
		System.out.println("\nTAXES PAID:");
		for (Person p : list) {
			System.out.println(p);
			total += p.taxes();	
		}
		
		System.out.println("\nTOTAL TAXES: $" + String.format("%.2f", total));
		
		sc.close();
	}

}
