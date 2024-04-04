import java.util.*;

// Define parent class Employee
class Employee {
  private String name;
  private String id;
  private int age;
  
  // Constructor for Employee class
  Employee(String name, String id, int age) {
    this.name = name;
    this.id = id;
    this.age = age;
  }
  
  // Getter methods for private attributes of Employee class
  String getName() {
    return name;
  }
  
  String getId() {
    return id;
  }
  
  int getAge() {
    return age;
  }
  
  // Setter methods for private attributes of Employee class
  void setName(String name) {
    this.name = name;
  }
  
  void setId(String id) {
    this.id = id;
  }
  
  void setAge(int age) {
    this.age = age;
  }
}

// Define subclass SalariedEmployee
class SalariedEmployee extends Employee {
  private double empSalary;
  
  // Constructor for SalariedEmployee class
  SalariedEmployee(String name, String id, int age, double empSalary) {
    // Call superclass constructor to set name, id, and age
    super(name, id, age);
    // Set the salary using setter method
    setEmpSalary(empSalary);
  }
  
  // Getter method for empSalary attribute
  double getEmpSalary() {
    return empSalary;
  }
  
  // Setter method for empSalary attribute
  void setEmpSalary(double empSalary) {
    this.empSalary = empSalary;
  }
  
  // Method to calculate total salary based on employment type
  double calculateTotalSalary() {
    // If permanent employee, add allowance, else return salary without allowance
    if (empSalary >= 0) {
      return empSalary + 2000;
    } else {
      return empSalary;
    }
  }
}

// Main class Tester
public class Tester {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    SalariedEmployee[] employees = new SalariedEmployee[5];
    
    // Accept details of 5 salaried employees
    for (int i = 0; i < 5; i++) {
      System.out.println("Enter details for Employee " + (i + 1));
      System.out.print("Name: ");
      String name = scanner.nextLine();
      System.out.print("ID: ");
      String id = scanner.nextLine();
      System.out.print("Age: ");
      int age = scanner.nextInt();
      System.out.print("Salary: ");
      double salary = scanner.nextDouble();
      scanner.nextLine(); // Consume newline character
      
      // Create instances of SalariedEmployee and store them in the array
      employees[i] = new SalariedEmployee(name, id, age, salary);
    }
    
    // Find employee with highest salary
    SalariedEmployee highestPaidEmployee = employees[0];
    for (int i = 1; i < 5; i++) {
      if (employees[i].calculateTotalSalary() > highestPaidEmployee.calculateTotalSalary()) {
        highestPaidEmployee = employees[i];
      }
    }
    
    // Print details of the employee with highest salary
    System.out.println("Details of the employee with the highest salary:");
    System.out.println("Name: " + highestPaidEmployee.getName());
    System.out.println("ID: " + highestPaidEmployee.getId());
    System.out.println("Age: " + highestPaidEmployee.getAge());
    System.out.println("Salary: " + highestPaidEmployee.calculateTotalSalary());
  }
}

