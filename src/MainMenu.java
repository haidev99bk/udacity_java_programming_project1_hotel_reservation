import api.HotelResouce;
import models.customer.Customer;
import models.reserve.Reservation;
import models.rooms.Room;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;


public class MainMenu {
    // api
    private static final HotelResouce hotelResouce = HotelResouce.getInstance ();

    public static void start() {
        printMenu ();
        handleActions ();
    }

    public static void printMenu() {
        System.out.println ("The Hotel Reservation application");
        System.out.println ("_________________________________");
        System.out.println ("1. Find and reserve a room");
        System.out.println ("2. See all my reservations");
        System.out.println ("3. Create an account");
        System.out.println ("4. Open admin menu");
        System.out.println ("5. Exit the app");
    }

    public static void handleActions() {
        Scanner scanner = new Scanner (System.in);
        try {
            String select = "";
            do {
                select = scanner.nextLine ();

                if (select.length () == 1) {
                    switch (select.charAt (0)) {
                        case '1':
                            System.out.println ("Find and ReserveRoom");
                            findAndReserveRoom ();
                            break;
                        case '2':
                            System.out.println ("See my reservation");
                            seeMyReservations ();
                            break;
                        case '3':
                            System.out.println ("Create account");
                            createAccount ();
                            break;
                        case '4':
                            System.out.println ("Open Admin menu");
                            openAdminMenu ();
                            break;
                        case '5':
                            System.out.println ("Exit");
                            break;
                        default:
                            System.out.println ("Invalid action");
                            start ();
                            break;
                    }

                } else {
                    System.out.println ("Pls input valid value");
                    start ();
                }
            } while (!select.equals ("5") && !select.equals ("4"));
        } catch (Exception e) {
            System.out.println (e.getMessage ());
        }
    }

    // case 3: Create account
    public static void createAccount() {
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Pls input the email: ");
        final String email = scanner.nextLine ();

        System.out.println ("Pls input First Name: ");
        final String firstName = scanner.nextLine ();

        System.out.println ("Pls input Last Name: ");
        final String lastName = scanner.nextLine ();

        try {
            hotelResouce.createACustomer (email, firstName, lastName);
            start ();
        } catch (Exception e) {
            Boolean isTryAgain = checkTryAgain ();
            if (isTryAgain) {
                createAccount ();
            } else {
                start ();
            }
            System.out.println (e.getMessage ());
        }
    }

    private static boolean checkTryAgain() {
        String select = "";
        Scanner scanner2 = new Scanner (System.in);

        do {
            System.out.println ("\nTry again ? Y/N \n");
            select = scanner2.nextLine ();

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


    // case 4: Open admin
    public static void openAdminMenu() {
        AdminMenu.start ();
    }


    // case1: find and reserve room
    private static void findAndReserveRoom() {
        try {

            System.out.println ("Enter CheckIn Date with format mm/dd/yyyy:");
            final Scanner scanner = new Scanner (System.in);
            String dateString = scanner.nextLine ();
            Date checkInDate = parseDate (dateString);

            System.out.println ("Enter CheckOut Date with format mm/dd/yyyy:");
            dateString = scanner.nextLine ();
            Date checkOutDate = parseDate (dateString);

            if (checkInDate != null && checkOutDate != null) {
                // find available rooms
                Collection<Room> availableRooms = hotelResouce.getAvailableRooms ();
                for (Room room : availableRooms) {
                    System.out.println (room.toString ());
                }

                // start book
                System.out.println ("Start booking ? Y/N \n");
                Scanner scanner3 = new Scanner (System.in);
                String isToBook = scanner3.nextLine ();
                System.out.println (isToBook + " " + (!isToBook.equals ("Y") && !isToBook.equals ("N")));
                while (!isToBook.equals ("Y") && !isToBook.equals ("N")) {
                    System.out.println ("Invalid input");
                    System.out.println ("Start booking ? Y/N \n");
                    isToBook = scanner3.nextLine ();
                }

                if (isToBook.equals ("Y")) {
                    Scanner scanner4 = new Scanner (System.in);
                    System.out.println ("You already have an email ? Y/N \n");
                    String hadEmail = scanner4.nextLine ();

                    while (!hadEmail.equals ("Y") && !hadEmail.equals ("N")) {
                        System.out.println ("Invalid input");
                        System.out.println ("You already have an email ? Y/N \n");
                        hadEmail = scanner4.nextLine ();
                    }

                    if (hadEmail.equals ("Y")) {
                        System.out.println ("Pls input your email?");
                        Scanner scanner5 = new Scanner (System.in);
                        String email = scanner5.nextLine ();
                        Customer foundCustomer = hotelResouce.getCustomer (email);

                        if (foundCustomer != null) {
                            System.out.println ("Pls input room number you want to book");
                            Scanner scanner6 = new Scanner (System.in);
                            String roomNumber = scanner6.nextLine ();
                            Room foundRoom = hotelResouce.getRoom (roomNumber);

                            System.out.println ("foundRoom => " + foundRoom);
                            if (foundRoom != null) {
                                hotelResouce.bookARoom (email, foundRoom, checkInDate, checkOutDate);
                                System.out.println ("Room is successfully booked");
                                start ();
                            } else {
                                System.out.println ("Room number not found. Pls try again");
                                start ();
                            }

                        } else {
                            System.out.println ("Customer not found. \n Create your account if you have don't have it");
                            start ();
                        }


                    } else if (hadEmail.equals ("N")) {
                        System.out.println ("Create an account first");
                        start ();
                    } else {
                        System.out.println ("Invalid input");
                        System.out.println ("You already have an email ? Y/N \n");
                    }

                } else if (isToBook.equals ("N")) {
                    start ();
                } else {
                    System.out.println ("Invalid input");
                    System.out.println ("Start booking ? Y/N \n");
                }

            }
        } catch (IllegalArgumentException e) {
            System.out.println ("Invalid format. Pls try again");
            findAndReserveRoom ();
        }

    }

    // case2: see my reservations
    private static void seeMyReservations() {
        final Scanner scanner = new Scanner (System.in);

        System.out.println ("Pls input your email:");
        String email = scanner.nextLine ();
        Collection<Reservation> myReservations = hotelResouce.getCustomerReservations (email);

        if (myReservations == null || myReservations.isEmpty ()) {
            System.out.println ("No reservations found.");
            start ();
        } else {
            for (Reservation reservation : myReservations) {
                System.out.println ("***");
                System.out.println (reservation.toString ());
            }
        }
    }

    private static Date parseDate(String dateString) {
        final String pattern = "MM/dd/yyyy";
        try {
            return new SimpleDateFormat (pattern).parse (dateString);
        } catch (ParseException e) {
            System.out.println (e.getMessage ());
            throw new IllegalArgumentException ();
        }
    }
}
