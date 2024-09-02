package services;

import models.customer.Customer;
import models.reserve.Reservation;
import models.rooms.IRoom;
import models.rooms.Room;

import java.util.*;

public class ReservationService {
    // database
    private final Map<String, Room> rooms = new HashMap<> ();
    private final Map<String, Collection<Reservation>> reservations = new HashMap<> ();

    private static final ReservationService ref = new ReservationService ();

    public static ReservationService getInstance() {
        return ref;
    }

    public void addRoom(Room room) {
        System.out.println (room.getRoomNumber ());
        rooms.put (room.getRoomNumber (), room);
    }


    public Room getARoom(String roomId) {
        return rooms.get (roomId);

    }

    public Collection<Room> getAllRoom() {
        return rooms.values ();
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        return null;

    }

    public Collection<Reservation> getCustomerReservations(String customerEmail) {
        return reservations.get (customerEmail);

    }

    public Map<String, Collection<Reservation>> getAllReservations() {
        return reservations;
    }

    public void addReservation(String customerEmail, Room room, Date checkInDate, Date checkOutDate) {
        try {

            Collection<Reservation> foundReservationOfEmail = reservations.get (customerEmail);

            if (foundReservationOfEmail != null) {
                foundReservationOfEmail.add (new Reservation (customerEmail, room, checkInDate, checkOutDate));
            } else {
                Collection<Reservation> reservationsOfEmail = new LinkedList<Reservation> ();
                reservationsOfEmail.add (new Reservation (customerEmail, room, checkInDate, checkOutDate));
                reservations.put (customerEmail, reservationsOfEmail);

            }
        } catch (Exception e) {
            throw e;
        }

    }
}
