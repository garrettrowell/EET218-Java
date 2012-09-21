import java.util.*;
public class Lab3_1 {

	
	/**
	 * Name: Garrett Rowell
	 * Date: Jan 25, 2012
	 * Class: EET 218
	 * Description: Loops until user enters -99
	 * 				prints min, max, and average on numbers entered
	 */
	
	
	   // All my variables used
	 
	static int enter=0 ;
	static int min=0;
	static int max=0;
	static int count=0;	
	static double average=0.0;
	static double vals=0.0;
	
	// Scanner gets user input from keyboard	 
	static Scanner num = new Scanner(System.in);
	
	// Creates an Integer ArrayList to store user inputs	 
	static List<Integer> num_Vals = new ArrayList<Integer>();
	
	static double avg_calc(double x, double y)
	{
		double z=0;
		z= x/y;
		return z;
	}
	
	public static void input() {
	
	
		// While loop that keeps running until user enters the value -99
		 
		while(enter!=(-99))
		{
			if (count==0)
			{
				System.out.print("Enter a number... \n>");
				enter = num.nextInt();
		
				
				 // adds user input to ArrayList 
				 
				num_Vals.add(enter);
				count++;
			}
			else
			{
				System.out.print("Enter another number... \n>");
				enter = num.nextInt();
				num_Vals.add(enter);
			}
		}
	}
		
	public static void print_Out(){
		/*
		 * Collections.max finds the max and Collections.min
		 * finds the min of the listarray num_Vals
		 */
		Object max = Collections.max(num_Vals);
		Object min = Collections.min(num_Vals);
		
		// Prints min and max values to console
		 
		System.out.println("\n" +"*********STATS*********");
		System.out.println("Highest Number Entered: "+max);
		System.out.println("Lowest Number Entered: "+min);
		
		
		 //Finds out how many integers are stored in num_Vals
		 
		for(Integer avg:num_Vals) 
		{
			vals += avg;
		}
				
		 // Calculates average then formats it to 3 decimal places
		 
			average = avg_calc(vals, num_Vals.size());
			System.out.print("Average: ");
			System.out.format("%.3f\n", average);
	}
	
	public static void main(String[] args) {
		
		 input();
		 print_Out();		 
	}
}
