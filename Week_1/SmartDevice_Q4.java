public class SmartDevice_Q4 {
    private String deviceName;
    private String location;
    private boolean isOnline;
    private double powerConsumption;
    private String[] connectedDevices;
    private int connectionCount;

    // Constructor with parameter names matching field names
    public SmartDevice_Q4(String deviceName, String location,
                       boolean isOnline, double powerConsumption) {
        // disambiguation using this
        this.deviceName = deviceName;
        this.location = location;
        this.isOnline = isOnline;
        this.powerConsumption = powerConsumption;

        // initialize connections
        this.connectedDevices = new String[5];
        this.connectionCount = 0;
    }

    // Method using this for parameter disambiguation
    public void updateLocation(String location) {
        this.location = location;
        System.out.println(this.deviceName + " moved to " + this.location);
    }

    public void updatePowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
        System.out.println("Power consumption updated for " + this.deviceName);
    }

    // Method returning this for chaining
    public SmartDevice_Q4 setOnline(boolean isOnline) {
        this.isOnline = isOnline;
        return this;
    }

    public SmartDevice_Q4 connectToDevice(String deviceName) {
        if (this.connectionCount < this.connectedDevices.length) {
            this.connectedDevices[this.connectionCount] = deviceName;
            this.connectionCount++;
            System.out.println(this.deviceName + " connected to " + deviceName);
        } else {
            System.out.println("Connection limit reached for " + this.deviceName);
        }
        return this; // Enable method chaining
    }

    public SmartDevice_Q4 rename(String deviceName) {
        String oldName = this.deviceName;
        this.deviceName = deviceName;
        System.out.println("Device renamed from " + oldName + " to " + this.deviceName);
        return this;
    }

    public void displayDeviceInfo() {
        System.out.println("\n=== " + this.deviceName + " INFO ===");
        System.out.println("Location: " + this.location);
        System.out.println("Status: " + (this.isOnline ? "Online" : "Offline"));
        System.out.println("Power: " + this.powerConsumption + "W");
        System.out.println("Connections: " + this.connectionCount);
        for (int i = 0; i < this.connectionCount; i++) {
            System.out.println(" -> " + this.connectedDevices[i]);
        }
    }

    // Method that calls other methods using this
    public void performInitialSetup() {
        this.setOnline(true);
        System.out.println(this.deviceName + " initial setup completed");
    }

    public static void main(String[] args) {
        System.out.println("=== SMART HOME DEVICE NETWORK ===");

        // Create devices
        SmartDevice_Q4 light = new SmartDevice_Q4("SmartLight", "Living Room", false, 10.5);
        SmartDevice_Q4 thermostat = new SmartDevice_Q4("ThermoX", "Hallway", true, 5.0);

        // Demonstrate method chaining
        light.setOnline(true)
                .connectToDevice("Alexa")
                .rename("LivingRoom Light")
                .connectToDevice("Google Home");

        // Update properties with parameter disambiguation
        thermostat.updateLocation("Bedroom");
        thermostat.updatePowerConsumption(7.2);

        // Perform initial setup
        thermostat.performInitialSetup();

        // Display device info
        light.displayDeviceInfo();
        thermostat.displayDeviceInfo();
    }
}
