import java.util.*;

// Abstract class representing a geometric shape
abstract class Shape {
    String color;

    // Constructor to initialize the color of the shape
    public Shape(String color) {
        this.color = color;
    }

    // Getter method to retrieve the color of the shape
    public String getColor() {
        return color;
    }

    // Setter method to set the color of the shape
    public void setColor(String color) {
        this.color = color;
    }
    
    // Abstract method to calculate the area of the shape
    public abstract double area();
}

// Class representing a rectangle, a subclass of Shape
class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor to initialize the color, length, and width of the rectangle
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    // Getter method to retrieve the length of the rectangle
    public double getLength() {
        return length;
    }

    // Setter method to set the length of the rectangle
    public void setLength(double length) {
        this.length = length;
    }

    // Getter method to retrieve the width of the rectangle
    public double getWidth() {
        return width;
    }

    // Setter method to set the width of the rectangle
    public void setWidth(double width) {
        this.width = width;
    }

    // Method to calculate the area of the rectangle
    public double area() {
        return length * width;
    }
}

// Class representing a circle, a subclass of Shape
class Circle extends Shape {
    private double radius;

    // Constructor to initialize the color and radius of the circle
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    // Getter method to retrieve the radius of the circle
    public double getRadius() {
        return radius;
    }

    // Setter method to set the radius of the circle
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Method to calculate the area of the circle
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Class representing a diagram containing multiple shapes
class Diagram {
    private Shape[] shapes;

    // Constructor to initialize the diagram with a specified number of shapes
    public Diagram(int num) {
        shapes = new Shape[num]; // Create an array to store the shapes
        Scanner sc = new Scanner(System.in);
        for (int i = 0 ; i < shapes.length; i++) { // Iterate through each shape
            System.out.println("Enter 1 for Rectangle , Enter 2 for Circle , Enter 0 to exit program");
            int choice = sc.nextInt(); // Prompt user for choice
            if (choice == 1) { // If choice is to create a rectangle
                System.out.print("Enter color, length, and width for Rectangle " + (i+1) + ": ");
                String color = sc.next(); // Read color input
                double length = sc.nextDouble(); // Read length input
                double width = sc.nextDouble(); // Read width input
                shapes[i] = new Rectangle(color, length, width); // Create a new Rectangle object and add to the array
            }
            else if (choice == 2) { // If choice is to create a circle
                System.out.print("Enter color and radius for Circle " + (i+1) + ": ");
                String color = sc.next(); // Read color input
                double radius = sc.nextDouble(); // Read radius input
                shapes[i] = new Circle(color, radius); // Create a new Circle object and add to the array
            }
            else if (choice == 0) { // If choice is to exit the program
              System.exit(0);
            }
            else { // If an invalid choice is made
                System.out.println("Invalid choice. Please enter 1 for Rectangle or 2 for Circle.");
                i--; // Decrement i to repeat the loop for the current shape.
            }
        }
    }
    
    // Method to calculate the total area of all shapes in the diagram
    public double totalArea() {
        double totalArea = 0;
        for (Shape shape : shapes) { // Iterate through each shape in the array
            totalArea += shape.area(); // Calculate the area of the shape and add to totalArea
        }
        return totalArea; // Return the total area
    }
}

// Main class to test the functionality of the Shape hierarchy and Diagram
public class TestShapes {
    public static void main(String[] args) {
        Diagram d1 = new Diagram(3); // Create a diagram with 3 shapes
        System.out.println(d1.totalArea()); // Print the total area of all shapes in the diagram
    }
}

