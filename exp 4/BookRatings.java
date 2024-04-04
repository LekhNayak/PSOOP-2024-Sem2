import java.util.*;

public class BookRatings
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of books: ");
        int numBooks = scanner.nextInt();
		System.out.print("Enter reviewers: ");
        int rreviews = scanner.nextInt();
        int[][] bookRating = new int[numBooks][rreviews];
        
        for (int i = 0; i < numBooks; i++) 
        {   
            System.out.println("Enter the ratings for book " + (i + 1) + ":");
            for (int j = 0; j < rreviews; j++) 
            {
                bookRating[i][j] = scanner.nextInt();
            }
        }
        double[] averageRatings = calculateAverageRatings(bookRating);
        int mostPopularBookIndex = findMostPopularBook(averageRatings);
        
        displayResults(averageRatings, mostPopularBookIndex);
	}
	
    public static double[] calculateAverageRatings(int[][] bookRating) {
        double[] averageRatings = new double[bookRating.length];
        for (int i = 0; i < bookRating.length; i++) {
            double sum = 0;
            for (int rating : bookRating[i]) {
                sum += rating;
            }
            averageRatings[i] = sum / bookRating[i].length;
        }
        return averageRatings;
    }
    public static int findMostPopularBook(double[] averageRatings) {
        int mostPopularBookIndex = 0;
        double highestAverageRating = averageRatings[0];
        for (int i = 1; i < averageRatings.length; i++) {
            if (averageRatings[i] > highestAverageRating) {
                highestAverageRating = averageRatings[i];
                mostPopularBookIndex = i;
            }
        }
        return mostPopularBookIndex;
    }

	public static void displayResults(double[] averageRatings, int mostPopularBookIndex)
	{
		System.out.println("The average ratings of all books given are :");
		for(int i = 0;i < averageRatings.length;i++)
		{
			System.out.printf("BOok no %d has average RAting : %.2f\n",(i+1),averageRatings[i]);
		}

		System.out.println("The best book is book no " +(mostPopularBookIndex+1) + " with average rating of : " + averageRatings[mostPopularBookIndex]);
	}
}
        
        
