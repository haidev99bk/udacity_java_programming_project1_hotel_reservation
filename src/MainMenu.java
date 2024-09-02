import api.HotelResouce;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

interface Callback {

}

public class MainMenu {

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
                            break;
                        case '2':
                            System.out.println ("See my reservation");
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
                            break;
                    }

                } else {
                    System.out.println ("Pls input valid value");
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

        do {
            System.out.println ("\nTry again ? Y/N \n");
            Scanner scanner2 = new Scanner (System.in);
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


    private static void findAndReserveRoom() {
        System.out.println ("Enter CheckIn Date with format mm/dd/yyyy:");
        final Scanner scanner = new Scanner (System.in);
        String dateString = scanner.nextLine ();
        Date checkInDate = parseDate (dateString);

        System.out.println ("Enter CheckOut Date with format mm/dd/yyyy:");
        dateString = scanner.nextLine ();
        Date checkOutDate = parseDate (dateString);

        if (checkInDate != null && checkOutDate != null) {
            // find available rooms

        }
    }

    private static Date parseDate(String dateString) {
        final String pattern = "MM/dd/yyyy";
        try {
            return new SimpleDateFormat (pattern).parse (dateString);
        } catch (ParseException e) {
            System.out.println (e.getMessage ());
            findAndReserveRoom ();
        }
        return null;
    }
}
