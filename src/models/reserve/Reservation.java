package models.reserve;

import models.customer.Customer;
import models.rooms.Room;

import java.util.Date;

public class Reservation {
    private String customerEmail;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(String customerEmail, Room room, Date checkInDate, Date checkOutDate) {
        this.customerEmail = customerEmail;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Room getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public String toString() {
        return new String ("Customer: " + this.customerEmail + "\n" +
                "Room: " + this.room + "\n" +
                "Check In Date: " + this.checkInDate + "\n" +
                "Check Out Date: " + this.checkOutDate);
    }

}
