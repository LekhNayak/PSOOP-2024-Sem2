import java.util.*;

// Class representing a store named Westside
class Westside {
    private int clothesAvailable; // Number of clothes available in the store
    private int accessoriesAvailable; // Number of accessories available in the store
    public static final int PRICE_ITEM = 5000; // Price of each item

    // Constructor to initialize the availability of clothes and accessories
    public Westside() {
        this.clothesAvailable = 10;
        this.accessoriesAvailable = 10;
    }

    // Method to purchase clothes
    public boolean purchaseClothes() {
        if (clothesAvailable > 0) {
            clothesAvailable--;
            return true; // Clothes purchased successfully
        } else {
            return false; // Clothes out of stock
        }
    }

    // Method to purchase accessories
    public boolean purchaseAccessories() {
        if (accessoriesAvailable > 0) {
            accessoriesAvailable--;
            return true; // Accessories purchased successfully
        } else {
            return false; // Accessories out of stock
        }
    }

    // Getter method to retrieve the number of clothes available
    public int getClothesAvailable() {
        return clothesAvailable;
    }

    // Getter method to retrieve the number of accessories available
    public int getAccessoriesAvailable() {
        return accessoriesAvailable;
    }
}

// Abstract class representing a payment
abstract class Payment {
    protected double amount; // Total amount

    // Constructor to initialize the total amount
    public Payment() {
        amount = 25000; // Initial amount set to 25000
    }

    // Abstract method to provide payment details
    public abstract void paymentDetails(double price);
}

// Class representing cash payment
class CashPayment extends Payment {

    // Constructor to initialize cash payment
    public CashPayment() {
        super();
    }

    // Method to provide payment details for cash payment
    public void paymentDetails(double price) {
        amount -= price; // Deducting the price from the total amount
        System.out.println("Payment made in cash. Remaining balance is: " + amount);
    }
}

// Class representing credit card payment
class CreditCardPayment extends Payment {
    private String cardNumber; // Credit card number
    private String cardExpirationDate; // Credit card expiration date
    private String cardName; // Name on the credit card

    // Constructor to initialize credit card payment details
    public CreditCardPayment(String cardName, String cardNumber, String cardExpirationDate) {
        super();
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardExpirationDate = cardExpirationDate;
    }

    // Method to provide payment details for credit card payment
    public void paymentDetails(double price) {
        amount -= price; // Deducting the price from the total amount
        System.out.println("Payment made with Credit Card.");
        System.out.println("Card Holder name is: " + cardName);
        System.out.println("Card Number is : " + cardNumber);
        System.out.println("Card Expiration Date is : " + cardExpirationDate);
        System.out.println("Remaining balance is: " + amount);
    }
}

// Class representing a person
class Person {
    private String personName; // Person's name
    private String personPhoneNumber; // Person's phone number

    // Constructor to initialize person's name and phone number
    public Person(String personName, String personPhoneNumber) {
        this.personName = personName;
        this.personPhoneNumber = personPhoneNumber;
    }

    // Method for a person to buy an item
    public void buyItem(Payment paymentMethod, String item, Westside westside) {
        if (item.equals("clothes")) { // If the item to buy is clothes
            if (westside.purchaseClothes()) { // If clothes are available for purchase
                paymentMethod.paymentDetails(Westside.PRICE_ITEM); // Make payment
            } else {
                System.out.println("Clothes out of stock!"); // Print message if clothes are out of stock
            }
        } else if (item.equals("accessories")) { // If the item to buy is accessories
            if (westside.purchaseAccessories()) { // If accessories are available for purchase
                paymentMethod.paymentDetails(Westside.PRICE_ITEM); // Make payment
            } else {
                System.out.println("Accessories out of stock!"); // Print message if accessories are out of stock
            }
        } else {
            System.out.println("Invalid item type!"); // Print message for invalid item type
        }
    }
}

// Main class to test the functionality
public class MainWestside {
    public static void main(String[] args) {
        Westside westside = new Westside(); // Creating an instance of the Westside store
        Person[] persons = { // Creating an array of Person objects
                new Person("Alice", "123-456-7890"),
                new Person("Bob", "987-654-3210"),
                new Person("Charlie", "111-222-3333"),
                new Person("David", "444-555-6666"),
                new Person("Eve", "777-888-9999")
        };

        // Person 1 buys clothes with cash
        CashPayment cashPayment1 = new CashPayment();
        persons[0].buyItem(cashPayment1, "clothes", westside);

        // Person 2 buys accessories with cash
        CashPayment cashPayment2 = new CashPayment();
        persons[1].buyItem(cashPayment2, "accessories", westside);

        // Person 3 buys clothes with credit card
        CreditCardPayment creditCardPayment1 = new CreditCardPayment("John Doe", "12/26", "1234567890123456");
        persons[2].buyItem(creditCardPayment1, "clothes", westside);

        // Person 4 buys accessories with credit card
        CreditCardPayment creditCardPayment2 = new CreditCardPayment("Jane Smith", "11/25", "9876543210987654");
        persons[3].buyItem(creditCardPayment2, "accessories", westside);

        // Person 5 tries to buy clothes, but they are out of stock
        CashPayment cashPayment3 = new CashPayment();
        persons[4].buyItem(cashPayment3, "clothes", westside);
    }
}

