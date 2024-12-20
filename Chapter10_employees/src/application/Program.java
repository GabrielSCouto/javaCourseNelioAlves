package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int amount = sc.nextInt();
		sc.nextLine();
		
		List<Employee> list = new ArrayList<>();
		
		for (int i = 0; i < amount; i++) {
			System.out.println();
			System.out.println("Employee #" + (i+1) + ":");
			System.out.print("Id: ");
			String id = sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.printf("Salary: ");
			Double salary = sc.nextDouble();
			sc.nextLine();
			
			list.add(new Employee(id, name, salary));
			
		}
		
		System.out.print("\nEnter the employee id that will have salary increased: ");
		String increaseId = sc.nextLine();
		
		Employee result = list.stream().filter(x -> x.getId().equals(increaseId)).findFirst().orElse(null);
		if (result != null) {
			System.out.print("Enter the percentage: ");
			double increasePercentage = sc.nextDouble();
		
			result.increaseSalary(increasePercentage);
		} else {
			System.out.println("This id does not exist!");
		}
		
		System.out.println("\nList of employees:");
		
		for (Employee x : list) {
			System.out.println(x);
		}
		
		sc.close();
	}

}
