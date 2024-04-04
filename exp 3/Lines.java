import java.util.*;

public class Lines {
    // Instance variables to store line parameters
    double slope, y_int, x1, x2, y1, y2;

    // Default constructor initializes values for a default line
    Lines() {
        x1 = 0;
        y1 = 0;
        x2 = 1;
        y2 = 1;
        slope = 1;
        y_int = 0;
    }

    // Method to calculate slope between two points
    double getSlope() {
        return (y2 - y1) / (x2 - x1);
    }

    // Constructor for initializing line with slope-intercept form
    Lines(double m, double y_int) {
        this.slope = m;
        this.y_int = y_int;
        y_int = y1 - slope * x1; // This line doesn't seem necessary and will not update y_int

        // Printing equation in slope-intercept form
        System.out.printf("The Equation of line in slope-intercept form is: y = %.2fx + %.2f\n", slope, y_int);
    }

    // Constructor for initializing line with two-point form
    Lines(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        // Printing equation in two-point form
        System.out.printf("The Equation of line in two point form is : (y - %.2f)/%.2f = %.2f (x - %.2f)/(%.2f)\n", y1, y1 - y2, getSlope(), x1, x1 - x2);
    }

    // Constructor for initializing line with one point and slope
    Lines(double x1, double y1, double m) {
        this.x1 = x1;
        this.y1 = y1;
        this.slope = m;
        // Printing equation in one-point form
        System.out.printf("The Equation of line in one point form is : (y - %.2f) = %.2f (x - %.2f)\n", y1, getSlope(), x1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x1, x2, y1, y2, m, y_int;

        loop: while (true) {

            // Display the menu
            System.out.print("Menu:\n" + "1. Print two point form\n" + "2. Print one point form\n" + "3. Print slope intercept form\n" + "4. Exit\n" + "Enter your choice: ");

            // Read the user's choice
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Read two points for the line
                    System.out.println("Enter the x1,y1,x2,y2 values for line");
                    x1 = sc.nextDouble();
                    y1 = sc.nextDouble();
                    x2 = sc.nextDouble();
                    y2 = sc.nextDouble();
                    // Create Line object with two-point form
                    Lines l1 = new Lines(x1, y1, x2, y2);
                    break;
                case 2:
                    // Read one point and slope for the line
                    System.out.println("Enter the values of x1,y1 and slope for the line");
                    x1 = sc.nextDouble();
                    y1 = sc.nextDouble();
                    m = sc.nextDouble();
                    // Create Line object with one-point form
                    Lines l2 = new Lines(x1, y1, m);
                    break;
                case 3:
                    // Read slope and y-intercept for the line
                    System.out.println("Enter values of slope and y-intercept for line");
                    m = sc.nextDouble();
                    y_int = sc.nextDouble();
                    // Create Line object with slope-intercept form
                    Lines l3 = new Lines(m, y_int);
                    break;
                case 4:
                    // Exit the loop and end the program
                    System.out.println("Exiting...");
                    break loop;
                default:
                    // Handle invalid choice
                    System.out.println("Invalid choice.");
            }
        }
        sc.close(); // Close scanner to prevent resource leak
    }
}
