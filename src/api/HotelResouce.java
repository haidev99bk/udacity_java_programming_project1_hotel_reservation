package api;

import models.customer.Customer;
import models.reserve.Reservation;
import models.rooms.IRoom;
import services.CustomerService;

import java.util.Collection;
import java.util.Date;

public class HotelResouce {
    static CustomerService customerService = CustomerService.getInstance ();
    static HotelResouce ref = new HotelResouce ();

    public static HotelResouce getInstance() {
        return ref;
    }

    public static Customer getCustomer(String email) {
        return null;
    }

    public static Collection<Customer> getAllCustomer() {
        return customerService.getAllCustomers ();
    }

    public static void createACustomer(String email, String firstName, String lastName) {
        try {
            customerService.addCustomer (email, firstName, lastName);
            System.out.println ("Create an account successfully.");
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static IRoom getRooms(String roomNumber) {
        return null;

    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return null;

    }

    public static Collection<Reservation> getCustomerReservations(String customerEmail) {
        return null;

    }

    public static Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate) {
        return null;

    }
}
