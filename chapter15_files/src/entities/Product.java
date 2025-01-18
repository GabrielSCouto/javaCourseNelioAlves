package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private Double price;
	private Integer amount;

	static List<Product> list = new ArrayList<>();
	static final String IN_FILE = "in.csv";
	static final String OUT_FILE = "summary.csv";

	public Product() {

	}

	public Product(String name, Double price, Integer amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public static void addProduct(Product product) {
		list.add(product);
	}

	public static void addCSV() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(IN_FILE))) {
			for (Product line : list) {
				writer.write(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addSummary(String path) throws IOException {
		File folder = new File(path + "\\out");
		if (!folder.exists() && folder.mkdir()) {
			System.out.println("Successfully created OUT directory: " + folder.getPath());
		}

		File summaryFile = new File(path + "\\out\\summary.csv");

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(summaryFile));
				BufferedReader reader = new BufferedReader(new FileReader(IN_FILE))) {
			String line = reader.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				if (fields.length == 3) {
					String productName = fields[0];
					double price = Double.parseDouble(fields[1]);
					int amount = Integer.parseInt(fields[2]);

					double total = price * amount;

					writer.write(productName + "," + String.format("%.2f", total));
					writer.newLine();
				}
				line = reader.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Failed to process file: " + e.getMessage());
		}
	}

	public String toString() {
		return name + "," + price + "," + amount;
	}

}
