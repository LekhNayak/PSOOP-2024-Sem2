import java.util.*;

// Define a Shape class
class Shape {
  private String color; // Private attribute to store color

  // Constructors
  Shape() {
    color = "Red"; // Default color is set to Red
  }

  Shape(String color) {
    this.color = color; // Initialize color with the provided value
  }

  // Getter method for color
  String getColor() {
    return color; // Return the color of the shape
  }
  
  void display () {
    System.out.println(color);
  }
}

// Define a Rectangle class that extends Shape
class Rectangle extends Shape {
  private float length, breadth; // Private attributes to store dimensions

  // Constructors
  Rectangle() {
    length = breadth = 1; // Default dimensions set to 1x1
  }

  Rectangle(float length, float breadth) {
    this.length = length; // Initialize length
    this.breadth = breadth; // Initialize breadth
  }

  Rectangle(float length, float breadth, String color) {
    super(color); // Call superclass constructor to set color
    this.length = length; // Initialize length
    this.breadth = breadth; // Initialize breadth
  }

  // Method to calculate area of the rectangle
  float area() {
    return length * breadth; // Calculate and return area
  }

  // Method to display details of the rectangle
  void display() {
    // Print color, length, and breadth of the rectangle
    super.display();
    System.out.println("Length of the rectangle is: " + length);
    System.out.println("Breadth of the Rectangle is: " + breadth);
  }
}

// Main class to test Rectangle functionality
public class TestRectangle {
  public static void main(String[] args) {
    // Create rectangle objects and display their details
    Rectangle r1 = new Rectangle();
    r1.display(); // Display details of the rectangle
    System.out.println("Area of the rectangle is: " + r1.area()); // Calculate and print area

    Rectangle r2 = new Rectangle(4, 3);
    r2.display(); // Display details of the rectangle
    System.out.println("Area of the rectangle is: " + r2.area()); // Calculate and print area

    Rectangle r3 = new Rectangle(4, 3, "blue");
    r3.display(); // Display details of the rectangle
    System.out.println("Area of the rectangle is: " + r3.area()); // Calculate and print area
    
    Shape s = r1;
    s.display();
  }
}

