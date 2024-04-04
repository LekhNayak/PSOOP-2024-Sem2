import java.util.*;

class AccInfo {
	String name;
	long accno;
	String acctype;
	double accbalance;
	Scanner sc = new Scanner(System.in);
	
	//Function to initialize account
	void initialize() {
		System.out.print("Enter Account holder name:");
		name =  sc.nextLine();
		
		System.out.print("Enter Account number:");
		accno = sc.nextLong();
		
		while (true) {
			System.out.print("Enter Account type (savings/current):");
			acctype = sc.next().toLowerCase();
			
			if (acctype.equals("savings") || acctype.equals("current")) {
				break;
			}
			else {
				System.out.print("Please enter a valid account type (savings or current)");
			}
		}
		
		System.out.print("Enter initial Account Balance: ");
		accbalance = sc.nextDouble();
	}
	
	//function to check the balance of the account
	void checkBal() {
		System.out.print("Current account balance is: " + accbalance + "\n");
	}
	
	//function to add money to the account
	void deposit() {
		System.out.print("Enter amount to Deposit:");
		double damount = sc.nextDouble();
		accbalance = accbalance + damount;
		System.out.println("Amount deposited Successfully.\n");
		checkBal();
	}
	
	//function to remove money from the account
	void withdraw() {
	  System.out.println("Enter amount to Withdraw:");
    double wamount = sc.nextDouble();
    if (wamount <= accbalance){
      accbalance = accbalance - wamount;
      System.out.println("Withdrawal was successful");
    }
    else {
      System.out.println("Insufficient balance, withdrawal not allowed ");
    }
    checkBal();
	}
	
	//function to close the scanner to prevent resource leak
	void closeScanner() {
		sc.close();
	}

}

public class Account{
  public static void main(String[] args) {
	
	//creating object for AccInfo class and scanner for main class 
		AccInfo a1 = new AccInfo();
		Scanner sc = new Scanner (System.in);
		
	//Welcome message 
		System.out.print("Welcome to SPIT bank!!\nHow can we help you?");
		
	//initilize the acc
		System.out.println("Please Initialize your acc");
		a1.initialize();
		
	//main menu loop
		while (true) {
		  System.out.println("Menu:\n1. Check Balance\n2. Deposit Amount\n3. Withdraw Amount\n4. Exit");
		  int option = sc.nextInt();
		  
		  switch (option) {
		    case 1:
		      a1.checkBal();
		      break;
		    case 2:
		      a1.deposit();
		      break;
		    case 3:
		      a1.withdraw();
		      break;
		    case 4:
		      a1.closeScanner();
		      sc.close();
		      System.out.println("Exiting program. Thank you!");
		      return;
		    default:
		      System.out.println("Please enter a valid option");
		      break;
		  }
		}
	}
}





























