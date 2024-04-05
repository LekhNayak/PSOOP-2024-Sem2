import java.util.*;

// Class to represent a cricketer
class Cricketer {
    String player_name;
    int runs_hit;
    int innings_count;
    int not_out_count;
    float batting_avg;
    
    // Constructor to initialize cricketer details
    Cricketer(String player_name, int runs_hit, int innings_count, int not_out_count) {
        this.player_name = player_name;
        this.runs_hit = runs_hit;
        this.innings_count = innings_count;
        this.not_out_count = not_out_count;
        this.batting_avg = 0.0f; // Default batting average
    }
    
    // Method to calculate batting average
    float get_avg() throws ArithmeticException {
        int out_count = innings_count - not_out_count;
        if (out_count == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        batting_avg = (float) runs_hit / out_count;
        return batting_avg;
    }
    
    // Override toString method to display cricketer details
    public String toString() {
        return "Player: " + player_name + ", Batting Average: " + batting_avg;
    }
}

// Comparator class to compare cricketers based on batting average
class BattingAverageComparator implements Comparator<Cricketer> {
    public int compare (Cricketer c1, Cricketer c2) {
        return Float.compare(c1.batting_avg, c2.batting_avg);
    }
}

// Main class
public class CricketerMain {
    public static void main(String args[]) {
        ArrayList<Cricketer> team = new ArrayList<>(); // List to store cricketers
        Scanner sc = new Scanner(System.in); // Scanner for user input
        
        // Loop to input details of 11 players
        for (int i = 1; i <= 11 ; i++) {
            System.out.println("Enter details for Player " + i + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Runs Hit: ");
            int runs = sc.nextInt();
            System.out.print("Innings Count: ");
            int innings = sc.nextInt();
            System.out.print("Not Out Count: ");
            int notOut = sc.nextInt();

            team.add(new Cricketer(name, runs, innings, notOut)); // Add cricketer to the team
            sc.nextLine(); // Consume newline character
        }
        
        float totalAvg = 0.0f; // Total average of the team
        
        // Calculate total average of the team
        for (Cricketer player : team) {
            try {
                totalAvg += player.get_avg(); // Calculate batting average for each player and add to total
            } 
            catch(ArithmeticException e) {
                System.out.println("Error calculating batting average for " + player.player_name + ": " + e.getMessage());
            }
        }
        
        // Calculate the average of the entire team
        totalAvg /= team.size();
        
        // Display the team stats
        System.out.println("Team Stats:");
        System.out.println("Total average: " + totalAvg);
        
        // Check if the average of the batting average of the entire team is less than 20 runs
        if (totalAvg < 20) {
            throw new RuntimeException("Average batting average of the team is less than 20 runs.");
        }
        
        // Sort cricketers based on batting average
        Collections.sort(team, new BattingAverageComparator());

        // Display cricketers in ascending order of their batting average
        System.out.println("\nCricketers in ascending order of their batting average:");
        for (Cricketer player : team) {
            System.out.println(player);
        }
        
        sc.close(); // Close scanner
    }
}

