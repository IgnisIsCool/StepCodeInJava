public class AudioMixer_Q3 {
    private String mixerModel;
    private int numberOfChannels;
    private boolean hasBluetoothConnectivity;
    private double maxVolumeDecibels;
    private String[] connectedDevices;
    private int deviceCount;

    // No-argument constructor using this() chaining
    public AudioMixer_Q3() {
        this("StandardMix-8", 8, false);
    }

    // Two-parameter constructor using this() chaining
    public AudioMixer_Q3(String mixerModel, int numberOfChannels) {
        this(mixerModel, numberOfChannels, false);
    }

    // Three-parameter constructor using this() chaining
    public AudioMixer_Q3(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity) {
        this(mixerModel, numberOfChannels, hasBluetoothConnectivity, 120.0);
    }

    // Main constructor - all parameters
    public AudioMixer_Q3(String mixerModel, int numberOfChannels,
                      boolean hasBluetoothConnectivity, double maxVolumeDecibels) {
        this.mixerModel = mixerModel;
        this.numberOfChannels = numberOfChannels;
        this.hasBluetoothConnectivity = hasBluetoothConnectivity;
        this.maxVolumeDecibels = maxVolumeDecibels;

        // Initialize device array based on channels
        this.connectedDevices = new String[numberOfChannels];
        this.deviceCount = 0;

        System.out.println("Constructor executed for model: " + mixerModel);
    }

    // Connect a device
    public void connectDevice(String deviceName) {
        if (deviceCount < connectedDevices.length) {
            connectedDevices[deviceCount] = deviceName;
            deviceCount++;
            System.out.println("Connected: " + deviceName);
        } else {
            System.out.println("All channels occupied!");
        }
    }

    // Display mixer details
    public void displayMixerStatus() {
        System.out.println("\n=== " + mixerModel + " STATUS ===");
        System.out.println("Channels: " + numberOfChannels);
        System.out.println("Bluetooth: " + (hasBluetoothConnectivity ? "Enabled" : "Disabled"));
        System.out.println("Max Volume: " + maxVolumeDecibels + " dB");
        System.out.println("Connected Devices: " + deviceCount + "/" + numberOfChannels);
        for (int i = 0; i < deviceCount; i++) {
            System.out.println(" Channel " + (i + 1) + ": " + connectedDevices[i]);
        }
    }

    // Main testing
    public static void main(String[] args) {
        System.out.println("=== MUSIC STUDIO SETUP ===");

        // Create mixers with different constructors
        AudioMixer_Q3 defaultMixer = new AudioMixer_Q3();
        AudioMixer_Q3 twoParamMixer = new AudioMixer_Q3("CompactMix-4", 4);
        AudioMixer_Q3 threeParamMixer = new AudioMixer_Q3("LiveMix-12", 12, true);
        AudioMixer_Q3 fullMixer = new AudioMixer_Q3("ProMix-24", 24, true, 140.0);

        // Connect devices
        defaultMixer.connectDevice("Keyboard");
        defaultMixer.connectDevice("Microphone");

        twoParamMixer.connectDevice("Guitar");

        threeParamMixer.connectDevice("Drums");
        threeParamMixer.connectDevice("Bass");
        threeParamMixer.connectDevice("Laptop");

        fullMixer.connectDevice("DJ Controller");
        fullMixer.connectDevice("Vocal Mic");
        fullMixer.connectDevice("Synthesizer");

        // Show status
        defaultMixer.displayMixerStatus();
        twoParamMixer.displayMixerStatus();
        threeParamMixer.displayMixerStatus();
        fullMixer.displayMixerStatus();

        // Comment on constructor chaining
        System.out.println("\n--- Constructor Chaining Note ---");
        System.out.println("No-arg -> calls 3-param -> calls 4-param (main)");
        System.out.println("2-param -> calls 3-param -> calls 4-param");
        System.out.println("3-param -> calls 4-param");
        System.out.println("4-param -> executes directly");
    }
}

