import api.AdminResource;
import api.HotelResouce;
import models.customer.Customer;
import models.reserve.Reservation;
import models.rooms.IRoom;
import models.rooms.Room;
import models.rooms.enums.RoomType;

import java.security.PublicKey;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class AdminMenu {
    // api
    static final HotelResouce hotelResouce = HotelResouce.getInstance ();
    static final AdminResource adminResource = AdminResource.getInstance ();

    public static void start() {
        printMenu ();

        Scanner scanner = new Scanner (System.in);
        String select = "";

        do {
            select = scanner.nextLine ();
            handleUserSelect (select);

        } while (!select.equals ("5"));

    }

    public static void printMenu() {
        System.out.println ("Admin Menu:");
        System.out.println ("_________________________________");
        System.out.println ("1. See all customers");
        System.out.println ("2. See all Rooms");
        System.out.println ("3. See all Reservations");
        System.out.println ("4. Add a room");
        System.out.println ("5. Back to the main menu");
    }

    private static void handleUserSelect(String select) {
        try {

            switch (select) {
                case "1": {
                    System.out.println ("See all customer");
                    seeAllCustomers ();
                    break;
                }
                case "2": {
                    System.out.println ("See all Rooms");
                    seeAllRooms ();
                    break;

                }
                case "3": {
                    System.out.println ("See all Reservations");
                    seeAllReservations ();
                    break;

                }
                case "4": {
                    System.out.println ("Add a room");
                    addARoom ();
                    break;

                }
                case "5": {
                    System.out.println (" Back to the main menu");
                    MainMenu.start ();
                    break;
                }
                default:
                    System.out.println ("Invalid action");
                    break;
            }
        } catch (Exception e) {
            System.out.println (e.getMessage ());
        }
    }

    // case1:
    public static void seeAllCustomers() {
        Collection<Customer> customers = hotelResouce.getAllCustomer ();

        if (customers.isEmpty ()) {
            System.out.println ("There are no customers");
        } else {
            for (Customer customer : customers) {
                System.out.println (customer.toString ());
            }
        }
        start ();
    }


    // case2:
    public static void seeAllRooms() {
        Collection<Room> rooms = adminResource.getAllRooms ();

        for (Room room : rooms) {
            System.out.println (room.toString ());
        }

        start ();
    }

    // case3:
    public static void seeAllReservations() {
        Collection<Collection<Reservation>> reservations = hotelResouce.getAllReservations ();
        if (reservations.isEmpty () || reservations == null) {
            System.out.println ("There are no reservations");
        } else {
            for (Collection<Reservation> _reservations : reservations) {
                for (Reservation res : _reservations) {
                    System.out.println (res.toString ());
                }
            }
        }
    }

    // case 4:
    public static void addARoom() {
        try {
            final Scanner scanner = new Scanner (System.in);
            System.out.println ("Pls input room number:");
            final String roomNumber = scanner.nextLine ();

            System.out.println ("Pls input room price:");
            final Double roomPrice = Double.parseDouble (scanner.nextLine ());

            System.out.println ("Pls input room type: \n1 for single bed and 2 for double bed:");
            RoomType type = null;
            String input = scanner.nextLine ();

            if (input.equals ("1")) {
                type = RoomType.SINGLE;
            }
            if (input.equals ("2")) {
                type = RoomType.DOUBLE;
            }
            if (type == null) {
                throw new IllegalArgumentException ();
            }

            Room newRoom = new Room (roomNumber, roomPrice, type);
            adminResource.addRoom (newRoom);

            System.out.println ("Room added.");
            start ();
        } catch (NumberFormatException e) {
            System.out.println ("Invalid input, pls input double value");
            if (checkTryAgain ()) {
                addARoom ();
            } else {
                start ();
            }
        } catch (IllegalArgumentException e) {
            System.out.println ("Invalid room type");
            if (checkTryAgain ()) {
                addARoom ();
            } else {
                start ();
            }
        }


    }


    private static boolean checkTryAgain() {
        String select = "";
        Scanner scanner = new Scanner (System.in);

        do {
            System.out.println ("\nTry again ? Y/N \n");
            select = scanner.nextLine ();

            if (select.equals ("Y")) {
                return true;
            }
            if (select.equals ("N")) {
                return false;
            }

            System.out.println ("Pls input 'Y' or 'N'.");
            checkTryAgain ();
        } while (select.charAt (0) != 'Y' && select.charAt (0) != 'N');
        return false;
    }

}
