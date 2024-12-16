package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Person;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double sum = 0.0;
		
		
		System.out.print("How many people will be inserted? ");
		int amount = sc.nextInt();
		sc.nextLine();
		Person[] person = new Person[amount];
		List<Person> lessThan16 = new ArrayList<>();
		
		for (int i=0; i<person.length; i++) {
			System.out.println("Data of person number "+ (i+1)+ ":");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Age: ");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.print("Height: ");
			double height = sc.nextDouble();
			sc.nextLine();
			
			person[i] = new Person(name, age, height);
			
			sum += height;
			if (age < 16) {
				lessThan16.add(new Person(name, age));
			}		
		}
		
		double percentage = lessThan16.size();
		
		System.out.printf("\nAverage height: %.2f%n", (sum/person.length));
		System.out.println("People with less than 16yo: " + ((100*percentage)/person.length) + "%");
		
		for (Person p : lessThan16) {
			System.out.println(p.getName());
		}
		
		
		
		sc.close();
	}

}
