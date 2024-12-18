package application;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import entities.Student;

public class Program {

	public static void main(String[] args)  throws ParseException{
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.print("How many rooms will be rented? ");
		int amount = sc.nextInt();
		
		Student[] students = new Student[10];
		
		for (int i = 0; i < amount; i++) {
			System.out.println("Rent #" + (i+1) + ":");
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Room: ");
			int room = sc.nextInt();
			
			students[room] = new Student(name, email, room);
		}
		
		System.out.println("\nBusy rooms:");
		for (int j = 0; j < students.length; j++) {
			if (students[j] != null) {
				System.out.println(students[j]);
			}
		}
		sc.close();
	}

}
