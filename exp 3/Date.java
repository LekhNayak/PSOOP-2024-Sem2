import java.util.*; // Importing all important methods

public class Date {
    // Private member variables to store year, month, date, hours, minutes, and seconds
    private int year, month, date, hrs, min, sec;

    // Default constructor for Date class
    Date() {
        // Initializing default values
        this.month = 1;
        this.date = 1;
        this.year = 2000;
        this.hrs = 00;
        this.min = 00;
        this.sec = 00;
    }

    // Setter method to set date with 3 arguments
    public void setdate(int year, int month, int date){
        this.month = month;
        this.date = date;
        this.year = year;
        this.hrs = 00;
        this.min = 00;
        this.sec = 00;
    }

    // Setter method to set date with 5 arguments
    public void setdate(int year, int month, int date, int hrs, int min){
        this.month = month;
        this.date = date;
        this.year = year;
        this.hrs = hrs;
        this.min = min;
        this.sec = 00;
    }

    // Setter method to set date with 6 arguments
    public void setdate(int year, int month, int date, int hrs, int min, int sec){
        this.month = month;
        this.date = date;
        this.year = year;
        this.hrs = hrs;
        this.min = min;
        this.sec = sec;
    }

    // Method to display the date and time
    public void Display() {
        System.out.println(month + " " + date + ", " + year + " " + hrs + ":" + min + ":" + sec );
    }

    // Main method
    public static void main (String[] args) {
        // Creating an object for default constructor
        Date def = new Date();
        
        // Creating objects for different setdate methods
        Date date1 = new Date();
        Date date2 = new Date();
        Date date3 = new Date();
        
        // Setting dates using different setdate methods
        date1.setdate(2024, 2, 9);
        date2.setdate(2024, 2, 9, 10, 0);
        date3.setdate(2024, 2, 9, 10, 10, 0);
        
        // Displaying dates
        def.Display();
        date1.Display();
        date2.Display();
        date3.Display();        
    }
}
