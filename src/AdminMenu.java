import java.security.PublicKey;
import java.util.Collection;
import java.util.Scanner;

public class AdminMenu {
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
                    break;
                }
                case "2": {
                    System.out.println ("See all Rooms");
                    break;

                }
                case "3": {
                    System.out.println ("See all Reservations");
                    break;

                }
                case "4": {
                    System.out.println ("Add a room");
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

    public void seeAllCustomers() {
    }

    public void seeAllRooms() {
    }

    public void seeAllReservations() {
    }

    public void addARoom() {
    }

}
