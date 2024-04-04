import java.util.*;

abstract class Account {
    String Name;
    double Balance;
    double AccNo;

    abstract void Deposit(double amount) throws NegativeAmountException;
    abstract void Withdraw(double amount) throws NegativeAmountException, InsufficientAmountException;
    abstract void Display();
}

class SavingAccount extends Account {
    double interestRate;
    double minBalance;

    SavingAccount(String Name, double AccNo, double interestRate, double minBalance) {
        this.Name = Name;
        this.AccNo = AccNo;
        this.interestRate = interestRate;
        this.minBalance = minBalance;
        this.Balance = 0;
    }

    
    void Deposit(double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException();
        }
        Balance += amount;
        System.out.println("Deposit successful. Current balance: " + Balance);
    }

    
    void Withdraw(double amount) throws NegativeAmountException, InsufficientAmountException {
        if (amount < 0) {
            throw new NegativeAmountException();
        }
        if (Balance - amount < minBalance) {
            throw new InsufficientAmountException();
        }
        Balance -= amount;
        System.out.println("Withdrawal successful. Current balance: " + Balance);
    }

    
    void Display() {
        System.out.println("Account Name: " + Name);
        System.out.println("Account Number: " + AccNo);
        System.out.println("Balance: " + Balance);
        System.out.println("Interest Rate: " + interestRate);
        System.out.println("Minimum Balance: " + minBalance);
    }

    void addInterest() {
        double interest = Balance * interestRate / 100;
        Balance += interest;
        System.out.println("Interest added. Current balance: " + Balance);
    }

    void transfer(double amount, SavingAccount targetAccount) throws NegativeAmountException, InsufficientAmountException {
        Withdraw(amount);
        targetAccount.Deposit(amount);
        System.out.println("Transfer successful.");
    }
}

class NegativeAmountException extends Exception {
    NegativeAmountException() {
        System.out.println("Amount cannot be negative.");
    }
}

class InsufficientAmountException extends Exception {
    InsufficientAmountException() {
        System.out.println("Insufficient balance.");
    }
}

public class AccountHandling {
    public static void main(String[] args) {
        SavingAccount account1 = new SavingAccount("John", 123456, 5, 100);
        SavingAccount account2 = new SavingAccount("Jane", 789012, 5, 100);

        Scanner sc = new Scanner(System.in);

        // Deposit
        try {
            System.out.print("Enter deposit amount for account 1: ");
            double depositAmount = sc.nextDouble();
            account1.Deposit(depositAmount);
        } catch (NegativeAmountException e) {
            //System.out.println("Error: " + e.getMessage());
        }

        // Withdrawal
        try {
            System.out.print("Enter withdrawal amount for account 1: ");
            double withdrawalAmount = sc.nextDouble();
            account1.Withdraw(withdrawalAmount);
        } catch (NegativeAmountException | InsufficientAmountException e) {
            //System.out.println("Error: " + e.getMessage());
        }

        // Transfer
        try {
            System.out.print("Enter transfer amount from account 1 to account 2: ");
            double transferAmount = sc.nextDouble();
            account1.transfer(transferAmount, account2);
        } catch (NegativeAmountException | InsufficientAmountException e) {
            //System.out.println("Error: " + e.getMessage());
        }

        // Display
        System.out.println("\nAccount 1 Details:");
        account1.Display();
        System.out.println("\nAccount 2 Details:");
        account2.Display();

        sc.close();
    }
}

