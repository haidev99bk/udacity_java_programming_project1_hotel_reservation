package api;

import models.customer.Customer;
import models.reserve.Reservation;
import models.rooms.IRoom;
import services.CustomerService;

import java.util.Collection;
import java.util.Date;

public class HotelResouce {
    CustomerService customerService = CustomerService.getInstance ();
    static HotelResouce ref = new HotelResouce ();

    public static HotelResouce getInstance() {
        return ref;
    }

    public Customer getCustomer(String email) {
        return null;

    }

    public void createACustomer(String email, String firstName, String lastName) {
        try {
            customerService.addCustomer (email, firstName, lastName);
            System.out.println ("Create an account successfully.");
        } catch (Exception ex) {
            throw ex;
        }
    }

    public IRoom getRooms(String roomNumber) {
        return null;

    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return null;

    }

    public Collection<Reservation> getCustomerReservations(String customerEmail) {
        return null;

    }

    public Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate) {
        return null;

    }
}
