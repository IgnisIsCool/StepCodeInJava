public class GameController_Q2{
    // Instance variables for controller configuration
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;     // 0–100
    private double sensitivity;   // 0.1–3.0

    // Default constructor - creates standard gaming setup
    public GameController_Q2() {
        this.controllerBrand = "GenericPad";
        this.connectionType = "USB";
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }

    // Parameterized constructor for custom configuration
    public GameController_Q2(String controllerBrand, String connectionType,
                          boolean hasVibration, int batteryLevel, double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;

        // Validate battery level
        if (batteryLevel < 0) {
            this.batteryLevel = 0;
        } else if (batteryLevel > 100) {
            this.batteryLevel = 100;
        } else {
            this.batteryLevel = batteryLevel;
        }

        // Validate sensitivity
        if (sensitivity < 0.1) {
            this.sensitivity = 0.1;
        } else if (sensitivity > 3.0) {
            this.sensitivity = 3.0;
        } else {
            this.sensitivity = sensitivity;
        }
    }

    // Two-parameter convenience constructor
    public GameController_Q2(String brand, String connectionType) {
        this(brand, connectionType, true, 100, 1.0); // uses defaults for others
    }

    // Methods to test functionality
    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + " controller...");
    }

    public void displayConfiguration() {
        System.out.println("Controller Brand: " + controllerBrand);
        System.out.println("Connection Type: " + connectionType);
        System.out.println("Vibration: " + (hasVibration ? "Enabled" : "Disabled"));
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Sensitivity: " + sensitivity);
    }

    public void testVibration() {
        if (hasVibration) {
            System.out.println("*BUZZ* Vibration test successful!");
        } else {
            System.out.println("Vibration disabled on this controller.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== GAMING CONTROLLER SETUP ===");

        // Create controller with default constructor
        GameController_Q2 defaultController = new GameController_Q2();
        defaultController.displayConfiguration();
        defaultController.calibrateController();
        defaultController.testVibration();

        System.out.println("\n---\n");

        // Create controller with full parameterized constructor
        GameController_Q2 customController = new GameController_Q2("Xbox", "Wireless", true, 85, 2.5);
        customController.displayConfiguration();
        customController.calibrateController();
        customController.testVibration();

        System.out.println("\n---\n");

        // Create controller with convenience constructor
        GameController_Q2 simpleController = new GameController_Q2("PlayStation", "Bluetooth");
        simpleController.displayConfiguration();
        simpleController.calibrateController();
        simpleController.testVibration();
    }
}

