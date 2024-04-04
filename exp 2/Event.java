import java.util.Scanner;

class Event {
    private String nameEvent;
    private String dateEvent;


    public Event() {    //default constructor
        this.nameEvent = "NA";
        this.dateEvent = "NA";
    }


    public Event(String nameEvent) {    //parameterised constructor
        this.nameEvent = nameEvent;

        this.dateEvent = "March";
    }


    public Event(Event originalEvent) {    //copy constructor
        this.nameEvent = originalEvent.nameEvent;
        this.dateEvent = originalEvent.dateEvent;
    }


    public void display() {    //display function
        System.out.println("Event: " + nameEvent);
        System.out.println("Time: " + dateEvent);
    }


    public static void main(String[] args) {    //main function
        Scanner sc = new Scanner(System.in);
        Event event = null;

        int choice;     //menu driven part
        do {
            System.out.println("1. Default Constructor");
            System.out.println("2. Parameterized Constructor");
            System.out.println("3. Copy Constructor");
            System.out.println("4. Display ");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    event = new Event();
                    break;
                   
                case 2:
                    sc.nextLine();
                    System.out.print("Enter the name of the event: ");
                    String eventName = sc.nextLine();
                    event = new Event(eventName);
                    break;
                   
                case 3:
                    if (event != null) {
                        Event copiedEvent = new Event(event);
                    }
                    else {
                        System.out.println("Error: No event to copy. Create an event first or exit program.");
                    }
                    break;
                   
                case 4:
                    if (event != null) {
                        event.display();
                    }
                    else {
                        System.out.println("Error: No event to display. Create an event first or exit program.");
                    }
                    break;
                   
                case 0:
                    System.out.println("Exiting.");
                    System.exit(0);
                    break;
                   
                default:
                    System.out.println("enter valid option.");
            }
        }
        while (choice != 0);
    }
}
