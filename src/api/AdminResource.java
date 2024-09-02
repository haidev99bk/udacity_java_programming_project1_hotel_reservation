package api;

import models.customer.Customer;
import models.rooms.IRoom;
import models.rooms.Room;
import services.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    // services
    static ReservationService reservationService = ReservationService.getInstance ();

    static AdminResource instance = new AdminResource ();

    public static AdminResource getInstance() {
        return instance;
    }

    public Customer getCustomer(String email) {
        return null;

    }

    public void addRoom(Room rooms) {
        reservationService.addRoom (rooms);
    }

    public Collection<Room> getAllRooms() {
        return reservationService.getAllRoom ();
    }

    public Collection<Customer> getAllCustomers() {
        return null;
    }

    public void displayAllReservations() {

    }
}
