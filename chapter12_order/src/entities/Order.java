package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private LocalDateTime moment;
	private OrderStatus status;
	
	private List<OrderItem> items = new ArrayList<>();
	private Client client = new Client();
	
	private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	public Order() {
		
	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double sum = 0.0;
		for (OrderItem item : items) {
			sum += item.subTotal();
		}
		
		return sum;
	}

	@Override
	public String toString() {
		
		StringBuilder build = new StringBuilder();
		
		build.append("Order moment: " + moment.format(format));
		build.append("\nOrder status: " + status);
		build.append("\nClient: " + client);
		build.append("\nOrder items: ");
		
		for (OrderItem item : items) {
			build.append(item + "\n");
		}
		
		build.append("Total price: " + total());
		
		return build.toString();
				
			
	}
	
	
}
