import java.util.*;
public class Lab3_3 {
	
	/**
	 * Name: Garrett Rowell
	 * Date: Jan 25, 2012
	 * Class: EET 218
	 * Description: "Rolls" 2 die using random numbers and give different sayings
	 * 				depending on the numbers rolled 
	 */
	
	public static void dice_roll()
	{
		//creates variables to store random values
		int d_1=0, d_2=0, added=0;
		Random dice_1 = new Random();
		Random dice_2 = new Random();
		
		//generates random numbers between 1 and 6
		d_1=dice_1.nextInt(6)+1;
		d_2=dice_2.nextInt(6)+1;
		
		//adds the two die together for score
		added = d_1+d_2;
		
		//looks to see what the score was then prints output
		if (added == 2) 
	        System.out.println("Snake Eyes!");
	      else if (added == 7||added==11) 
	        System.out.println("Seven Come Eleven!");	      
	      else if (added == 12) 
	        System.out.println("Box Cars! You Lose");                
	      else 
	        System.out.println("You made point! It is "+added);
	}
	
	public static void main(String[] args) 
	{
		int i=0;
		do
		{
			dice_roll();
			i++;
		}	
		while(i<100);
	}
}
