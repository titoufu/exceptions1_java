package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Reservation reserva = new Reservation();
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Room number: ");
		int room = sc.nextInt();
		System.out.print("Check in date (dd/MM/yyyy): ");
		Date dataIn = sdf.parse(sc.next());
		System.out.print("Check out date (dd/MM/yyyy): ");
		Date dataOut = sdf.parse(sc.next());
		if (!dataOut.after(dataIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			reserva = new Reservation(room, dataIn, dataOut);
			System.out.println("Reservation: " + reserva);
			System.out.println(" ");
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check in date (dd/MM/yyyy): ");
			dataIn = sdf.parse(sc.next());
			System.out.print("Check out date (dd/MM/yyyy): ");
			dataOut = sdf.parse(sc.next());
			String erro = reserva.updateDates(dataIn, dataOut);
			if (erro != null) {
				System.out.println(erro);
			} else {
				reserva = new Reservation(room, dataIn, dataOut);
				System.out.println("Reservation: " + reserva);
			}
		}
		sc.close();
	}
}
