import java.util.*;

class PopulerBook{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		System.out.print("Enter the numbers of books : ");
		int book = scan.nextInt();		
		System.out.print("Enter the numbers of readers : ");
		int readers = scan.nextInt();
		int[][] array = new int[book][readers];
		for(int i = 0 ; i < array.length ; i++){
			System.out.println("Enter ratings for book " + (i + 1) + ":");	
			for(int j = 0 ; j < array[0].length ; j++){
				System.out.print("Rating " + (j + 1) + " : ");
				array[i][j] = scan.nextInt();					
			}
		} 
		double[] avg = new double[book];
		System.out.println("Average Ratings:");
		for(int i = 0 ; i < array.length ; i++){	
			for(int j = 0 ; j < array[0].length ; j++){
				avg[i] += array[i][j];				
			}
			avg[i] = avg[i]/readers;
			System.out.printf("The average rating of book %d is %.2f\n", (i+1), avg[i]);
		} 
		double max = avg[0];
		for(int i = 1 ; i < avg.length ; i++){
			if(max < avg[i]){
				max = avg[i];
			}
		}
		for(int i = 0 ; i < avg.length ; i++){
			if(avg[i] == max){
				System.out.println("The most popular book is book " + (i + 1));			
				break;
			}
		}
	}
