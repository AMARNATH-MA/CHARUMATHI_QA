import java.util.Scanner;

// 1. Vehicle Class
class Vehicle {
    private String licensePlate;
    private String type; // e.g., Car, Bike

    public Vehicle(String licensePlate, String type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() { return licensePlate; }
    @Override
    public String toString() { return type + " (" + licensePlate + ")"; }
}

// 2. Slot Class - Contains vehicle reference
class Slot {
    private int slotId;
    private Vehicle parkedVehicle;

    public Slot(int slotId) {
        this.slotId = slotId;
        this.parkedVehicle = null; // Initially empty
    }

    public boolean isAvailable() { return parkedVehicle == null; }
    public void park(Vehicle v) { this.parkedVehicle = v; }
    public void remove() { this.parkedVehicle = null; }
    public Vehicle getParkedVehicle() { return parkedVehicle; }
    public int getSlotId() { return slotId; }
}

// 3. ParkingLot Class - Manages slots
class ParkingLot {
    private Slot[] slots;

    public ParkingLot(int numberOfSlots) {
        slots = new Slot[numberOfSlots];
        for (int i = 0; i < numberOfSlots; i++) {
            slots[i] = new Slot(i + 1); // Slot IDs start from 1
        }
    }

    // Function 1: parkVehicle()
    public void parkVehicle(String licensePlate, String type) {
        Vehicle vehicle = new Vehicle(licensePlate, type);
        for (Slot slot : slots) {
            if (slot.isAvailable()) {
                slot.park(vehicle);
                System.out.println("Vehicle " + vehicle + " parked in Slot " + slot.getSlotId());
                return;
            }
        }
        System.out.println("Parking Full! Cannot park " + vehicle);
    }

    // Function 2: removeVehicle()
    public void removeVehicle(String licensePlate) {
        for (Slot slot : slots) {
            if (!slot.isAvailable() && slot.getParkedVehicle().getLicensePlate().equals(licensePlate)) {
                slot.remove();
                System.out.println("Vehicle with plate " + licensePlate + " removed from Slot " + slot.getSlotId());
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }
}

// 4. Main Program with Scanner
public class ParkingSystemV1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total parking slots: ");
        int slots = scanner.nextInt();
        
        // Creating object using scanner
        ParkingLot lot = new ParkingLot(slots);
        
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Parking System ---");
            System.out.println("1. Park Vehicle\n2. Remove Vehicle\n3. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter License Plate: ");
                    String plate = scanner.nextLine();
                    System.out.print("Enter Type (Car/Bike): ");
                    String type = scanner.nextLine();
                    lot.parkVehicle(plate, type);
                    break;
                case 2:
                    System.out.print("Enter License Plate to remove: ");
                    String removePlate = scanner.nextLine();
                    lot.removeVehicle(removePlate);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
        scanner.close();
    }
}