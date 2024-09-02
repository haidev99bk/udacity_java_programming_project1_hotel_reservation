package models.reserve;

import models.customer.Customer;
import models.rooms.IRoom;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    @Override
    public String toString() {
        return new String ("Customer: " + this.customer + "\n" +
                "Room: " + this.room + "\n" +
                "Check In Date: " + this.checkInDate + "\n" +
                "Check Out Date: " + this.checkOutDate);
    }

}
