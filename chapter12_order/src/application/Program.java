package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		LocalDate birthDate = LocalDate.parse(sc.nextLine(), format);
		
		Client client = new Client(clientName, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		
		Order order = new Order(LocalDateTime.now(), status, client);
		
		System.out.print("How many items to this order? ");
		int quantity = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < quantity; i++) {
			System.out.println("Enter #" + (i+1) + " item data: ");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			sc.nextLine();
			System.out.print("Quantity: ");
			int itemQuantity = sc.nextInt();
			sc.nextLine();
			
			Product product = new Product(productName, price);
			OrderItem orderItem = new OrderItem(itemQuantity, price, product);
			order.addItem(orderItem);	
			
		}
		
		System.out.println("\nORDER SUMMARY: ");
		System.out.println(order);
		
		
		sc.close();
	}

}
