import java.util.*;

// Parent class Car
class Car {
    // Private member variables to store car number and producer
    private String carNo;
    private String producer;

    // Constructor to initialize Car object with car number and producer
    public Car(String carNo, String producer) {
        this.carNo = carNo;
        this.producer = producer;
    }

    // Getter method for retrieving car number
    public String getCarNo() {
        return carNo;
    }

    // Setter method for setting car number
    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    // Getter method for retrieving producer
    public String getProducer() {
        return producer;
    }

    // Setter method for setting producer
    public void setProducer(String producer) {
        this.producer = producer;
    }

    // Method to display car details
    public void display() {
        System.out.println("Car Number: " + carNo);
        System.out.println("Producer: " + producer);
    }
}

// Child class PassCar inheriting from Car
class PassCar extends Car {
    // Additional member variables for passenger car: passCarType and sunRoof
    private String passCarType;
    private boolean sunRoof;

    // Constructor to initialize PassCar object with car number, producer, passCarType, and sunRoof
    public PassCar(String carNo, String producer, String passCarType, boolean sunRoof) {
        // Call the superclass constructor to initialize car number and producer
        super(carNo, producer);
        // Initialize PassCar specific variables
        this.passCarType = passCarType;
        this.sunRoof = sunRoof;
    }

    // Getter method for retrieving passenger car type
    public String getPassCarType() {
        return passCarType;
    }

    // Setter method for setting passenger car type
    public void setPassCarType(String passCarType) {
        this.passCarType = passCarType;
    }

    // Method to check if the passenger car has sunroof
    public boolean hasSunRoof() {
        return sunRoof;
    }

    // Setter method for setting sunroof status
    public void setSunRoof(boolean sunRoof) {
        this.sunRoof = sunRoof;
    }

    // Override display method to show passenger car details
    @Override
    public void display() {
        super.display(); // Call display method of superclass (Car)
        System.out.println("Pass Car Type: " + passCarType);
        System.out.print("Sun Roof: ");
        if (sunRoof) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

// Child class Truck inheriting from Car
class Truck extends Car {
    // Additional member variables for truck: numberAxles and loadCapacity
    private int numberAxles;
    private double loadCapacity;

    // Constructor to initialize Truck object with car number, producer, numberAxles, and loadCapacity
    public Truck(String carNo, String producer, int numberAxles, double loadCapacity) {
        // Call the superclass constructor to initialize car number and producer
        super(carNo, producer);
        // Initialize Truck specific variables
        this.numberAxles = numberAxles;
        this.loadCapacity = loadCapacity;
    }

    // Getter method for retrieving number of axles
    public int getNumberAxles() {
        return numberAxles;
    }

    // Setter method for setting number of axles
    public void setNumberAxles(int numberAxles) {
        this.numberAxles = numberAxles;
    }

    // Getter method for retrieving load capacity
    public double getLoadCapacity() {
        return loadCapacity;
    }

    // Setter method for setting load capacity
    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    // Override display method to show truck details
    @Override
    public void display() {
        super.display(); // Call display method of superclass (Car)
        System.out.println("Number of Axles: " + numberAxles);
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Main class
public class CarMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many cars do you want to rent?");
        int numOfCars = scanner.nextInt(); // Read the number of cars from user
        scanner.nextLine(); // Consume newline character

        // Create an array to store Car objects
        Car[] cars = new Car[numOfCars];

        // Loop to input details of each car
        for (int i = 0; i < numOfCars; i++) {
            System.out.println("Enter car type (1 for Pass Car, 2 for Truck):");
            int carType = scanner.nextInt(); // Read car type from user
            scanner.nextLine(); // Consume newline character

            System.out.println("Enter car number:");
            String carNo = scanner.nextLine(); // Read car number from user

            System.out.println("Enter producer:");
            String producer = scanner.nextLine(); // Read producer from user

            if (carType == 1) { // If car type is Passenger Car
                System.out.println("Enter pass car type:");
                String passCarType = scanner.nextLine(); // Read passenger car type from user

                System.out.println("Does it have a sunroof? (true/false):");
                boolean sunRoof = scanner.nextBoolean(); // Read sunroof status from user

                // Create PassCar object and store it in the array
                cars[i] = new PassCar(carNo, producer, passCarType, sunRoof);
            } else if (carType == 2) { // If car type is Truck
                System.out.println("Enter number of axles:");
                int numberAxles = scanner.nextInt(); // Read number of axles from user

                System.out.println("Enter load capacity (in tons):");
                double loadCapacity = scanner.nextDouble(); // Read load capacity from user

                // Create Truck object and store it in the array
                cars[i] = new Truck(carNo, producer, numberAxles, loadCapacity);
            }
        }

        // Displaying details of all rented cars
        System.out.println("\nCars rented:");
        for (Car car : cars) {
            car.display(); // Call display method of Car (dynamic binding)
            System.out.println();
        }

        scanner.close(); // Close the scanner object
    }
}

