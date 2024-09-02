package api;

import models.customer.Customer;
import models.rooms.IRoom;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    static AdminResource instance = new AdminResource ();

    public static AdminResource getInstance() {
        return instance;
    }

    public Customer getCustomer(String email) {
        return null;
        
    }

    public void addRoom(List<IRoom> rooms) {
    }

    public Collection<IRoom> getAllRooms() {
        return null;

    }

    public Collection<Customer> getAllCustomers() {
        return null;
    }

    public void displayAllReservations() {

    }
}
