import java.util.*;

//creating interface volume
interface Volume {
  //declaring abstract method getVolume()
  double getVolume();
}

//creating interface SurfaceArea
interface SurfaceArea {
  //declaring abstract method getSurfaceArea()
  double getSurfaceArea();
}

class Cylinder implements Volume, SurfaceArea {
    private double radius;
    private double height;
    
    //Declaring constructor 
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    
    //inheriting the method getVolume()
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

    //inheriting the method getVolume()
    public double getSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
}

//creating class Tester containing the Main method
public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the Radius of the Cylinder");
        double radius = sc.nextDouble();
        
        System.out.println("Enter the Height of the Cylinder");
        double height = sc.nextDouble();
        
        //Creating the object for Cylinder Class
        Cylinder cy = new Cylinder(radius, height);
        
        System.out.println("The Volume of the Cylinder is: " + cy.getVolume());
        System.out.println("The Surface Area of the Cyinder is: " + cy.getSurfaceArea());
    }
}


/*Consider two interfaces, Volume and SurfaceArea with methods getVolume() and getSurfaceArea() respectively. 
Class ‘Cylinder’ implements both Volume and SurfaceArea and implements their methods. The class contains their required dimensions as data members. 
Write a program which inputs its dimensions and prints its volume and surface area.*/
