// File: MultilevelInheritanceDemo.java

public class W6_Animal {
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;

    public W6_Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }

    public void eat() { System.out.println("Animal is eating"); }
    public void sleep() { System.out.println("Animal is sleeping"); }
    public void move() { System.out.println("Animal is moving"); }

    public String getAnimalInfo() {
        return "Species: " + species + ", Habitat: " + habitat +
                ", Lifespan: " + lifespan + " yrs, Wildlife: " + isWildlife;
    }
}

// 🔹 Mammal Class
class Mammal extends W6_Animal {
    protected String furColor;
    protected boolean hasWarmBlood;
    protected int gestationPeriod;

    public Mammal(String species, String habitat, int lifespan, boolean isWildlife,
                  String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        this.furColor = furColor;
        this.hasWarmBlood = true; // always true for mammals
        this.gestationPeriod = gestationPeriod;
        System.out.println("Mammal constructor: Adding mammal traits");
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Mammal is walking/running");
    }

    public void nurse() { System.out.println("Mammal is nursing offspring"); }
    public void regulateTemperature() { System.out.println("Maintaining body temperature"); }
}

// 🔹 Dog Class
class Dog extends Mammal {
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel;
    private String favoriteActivity;

    // Constructor 1: Basic dog
    public Dog() {
        super("Canine", "Domestic", 12, false, "Brown", 60);
        this.breed = "Mixed";
        this.isDomesticated = true;
        this.loyaltyLevel = 8;
        this.favoriteActivity = "Playing fetch";
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }

    // Constructor 2: Detailed dog
    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod,
               String breed, boolean isDomesticated, int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }

    // Constructor 3: Copy constructor
    public Dog(Dog other) {
        this(other.species, other.habitat, other.lifespan, other.isWildlife,
                other.furColor, other.gestationPeriod,
                other.breed, other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
    }

    // 🔹 Overriding methods
    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog is wagging tail while eating");
    }

    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }

    // 🔹 Dog-specific methods
    public void bark() { System.out.println("Woof! Woof!"); }
    public void fetch() { System.out.println("Dog is fetching the ball"); }
    public void showLoyalty() { System.out.println("Loyalty level: " + loyaltyLevel + "/10"); }

    // 🔹 Demonstration method
    public void demonstrateInheritance() {
        eat();   // Overridden
        move();  // Overridden
        sleep(); // Overridden
        nurse(); // Mammal method
        regulateTemperature(); // Mammal method
        System.out.println(getAnimalInfo()); // Animal method
    }

    public static void main(String[] args) {
        System.out.println("----- TEST 1: Basic Dog -----");
        Dog d1 = new Dog();
        d1.demonstrateInheritance();
        d1.bark();
        d1.fetch();
        d1.showLoyalty();

        System.out.println("\n----- TEST 2: Detailed Dog -----");
        Dog d2 = new Dog("Canine", "Urban", 15, false, "Black", 65,
                "German Shepherd", true, 10, "Guarding");
        d2.demonstrateInheritance();

        System.out.println("\n----- TEST 3: Copy Constructor -----");
        Dog d3 = new Dog(d2);
        d3.demonstrateInheritance();

        // 🔹 instanceof checks
        System.out.println("\nInstanceof checks:");
        System.out.println(d3 instanceof Dog);    // true
        System.out.println(d3 instanceof Mammal); // true
        System.out.println(d3 instanceof W6_Animal); // true
    }
}
