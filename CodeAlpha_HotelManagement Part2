import java.io.*;
import java.util.*;

public class HotelManager {

    private List<Room> rooms;
    private List<Reservation> reservations;

    private final String ROOM_FILE = "rooms.dat";
    private final String RES_FILE = "reservations.dat";

    public HotelManager() {
        rooms = loadRooms();
        reservations = loadReservations();

        if (rooms.isEmpty()) {
            initializeRooms();
            saveRooms();
        }
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Standard", 100));
        rooms.add(new Room(102, "Standard", 100));
        rooms.add(new Room(201, "Deluxe", 180));
        rooms.add(new Room(202, "Deluxe", 180));
        rooms.add(new Room(301, "Suite", 300));
    }

    public void showAvailableRooms() {
        for (Room r : rooms) {
            if (r.isAvailable()) {
                System.out.println(r);
            }
        }
    }

    public void bookRoom(String name, String category) {
        for (Room r : rooms) {
            if (r.getCategory().equalsIgnoreCase(category) && r.isAvailable()) {
                System.out.println("Processing payment of $" + r.getPrice() + "...");
                r.setAvailable(false);

                Reservation res = new Reservation(name, r.getRoomNumber(), category, r.getPrice());
                reservations.add(res);

                saveRooms();
                saveReservations();

                System.out.println("Booking Successful!");
                System.out.println(res);
                return;
            }
        }
        System.out.println("No rooms available in this category.");
    }

    public void cancelReservation(int roomNumber) {
        Iterator<Reservation> iterator = reservations.iterator();

        while (iterator.hasNext()) {
            Reservation res = iterator.next();
            if (res.getRoomNumber() == roomNumber) {
                iterator.remove();
                for (Room r : rooms) {
                    if (r.getRoomNumber() == roomNumber) {
                        r.setAvailable(true);
                    }
                }
                saveRooms();
                saveReservations();
                System.out.println("Reservation cancelled successfully.");
                return;
            }
        }
        System.out.println("Reservation not found.");
    }

    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            reservations.forEach(System.out::println);
        }
    }

    private void saveRooms() {
        saveObject(ROOM_FILE, rooms);
    }

    private void saveReservations() {
        saveObject(RES_FILE, reservations);
    }

    private List<Room> loadRooms() {
        return loadObject(ROOM_FILE);
    }

    private List<Reservation> loadReservations() {
        return loadObject(RES_FILE);
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> loadObject(String file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void saveObject(String file, Object obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
