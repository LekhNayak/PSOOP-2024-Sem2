import java.util.*;

class Product {
  private double barcode;
  private String name;
  
  //parameterised constructor of class product
  Product(double barcode, String name) {
    this.barcode = barcode;
    this.name = name;
  }
  
  // getter methods for private attributes of Product class
  double getBarcode() {
    return barcode;
  }
  String getName() {
    return name;
  }
}

class PrepackedFood extends Product {
  private double unitPrice;
  
  // Parameterized constructor of PrepackedFood
  PrepackedFood(double barcode, String name, double unitPrice) {
    // Call superclass constructor to set barcode and name
    super(barcode, name);
    this.unitPrice = unitPrice;
  }
   // getter methods for private attributes of  class PrepackedFood
  double getUnitPrice() {
      return unitPrice;
  }
}

class FreshFood extends Product {
  private double weight;
  private double PricePerKilo;

  // Parameterized constructor of FreshFood
  FreshFood(double barcode, String name, double weight, double PricePerKilo) {
    // Call superclass constructor to set barcode and name
    super(barcode, name);
    this.weight = weight;
    this.PricePerKilo = PricePerKilo;
  }
  
  // getter methods for private attributes of  class FreshFood
  double getWeight() {
    return weight;
  }
  double getPricePerKilo() {
    return PricePerKilo;
  }
}

public class TestProduct {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
      
      //taking user input for data in PrepackedFood class
      System.out.println("Enter details for PrepackedFood class: ");
      System.out.print("Barcode: ");
      double barcode1 = sc.nextDouble();
      sc.nextLine(); // Consume newline
      System.out.print("Name: ");
      String name1 = sc.nextLine();
      System.out.print("Unit Price: ");
      double unitPrice = sc.nextDouble();
      
      PrepackedFood prepackedFood = new PrepackedFood(barcode1, name1, unitPrice);
      
      //taking user input for data in FreshFood class
      System.out.println("Enter details for FreshFood class: ");
      System.out.print("Barcode: ");
      double barcode2 = sc.nextDouble();
      sc.nextLine(); // Consume newline
      System.out.print("Name: ");
      String name2 = sc.nextLine();
      System.out.print("Weight: ");
      double weight = sc.nextDouble();
      System.out.print("Price per kilo: ");
      double pricePerKilo = sc.nextDouble();

      FreshFood freshFood = new FreshFood(barcode2, name2, weight, pricePerKilo);
      
      // Printing details of PrepackedFood
      System.out.println("\nDetails of PrepackedFood:");
      System.out.println("Barcode: " + prepackedFood.getBarcode());
      System.out.println("Name: " + prepackedFood.getName());
      System.out.println("Unit Price: " + prepackedFood.getUnitPrice());
      
      // Printing details of FreshFood
      System.out.println("\nDetails of FreshFood:");
      System.out.println("Barcode: " + freshFood.getBarcode());
      System.out.println("Name: " + freshFood.getName());
      System.out.println("Weight: " + freshFood.getWeight() + " kg");
      System.out.println("Price per kilo: " + freshFood.getPricePerKilo());
      
      sc.close();
  }
}
