package program;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		Account account = new Account();
		
		System.out.print("Enter account number: ");
		String number = sc.nextLine();
		System.out.print("Enter account holder: ");
		String name = sc.nextLine();
		
		System.out.print("Is there an initial deposit (y/n)? ");
		String option = sc.nextLine();
		
		if (option.equals("y")) {
			System.out.print("Enter initial deposit value: $");
			double deposit = sc.nextDouble();
			
			account = new Account(number,name,deposit);
			account.increaseBalance(deposit);
			
		} else if (option.equals("n")) {
			account = new Account(number,name);
			
		} else { 
			System.out.println("Invalid answer!"); 
		}
		
		System.out.println("\nAccount data: ");
		System.out.println(account); // toString()
		
		System.out.println();
		System.out.print("Enter a deposit value: $");
		
		double increase = sc.nextDouble();
		account.increaseBalance(increase);
		
		System.out.println("\nUpdated account data: ");
		System.out.println(account);
		
		System.out.println();
		System.out.print("Enter a withdraw value: $");
		
		double withdraw = sc.nextDouble();
		account.withdraw(withdraw);
		
		System.out.println("\nUpdated account data: ");
		System.out.println(account);
		
		sc.close();

	}

}
