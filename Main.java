import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HotelManager hotel = new HotelManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== HOTEL RESERVATION SYSTEM ===");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Choose Category (Standard/Deluxe/Suite): ");
                    String cat = sc.nextLine();
                    hotel.bookRoom(name, cat);
                    break;

                case 3:
                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();
                    hotel.cancelReservation(roomNo);
                    break;

                case 4:
                    hotel.viewReservations();
                    break;

                case 5:
                    System.out.println("Thank you! Visit again 😊");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
