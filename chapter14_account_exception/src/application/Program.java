package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Enter amount of accounts: ");
			int amount = sc.nextInt();
			sc.nextLine();
			List<Account> accountList = new ArrayList<>();

			for (int i = 0; i < amount; i++) {
				System.out.println("Account #" + (i + 1) + " data: ");
				System.out.print("Account number: ");
				int number = sc.nextInt();
				sc.nextLine();
				System.out.print("Holder: ");
				String holder = sc.nextLine();
				System.out.print("Initial balance: $");
				double initBalance = sc.nextDouble();
				sc.nextLine();
				System.out.print("Withdraw limit: $");
				double withdrawLimit = sc.nextDouble();
				sc.nextLine();

				accountList.add(new Account(number, holder, initBalance, withdrawLimit));
			}

			System.out.println("\nACCOUNTS DATA:");
			for (Account a : accountList) {
				System.out.println(a);
			}

			System.out.print("\nEnter account number to make operations: ");
			int number = sc.nextInt();
			sc.nextLine();

			Account search = accountList.stream().filter(x -> x.getNumber() == number).findFirst().orElse(null);

			if (search.getNumber() != null) {
				System.out.print("Enter amount for withdraw: $");
				double withdraw = sc.nextDouble();
				sc.nextLine();
				search.withdraw(withdraw);
			}

			for (Account a : accountList) {
				System.out.println(a);
			}

		} catch (DomainException e) {
			System.out.println("Operation error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Invalid entry! " + e.getMessage());
		}

		sc.close();
	}

}
