import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    public static void start() {
        printMenu ();
        Scanner scanner = new Scanner (System.in);
        try {
            String select = "";
            do {
                System.out.println ("Pls select:");
                select = scanner.nextLine ();

                if (select.length () == 1) {
                    switch (select.charAt (0)) {
                        case '1':
                            System.out.println ("Find and ReserveRoom");
                            break;
                        case '2':
                            System.out.println ("See my revervation");
                            break;
                        case '3':
                            System.out.println ("Create account");
                            break;
                        case '4':
                            System.out.println ("Open Admin menu");
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
            } while (!select.equals ("5"));
        } catch (Exception e) {
            System.out.println (e.getMessage ());
        }

    }


    public static void printMenu() {
        System.out.println ("The Hotel Reservation application");
        System.out.println ("_________________________________");
        System.out.println ("1. Find and reserve a room");
        System.out.println ("2. See all my reservations");
        System.out.println ("3. Create an account");
        System.out.println ("4. Open admin menu");
        System.out.println ("4. Exit the app");
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
