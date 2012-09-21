import java.util.*;
public class Lab3_2 {

	/**
	 * Name: Garrett Rowell
	 * Date: Jan 25, 2012
	 * Class: EET 218
	 * Description: Gets name of 3 runners and displays them in the order they finished
	 */
	
	static String names="";
	static Integer times=0;
	static Scanner input = new Scanner(System.in);
	static 
	
	 // Create arrays
	 
	String[] in_Name = new String[3];
	static Integer[] in_Time = new Integer[3];
	
	public static void bubble_Sort()
	{
		
		 // Sorts the in_Time array from least to greatest
		 
		int temp_Time=0, j=0;
		String temp_Name="";
		boolean is_Running=true;
		
		while(is_Running)
		{
			is_Running=false;
			j++;
			
			for(int i=0; i<in_Time.length-j;i++)
			{
				if (in_Time[i]>in_Time[i+1])
				{
					temp_Time=in_Time[i];
					temp_Name=in_Name[i];
					in_Time[i]=in_Time[i+1];
					in_Name[i]=in_Name[i+1];
					in_Time[i+1]=temp_Time;
					in_Name[i+1]=temp_Name;
					is_Running=true;
				}
			}
		}
	}

	public static void get_Data()
	{
		
		 // Fills both arrays respectfully
		 
		for(int i=0;i<=2;i++)
		{
			System.out.print("Enter name:\n>");
			names = input.next();
			in_Name[i] = names;
			System.out.print("Enter time:\n>");
			times=input.nextInt();
			in_Time[i] = times;
		}
	}
	
	public static void print_Data()
	{
		System.out.println("*******5K Results*******");
		
		
		 // print both arrays
		 
		for(int i=0;i<=2;i++)
		{
			System.out.println((i+1)+") "+in_Name[i]+" finished in: "+in_Time[i]+" minutes");
		}
	}
	public static void main(String[] args) 
	{
		
		 // runs everything created above...
		 
		get_Data();
		bubble_Sort();
		print_Data();
	}
	
}



