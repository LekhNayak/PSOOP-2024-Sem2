import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Movie {
    private String name;
    private String type;
    private String heroName;
    private String heroine;
    private double budget;

    public Movie(String name, String type, String heroName, String heroine, double budget) {
        this.name = name;
        this.type = type;
        this.heroName = heroName;
        this.heroine = heroine;
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    public String toString() {
        return "Movie: " + name + ", Type: " + type + ", Hero: " + heroName + ", Heroine: " + heroine + ", Budget: Rs. " + budget;
    }
}

public class MovieDatabase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Movie> movies = new ArrayList<>();

        System.out.println("Enter movie information (name, type, hero name, heroine, budget) or type 'done' to finish:");

        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.equals("done")) {
                break;
            }
            System.out.print("Type: ");
            String type = scanner.nextLine();
            System.out.print("Hero Name: ");
            String heroName = scanner.nextLine();
            System.out.print("Heroine: ");
            String heroine = scanner.nextLine();
            System.out.print("Budget: ");
            double budget = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            movies.add(new Movie(name, type, heroName, heroine, budget));
        }

        // Sort movies by budget
        movies.sort((m1, m2) -> Double.compare(m1.getBudget(), m2.getBudget()));

        System.out.println("\nMovies sorted by budget:");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}

