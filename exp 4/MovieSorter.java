import java.util.*;

// Define a class to represent a Movie
class Movie {
    String name;
    String type;
    String heroName;
    String heroineName;
    double budget;

    // Constructor to initialize Movie object
    Movie(String name, String type, String heroName, String heroineName, double budget) {
        this.name = name;
        this.type = type;
        this.heroName = heroName;
        this.heroineName = heroineName;
        this.budget = budget;
    }
}    

public class MovieSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        // Accepting information of movies from the user
        System.out.println("Enter the number of movies:");
        int numMovies = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Movie[] movies = new Movie[numMovies]; //creating an array of objects

        // Loop to gather information for each movie
        for (int i = 0; i < numMovies; i++) {
            System.out.println("Enter details for movie " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Type (action, thriller, comedy, drama): ");
            String type = scanner.nextLine();
            System.out.print("Enter Hero Name for movie " + (i + 1) + ": ");
            String heroName = scanner.nextLine();
            System.out.print("Enter Heroine Name for movie " + (i + 1) + ": ");
            String heroineName = scanner.nextLine();
            System.out.print("Enter Budget in Rs. : ");
            double budget = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            movies[i] =  new Movie(name, type, heroName, heroineName, budget);
        }
        
        //bubble sort
        for(int i = 0; i < numMovies; i++) {
          for(int j = 0; j < numMovies - i- 1; j++) {
            if (movies[j].budget > movies[j + 1].budget) {
              Movie Temp = movies[j];
              movies[j] = movies[j + 1];
              movies[j + 1] = Temp;
            }
          }
        }
    System.out.println("---------------------------------------------");    
    System.out.println("Movies Sorted by Budget");
    for (Movie movie: movies) {
      System.out.println("Movie name:" + movie.name);
      System.out.println("Movie type:" + movie.type);
      System.out.println("Movie Hero Name:" + movie.heroName);
      System.out.println("Movie Heroine Name:" + movie.heroineName);
      System.out.println("Movie Budget:" + movie.budget);
      System.out.println("---------------------------------------------");
    }    
  }
}
