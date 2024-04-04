import java.util.*;

// Parent class representing a Bank
class Bank {
    // Method to get the default rate of interest for all banks
    double get_rate_of_interest () {
      return 2.0;
    }
}

// Subclass representing SBI Bank
class SBI_Bank extends Bank {
    // Method to get the rate of interest for SBI Bank
    double get_rate_of_interest () {
      return super.get_rate_of_interest (); // Using superclass method to get default interest rate
    }
}

// Subclass representing ICICI Bank
class ICICI_Bank extends Bank {
    // Method to get the rate of interest for ICICI Bank
    double get_rate_of_interest () {
      return super.get_rate_of_interest (); // Using superclass method to get default interest rate
    }
}

// Subclass representing AXIS Bank
class AXIS_Bank extends Bank {
    // Method to get the rate of interest for AXIS Bank
    double get_rate_of_interest () {
      return super.get_rate_of_interest (); // Using superclass method to get default interest rate
    }
}

public class TestMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompting user to enter the number of days for loan repayment
        System.out.println("Enter the number of days for loan repayment: ");
        int days = sc.nextInt();
        
        // Initial amounts for different banks
        double amount_SBI = 10000;
        double amount_ICICI = 12500;
        double amount_AXIS = 20000;
        
        // Creating instances of different bank classes
        SBI_Bank sbi_bank = new SBI_Bank();
        ICICI_Bank icici_bank = new ICICI_Bank();
        AXIS_Bank axis_bank = new AXIS_Bank();

        // Calculating maturity amount for each bank using respective interest rates
        double maturity_amount_SBI = calculateMaturity(amount_SBI, getInterestRateSBI(days), days);
        double maturity_amount_ICICI = calculateMaturity(amount_ICICI, getInterestRateICICI(days), days);
        double maturity_amount_AXIS = calculateMaturity(amount_AXIS, getInterestRateAXIS(days), days);

        // Printing maturity amounts for each bank
        System.out.println("Maturity amount in SBI bank: " + maturity_amount_SBI);
        System.out.println("Maturity amount in ICICI bank: " + maturity_amount_ICICI);
        System.out.println("Maturity amount in AXIS bank: " + maturity_amount_AXIS);

        sc.close(); // Closing scanner
        
        // Printing current date and date after 15 days
        Calendar cal;
        cal = Calendar.getInstance();
        System.out.print(cal.get(Calendar.DATE)+ "-");
        System.out.print(cal.get(Calendar.MONTH)+ 1 +"-");
        System.out.print(cal.get(Calendar.YEAR));
        cal.add(Calendar.DAY_OF_YEAR, 15);
        System.out.println();
        System.out.print(cal.get(Calendar.DATE)+ "-");
        System.out.print(cal.get(Calendar.MONTH)+ 1 +"-");
        System.out.print(cal.get(Calendar.YEAR));
    }
    
    // Method to calculate maturity amount based on principal, interest rate, and days
    static double calculateMaturity(double principal, double rate, int days) {
        double interest = rate;
        return principal * (1 + (interest / 100) * (days / 365.0));
    }
    
    // Method to get interest rate for SBI Bank based on number of days
    static double getInterestRateSBI(int days) {
        if (days >= 7 && days <= 14) {
            return 3.0;
        } else if (days >= 15 && days <= 30) {
            return 3.0;
        } else if (days >= 31 && days <= 45) {
            return 3.0;
        } else if (days >= 46 && days <= 90) {
            return 4.05;
        } else if (days >= 91 && days <= 120) {
            return 4.10;
        } else if (days >= 121 && days <= 180) {
            return 4.10;
        } else {
            return 2.0; // Default rate if days don't fall in any category
        }
    }

    // Method to get interest rate for ICICI Bank based on number of days
    static double getInterestRateICICI(int days) {
        if (days >= 7 && days <= 14) {
            return 3.10;
        } else if (days >= 15 && days <= 30) {
            return 3.20;
        } else if (days >= 31 && days <= 45) {
            return 3.50;
        } else if (days >= 46 && days <= 90) {
            return 4.50;
        } else if (days >= 91 && days <= 120) {
            return 4.70;
        } else if (days >= 121 && days <= 180) {
            return 4.90;
        } else {
            return 2.0; // Default rate if days don't fall in any category
        }
    }

    // Method to get interest rate for AXIS Bank based on number of days
    static double getInterestRateAXIS(int days) {
        if (days >= 7 && days <= 14) {
            return 3.15;
        } else if (days >= 15 && days <= 30) {
            return 3.15;
        } else if (days >= 31 && days <= 45) {
            return 3.45;
        } else if (days >= 46 && days <= 90) {
            return 4.05;
        } else if (days >= 91 && days <= 120) {
            return 4.70;
        } else if (days >= 121 && days <= 180) {
            return 5.00;
        } else {
            return 2.0; // Default rate if days don't fall in any category
        }
    }
}

