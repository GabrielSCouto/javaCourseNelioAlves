package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		Department department = new Department(sc.nextLine());
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		WorkerLevel level = WorkerLevel.valueOf(sc.nextLine());
		System.out.print("Base salary: $");
		Double salary = sc.nextDouble();
		sc.nextLine();
		
		Worker worker = new Worker(name, level, salary, department);
		
		System.out.print("How many contracts to this worker? ");
		int contract = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < contract; i++) {
			System.out.println("Enter contract #" + (i+1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			String date = sc.nextLine();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.parse(date, format);
			System.out.print("Value per hour: $");
			double value = sc.nextDouble();
			sc.nextLine();
			System.out.print("Duration (hours): ");
			Integer hours = sc.nextInt();
			sc.nextLine();
			
			HourContract hourContract = new HourContract(localDate, value, hours);
			worker.addContract(hourContract);
		}
		
		
		System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
		String dateIncome = sc.nextLine();
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("MM/yyyy");
		YearMonth yearMonth = YearMonth.parse(dateIncome, format2);
		
		
		System.out.println("Name: " + worker.getName() + "\nDepartment: " + worker.getDepartment().getName() + "\nIncome for " +
		yearMonth.getMonthValue() + "/" + yearMonth.getYear() + ": $" + String.format("%.2f", worker.income(yearMonth)));
		
		sc.close();
	}

}
