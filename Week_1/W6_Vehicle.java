// File: Vehicle.java
import java.util.Random;

public class W6_Vehicle {
    // 🔹 Protected fields (accessible to subclasses)
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    // 🔹 Private fields
    private String registrationNumber;
    private boolean isRunning;

    // 🔹 Default constructor
    public W6_Vehicle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.engineType = "Petrol";
        this.registrationNumber = generateRandomReg();
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    // 🔹 Parameterized constructor
    public W6_Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = generateRandomReg();
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    // 🔹 Generate random registration number
    private String generateRandomReg() {
        return "REG-" + new Random().nextInt(10000);
    }

    // 🔹 Vehicle operations
    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year +
                ", Engine: " + engineType + ", Reg#: " + registrationNumber +
                ", Running: " + isRunning;
    }

    public void displaySpecs() {
        System.out.println("Vehicle Specs → " + brand + " " + model + " (" + year + "), Engine: " + engineType);
    }

    // 🔹 Getter & Setter for private fields
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String reg) {
        this.registrationNumber = reg;
    }

    public boolean isRunning() {
        return isRunning;
    }
}

// 🔹 Car class extending Vehicle
class Car extends W6_Vehicle {
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    // 🔹 Default constructor
    public Car() {
        super(); // Calls Vehicle default constructor
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    // 🔹 Parameterized constructor
    public Car(String brand, String model, int year, String engineType,
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType); // Calls Vehicle parameterized constructor
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    // 🔹 Overriding start()
    @Override
    public void start() {
        super.start(); // Call Vehicle’s start
        System.out.println("Car-specific: Ignition sequence started, " + brand + " is ready!");
    }

    // 🔹 Overriding displaySpecs()
    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Car Specs → Doors: " + numberOfDoors + ", Fuel: " + fuelType + ", Transmission: " + transmissionType);
    }

    // 🔹 Car-specific methods
    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    // 🔹 Main for testing
    public static void main(String[] args) {
        System.out.println("----- TEST 1: Default Constructor -----");
        Car car1 = new Car();
        car1.start();
        car1.displaySpecs();
        car1.openTrunk();
        car1.playRadio();
        System.out.println(car1.getVehicleInfo());

        System.out.println("\n----- TEST 2: Parameterized Constructor -----");
        Car car2 = new Car("Toyota", "Corolla", 2023, "Hybrid", 4, "Petrol", "Automatic");
        car2.start();
        car2.displaySpecs();
        car2.stop();
        System.out.println(car2.getVehicleInfo());
    }
}
