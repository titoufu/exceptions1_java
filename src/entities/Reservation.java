package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import entities.exceptions.DomainException;

public class Reservation {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer roomNumber;
	private Date dataIn;
	private Date dataOut;

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date dataIn, Date dataOut) throws DomainException {
		if (!dataOut.after(dataIn)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.dataIn = dataIn;
		this.dataOut = dataOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return dataIn;
	}

	public Date getCheckout() {
		return dataOut;
	}

	public long duration() {
		long diff = dataOut.getTime() - dataIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date dataIn, Date dataOut) throws DomainException {
		Date now = new Date();
		if (dataIn.before(now) || dataOut.before(now)) {
			throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
		}
		if (!dataOut.after(dataIn)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		this.dataIn = dataIn;
		this.dataOut = dataOut;
	}

	@Override
	public String toString() {
		return "Room: " + roomNumber + ", dataIn= " + sdf.format(dataIn) + ", dataOut= " + sdf.format(dataOut)
				+ ", nights= " + duration();
	}

}
