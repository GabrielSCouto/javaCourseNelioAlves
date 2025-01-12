package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int room = sc.nextInt();
			sc.nextLine();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(sc.nextLine(), format);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(sc.nextLine(), format);

			Reservation reservation = new Reservation(room, checkIn, checkOut);
			System.out.println(reservation);

			System.out.println("\nEnter data to update reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate newCheckIn = LocalDate.parse(sc.nextLine(), format);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate newCheckOut = LocalDate.parse(sc.nextLine(), format);

			reservation.updateDates(newCheckIn, newCheckOut);
			System.out.println(reservation);
			
		} catch (DomainException e) {
			System.out.println("Error in reservation" + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		
		sc.close();
	}

}
