import java.util.*;

// Parent class representing an Employee
class Employee {
  double basicSalary = 25;  // Default basic salary
  
  // Method to calculate salary (basic salary only)
  double Salary() {
    return basicSalary;
  } 
  
  // Method to display salary
  void Display() {
    System.out.println("Salary is:-");
    System.out.println(basicSalary);
  }
}

// Subclass representing Teaching staff
class Teaching extends Employee{
  // Method to calculate salary (inherited from superclass)
  double Salary() {
    return super.Salary();
  } 
  
  // Method to display salary (inherited from superclass)
  void Display() {
    super.Display();
  }
}

// Subclass representing Permanent Teaching staff
class PermanentTeaching extends Teaching {
  double totalSalary; // Total salary including DA and HRA
  
  // Method to calculate salary (including DA and HRA)
  double Salary() {
    double DA = (28.0/100) * basicSalary;
    double HRA = (8.0/100) * basicSalary;
    totalSalary = basicSalary + DA + HRA;
    return totalSalary;
  }
  
  // Method to display salary
  void Display() {
    System.out.println("Salary is:-");
    System.out.println(totalSalary);
  }
}

// Subclass representing Ad-hoc Teaching staff
class AD_hocTeaching extends Teaching {
  // Method to calculate salary (inherited from superclass)
  double Salary() {
    return super.Salary();
  }
  
  // Method to display salary (inherited from superclass)
  void Display() {
    super.Display();
  }
}

// Subclass representing Non-Teaching staff
class NonTeaching extends Employee {
  // Method to calculate salary (inherited from superclass)
  double Salary() {
    return super.Salary();
  }   
  
  // Method to display salary (inherited from superclass)
  void Display() {
    super.Display();
  }
}

// Subclass representing Technical staff
class Technical extends NonTeaching {
  double totalSalary; // Total salary including DA and HRA
  
  // Method to calculate salary (including DA and HRA)
  double Salary() {
    double DA = (28.0/100) * basicSalary;
    double HRA = (8.0/100) * basicSalary;
    totalSalary = basicSalary + DA + HRA;
    return totalSalary;
  }
  
  // Method to display salary
  void Display() {
    System.out.println("Salary is:-");
    System.out.println(totalSalary);
  }  
}

// Subclass representing Non-Technical staff
class NonTechnical extends NonTeaching {
  // Method to calculate salary (inherited from superclass)
  double Salary() {
    return super.Salary();
  }
  
  // Method to display salary (inherited from superclass)
  void Display() {
    super.Display();
  }
}

// Subclass representing Permanent Non-Technical staff
class PermanetNonTechnical extends NonTechnical {
  double totalSalary; // Total salary including DA and HRA
  
  // Method to calculate salary (including DA and HRA)
  double Salary() {
    double DA = (28.0/100) * basicSalary;
    double HRA = (8.0/100) * basicSalary;
    totalSalary = basicSalary + DA + HRA;
    return totalSalary;
  }
  
  // Method to display salary
  void Display() {
    System.out.println("Salary is:-");
    System.out.println(totalSalary);
  }
}

// Subclass representing Ad-hoc Non-Technical staff
class AD_hocNonTechnical extends NonTechnical {
  // Method to calculate salary (inherited from superclass)
  double Salary() {
    return super.Salary();
  } 
  
  // Method to display salary (inherited from superclass)
  void Display() {
    super.Display();
  } 
}

// Main class
public class SalaryMain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Prompting user to enter the Name of the Organization
    System.out.println("Enter the Name of the Organization:");
    String name = sc.nextLine();
    
    // Creating instances of different employee classes
    PermanentTeaching sal1 = new PermanentTeaching();
    AD_hocTeaching sal2 = new AD_hocTeaching();
    Technical sal3 = new Technical();
    PermanetNonTechnical sal4 = new PermanetNonTechnical();
    AD_hocNonTechnical sal5 = new AD_hocNonTechnical();

    // Calculating and displaying salaries for each employee category
    sal1.Salary();  
    System.out.println("Salaries for respective posts are:");
    System.out.println("Permanent Teaching staff:");
    sal1.Display();

    System.out.println("AD_hoc Teaching staff:");
    sal2.Display();

    sal3.Salary();  
    System.out.println("Technical staff:");
    sal3.Display();

    sal4.Salary();  
    System.out.println("Permanent NonTechnical staff:");
    sal4.Display();

    System.out.println("AD_hoc NonTechnical staff:");
    sal5.Display();

    sc.close(); // Closing scanner
  }
}
