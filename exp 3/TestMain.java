import java.util.*;

// Define a class named Test
class Test {
    // Declare instance variables
    double base;        // base for power calculation
    int power;          // power for exponentiation
    int logBase;        // base for logarithmic calculation
    int argument;       // argument for logarithmic calculation

    // Constructor for initializing default values
    Test(){
        base = 2;       // Default base value
        power = 2;      // Default power value
        logBase = 2;    // Default logarithmic base value
        argument = 2;   // Default argument value
    }

    // Method to calculate power of a number
    public double calculate(double base, int power){
        this.base = base;
        this.power = power;

        double value = Math.pow(base, power);   // Calculate base^power
        System.out.println(value);              // Print the result
        return value;                           // Return the result
    }

    // Method to calculate logarithm of a number
    public double calculate(int logBase, int argument) {
        this.logBase = logBase;
        this.argument = argument;

        double value = Math.log(argument) / Math.log(logBase);  // Calculate log_base(argument)
        System.out.println(value);                              // Print the result
        return value;                                           // Return the result
    }

    // Method to display a message
    void display() {
        System.out.println("Result after the Mathematical operation is: " );
    }
}

// Main class to execute the program
public class TestMain {
    public static void main(String[] args) {
        // Create two Test objects
        Test obj1 = new Test();
        Test obj2 = new Test();

        // Display message and calculate power for obj1
        obj1.display();
        obj1.calculate(2.0, 4);

        // Display message and calculate logarithm for obj2
        obj2.display();
        obj2.calculate(2, 4);
    }
}


