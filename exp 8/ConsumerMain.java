import java.util.*;

interface EatItHere {
    void deliverOrder(int orderNumber, double orderPrice);
}

interface TakeAway {
    void dispatchOrder(int orderNumber, double orderPrice);
}

class Consumer implements EatItHere, TakeAway {
    private int orderNumber;
    private double orderPrice;
    
    public Consumer(int orderNumber, double orderPrice) {
        this.orderNumber = orderNumber;
        this.orderPrice = orderPrice;
    } 
    
    public void deliverOrder(int orderNumber, double orderPrice) {
        double ServiceCharge = Math.min(500, orderPrice * 0.10);
        double totalAmount = orderPrice + ServiceCharge;
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Total Amount (Eat It Here): " + totalAmount);
    }
    
    public void dispatchOrder(int orderNumber, double orderPrice) {
        double ServiceCharge = Math.max(45, orderPrice * 0.05);
        double totalAmount = orderPrice + ServiceCharge;
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Total Amount (Take Away): " + totalAmount);
    } 
}

public class ConsumerMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter order number: ");
        int orderNumber = sc.nextInt();

        System.out.println("Enter order price: ");
        double orderPrice = sc.nextDouble();

        Consumer obj1 = new Consumer(orderNumber, orderPrice);
        int option;
        
        do {
            System.out.println("Choose an option : ");
            System.out.println("1. Eat it Here");
            System.out.println("2. Take Away");
            System.out.println("0. EXIT THE PROGRAM");
            option = sc.nextInt();
            
            switch (option) {
                case 1:
                    obj1.deliverOrder(orderNumber, orderPrice);
                    break;
                case 2:
                    obj1.dispatchOrder(orderNumber, orderPrice);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
        while (option < 3);
        sc.close();
    }
}

