package services;

import models.customer.Customer;
import models.reserve.Reservation;
import models.rooms.IRoom;
import models.rooms.Room;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservationService {
    // database
    private final Map<String, IRoom> rooms = new HashMap<> ();

    private static final ReservationService ref = new ReservationService ();

    public static ReservationService getInstance() {
        return ref;
    }

    public void addRoom(Room room) {
        System.out.println (room.getRoomNumber ());
        rooms.put (room.getRoomNumber (), room);
    }


    public IRoom getARoom(String roomId) {
        return null;

    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        return null;

    }

    public Collection<Reservation> getCustomerReservations(Customer customer) {
        return null;

    }

    public void printAllReservations() {
    }


}
