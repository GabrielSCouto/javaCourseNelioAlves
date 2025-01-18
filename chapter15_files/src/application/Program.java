package application;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("How many product to add? ");
			int amount = sc.nextInt();
			sc.nextLine();

			for (int i = 0; i < amount; i++) {
				System.out.println("Enter product #" + (i + 1) + " data:");
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: $");
				double price = sc.nextDouble();
				sc.nextLine();
				System.out.print("Amount: ");
				int itemAmount = sc.nextInt();
				sc.nextLine();

				Product.addProduct(new Product(name, price, itemAmount));

			}

			Product.addCSV();

			System.out.print("\nEnter path to create 'out' folder: ");
			String path = sc.nextLine();

			Product.addSummary(path);
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}

}
