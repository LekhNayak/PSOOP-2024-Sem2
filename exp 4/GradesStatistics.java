import java.util.*;

public class GradesStatistics {

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
   
    // Prompt the user to enter the number of students
    System.out.println("Enter the number of students:-");
    int num = sc.nextInt();
    
    // Create an array to store the grades entered by the user
    double grades[] = new double[num];
    
    // Loop through each student and prompt the user to enter their grade
    for (int i = 0; i < num ; i++) {
        System.out.println("Enter grade for student " + (i + 1) +" :");
        grades[i] = sc.nextDouble(); // Read the grade entered by the user
    }
    
    // Print out the grades entered by the user
    System.out.println(Arrays.toString(grades));
    
    // Calculate and print the average of the grades
    System.out.printf("Average is %.2f\n", calculateAvg(grades));
    
    // Calculate and print the minimum grade
    System.out.printf("Minimum grade is %.2f\n", calculateMin(grades));
    
    // Calculate and print the maximum grade
    System.out.printf("Maximum grade is %.2f\n", calculateMax(grades));
    
    // Calculate and print the median grade
    System.out.printf("Median grade is %.2f\n", calculateMedian(grades));
    
    // Calculate and print the standard deviation of the grades
    System.out.printf("Standard Deviation is %.2f\n", calculateStdDev(grades));
  }
  
  // Method to calculate the average of grades
  public static double calculateAvg (double[] grades) {
    double sum = 0;
    // Loop through each grade and calculate the sum
    for (double grade:grades) {
      sum +=grade;
    }
    // Calculate and return the average by dividing the sum by the number of grades
    return sum/grades.length;
  }

  // Method to calculate the minimum grade
  public static double calculateMin (double[] grades) {
    double min = grades[0];
    // Loop through each grade to find the minimum
    for (double grade:grades) {
      if (grade < min) {
        min = grade;
      }
    }
    return min;
  }
  
  // Method to calculate the maximum grade
  public static double calculateMax (double[] grades) {
    double max = 0;
    // Loop through each grade to find the maximum
    for (double grade:grades) {
      if (grade > max) {
        max = grade;
      }
    }
    return max;
  }  
  
  // Method to calculate the median grade
  public static double calculateMedian (double[] grades) {
    Arrays.sort(grades); // Sort the grades array
    int len = grades.length;
    // If the number of grades is even, return the average of the two middle grades
    if (len % 2 == 0) {
      return (grades[len/2] + grades[(len/2) - 1]) / 2;
    }
    // If the number of grades is odd, return the middle grade
    else {
      return grades[len/2];
    }
  }
  
  // Method to calculate the standard deviation of grades
  public static double calculateStdDev (double[] grades) {
    double ssd = 0; // Sum of squared differences
    double variance = 0;
    
    // Loop through each grade and calculate the sum of squared differences from the mean
    for (int i = 0; i < grades.length; i++) {
      ssd += Math.pow((grades[i] - calculateAvg(grades)), 2);
    }
    variance = ssd / grades.length; // Calculate the variance
    // Calculate the standard deviation by taking the square root of the variance
    return Math.sqrt(variance);
  }
}

