package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("How many products? ");
		int amount = sc.nextInt();
		sc.nextLine();

		Product[] list = new Product[amount];

		for (int i = 0; i < list.length; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			String typeProduct;
			do {
				System.out.print("Common, used or imported? (c/u/i) ");
				typeProduct = sc.nextLine().trim().toLowerCase();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				sc.nextLine();

				switch (typeProduct) {
				case "c":
					list[i] = new Product(name, price);
					break;
				case "u":
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					LocalDate date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					list[i] = new UsedProduct(name, price, date);
					break;
				case "i":
					System.out.print("Custom fee: ");
					double customFee = sc.nextDouble();
					sc.nextLine();
					list[i] = new ImportedProduct(name, price, customFee);
					break;
				default:
					System.out.println("Invalid type. Try again.");
					break;
				}
			} while (!typeProduct.equalsIgnoreCase("c") && !typeProduct.equalsIgnoreCase("u")
					&& !typeProduct.equalsIgnoreCase("i"));
		}

		System.out.println("\nPRICE TAGS:");

		for (Product p : list) {
			System.out.println(p);
		}

		sc.close();
	}

}
