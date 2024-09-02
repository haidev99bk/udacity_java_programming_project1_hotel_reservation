package api;

import models.customer.Customer;
import models.reserve.Reservation;
import models.rooms.IRoom;
import models.rooms.Room;
import services.CustomerService;
import services.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResouce {
    static CustomerService customerService = CustomerService.getInstance ();
    static ReservationService reservationService = ReservationService.getInstance ();
    static HotelResouce ref = new HotelResouce ();

    public static HotelResouce getInstance() {
        return ref;
    }

    public static Customer getCustomer(String email) {
        return customerService.getCustomer (email);
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

    public static Room getRoom(String roomNumber) {
        return reservationService.getARoom (roomNumber);

    }

    public static Collection<Room> getAvailableRooms() {
        // todo: update
        return reservationService.getAllRoom ();
    }

    public static void bookARoom(String customerEmail, Room room, Date checkInDate, Date checkOutDate) {
        System.out.println ("here" + customerEmail);
        try {
            reservationService.addReservation (customerEmail, room, checkInDate, checkOutDate);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public static Collection<Reservation> getCustomerReservations(String customerEmail) {
        return null;

    }

    public static Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate) {
        return null;

    }
}
