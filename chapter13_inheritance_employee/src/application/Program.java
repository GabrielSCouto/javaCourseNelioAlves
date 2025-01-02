package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of employees: ");
		int amount = sc.nextInt();
		sc.nextLine();
		
		Employee[] list = new Employee[amount];
		
		for (int i = 0; i < list.length; i++ ) {
			System.out.println("Employee #" + (i+1) + " data:");
			
//			System.out.print("Outsourced? (y/n)? ");
//			String option = sc.nextLine().trim().toLowerCase();
//			System.out.print("Name: ");
//			String name  = sc.nextLine();
//			System.out.print("Hours: ");
//			int hours = sc.nextInt();
//			sc.nextLine();
//			System.out.print("Value per hour: $");
//			double valueHour = sc.nextDouble();
//			sc.nextLine();
			String option;		
			do {
				
				System.out.print("Outsourced? (y/n)? ");
				option = sc.nextLine().trim().toLowerCase();
				System.out.print("Name: ");
				String name  = sc.nextLine();
				System.out.print("Hours: ");
				int hours = sc.nextInt();
				sc.nextLine();
				System.out.print("Value per hour: $");
				double valueHour = sc.nextDouble();
				sc.nextLine();
				
				switch (option) {
				case "y":
					System.out.print("Additional charge: $");
					double additional = sc.nextDouble();
					sc.nextLine();
					list[i] = new OutsourcedEmployee(name, hours, valueHour, additional);
					break;
					
				case "n":					
					list[i] = new Employee(name, hours, valueHour);
					break;
					
				default:
					System.out.println("'" + option + "' is an invalid entry to 'Outsourced?', use only 'y/s'!");
                    break;
				}
			} while (!option.equalsIgnoreCase("y") && !option.equalsIgnoreCase("n"));			
		}
		
		System.out.println("\nPAYMENTS: ");
		for (Employee emp : list) {
			System.out.println(emp);
		}
		
		
		sc.close();
	}

}
