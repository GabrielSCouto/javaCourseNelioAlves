package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		if ((int) ChronoUnit.DAYS.between(checkIn, checkOut) <= 0) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	
	public Integer duration() {
		return (int) ChronoUnit.DAYS.between(checkIn, checkOut);	
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) {
		
		if ((int) ChronoUnit.DAYS.between(this.checkIn, checkIn) < 0 || (int) ChronoUnit.DAYS.between(this.checkOut, checkOut) < 0  ) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		
		if ((int) ChronoUnit.DAYS.between(checkIn, checkOut) <= 0) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;		
	}
	
	@Override
	public String toString() {
		return "Reservation: Room " + roomNumber + ", check-in: " + checkIn.format(format) + ", check-out: " + checkOut.format(format) + 
				", " + duration() + " nights";
	}
}
