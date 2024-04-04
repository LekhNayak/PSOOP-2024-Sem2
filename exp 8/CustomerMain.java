import java.util.*;

interface SavingAccount {
    double getSimpleInterest();
}

interface CurrentAccount {
    double getCompoundInterest();
}

class Customer implements SavingAccount, CurrentAccount {
    private String AccType;
    private double InterestRate;
    private double balance;
    private double time;
    private int n;
    
    public Customer(String AccType, double InterestRate, double balance, double time) {
        this.AccType = AccType;
        this.InterestRate =  InterestRate;
        this.balance = balance;
        this.time = time;
    }
    
    public Customer(String AccType, double InterestRate, double balance, double time, int n) {
        this.AccType = AccType;
        this.InterestRate =  InterestRate;
        this.balance = balance;
        this.time = time;
        this.n = n;
    }
    
    public double getSimpleInterest() {
        double amount = (balance * InterestRate * time)/100 ;
        return amount ;
    }
    
    public double getCompoundInterest() {
        double amount = balance * Math.pow(1 + (InterestRate / n), n * time);
        return amount ;
    }
}

public class CustomerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter account type (Saving/Current): ");
        String accType = scanner.next();
        
        System.out.println("Enter interest rate (in percentage): ");
        double interestRate = scanner.nextDouble();
        
        System.out.println("Enter balance: ");
        double balance = scanner.nextDouble();
        
        System.out.println("Enter time (in years): ");
        double time = scanner.nextDouble();
        
        Customer customer1 = new Customer(accType, interestRate, balance, time);
        
        if(accType.equalsIgnoreCase("saving")) {
            System.out.println("Simple Interest: " + customer1.getSimpleInterest());
        }
        else if (accType.equalsIgnoreCase("current")) {
            System.out.println("Enter the number of times interest is compounded per year: ");
            int n = scanner.nextInt();
            Customer customer2 = new Customer(accType, interestRate, balance, time, n);
            System.out.println("Compound Interest: " + customer2.getCompoundInterest());
        }
        scanner.close();
    }
}



