package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;
import entities.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			int room = sc.nextInt();
			System.out.print("Check in date (dd/MM/yyyy): ");
			Date dataIn = sdf.parse(sc.next());
			System.out.print("Check out date (dd/MM/yyyy): ");
			Date dataOut = sdf.parse(sc.next());
			Reservation reserva = new Reservation(room, dataIn, dataOut);
			System.out.println("Reservation: " + reserva);
			System.out.println(" ");
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check in date (dd/MM/yyyy): ");
			dataIn = sdf.parse(sc.next());
			System.out.print("Check out date (dd/MM/yyyy): ");
			dataOut = sdf.parse(sc.next());
			reserva.updateDates(dataIn, dataOut);
			System.out.println("Reservation: " + reserva);
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
