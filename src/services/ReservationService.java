package services;

import models.customer.Customer;
import models.reserve.Reservation;
import models.rooms.IRoom;

import java.util.Collection;
import java.util.Date;

public class ReservationService {
    private static final ReservationService ref = new ReservationService ();

    public static ReservationService getInstance() {
        return ref;
    }

    public void addRoom(IRoom room) {
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
