import java.util.*;


public class Lab4 {

	/**
	 *  Name: Garrett Rowell
	 * Date: Feb 8, 2012
	 * Class: EET 218
	 * Description: generate a random password for the user 
	 *				using 5 letters 2 special characters and 2 numbers
	 */
	
	//scanner looks to see what the user inputs
	static Scanner input = new Scanner(System.in);
	//various variables used
	static int val=0;
	static String lowercaseYN="", yes="Yy";
	//the arrays of characters from which the password is generated
	public static String alphabet[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
		"o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N",
		"O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	public static String specialChars[]={"!","@","#","$","%","^","&","*"};
	public static String numbers[]={"0","1","2","3","4","5","6","7","8","9"};
	//array to store the generated password
	public static String pass[]= new String[9];
	
	public static void upperlower()
	{
		System.out.println("Use lower case letters only? Y/N \n>");
		//saves the user input into the variable
		lowercaseYN = input.next();
		//looks and sees if the string "Yy" contains what the user inputed
		if (yes.contains(lowercaseYN))
		{
			//runs 5 times because we want to generate 5 letters
			for (int i=0; i<=4;i++)
			{
				//gets a random number from 0-25 because the user only 
				//wants to use lower-case numbers
				Random rnd1 = new Random();
				val=rnd1.nextInt(25);
				//uses the random number and sees what's in the alphabet
				//array at that value and stores it in the pass array
				//in 0-4 #note the values for i used in for loop#
				pass[i]=alphabet[val];
			}
		}
		else
		{
			for (int i=0; i<=4;i++)
			{
				//gets a random number from 0-51 because the user wants
				//a more secure password / use upper-case and lower-case 
				//letters
				Random rnd1 = new Random();
				val=rnd1.nextInt(52);
				//uses the random number and sees what's in the alphabet
				//array at that value and stores it in the pass array
				//in 0-4 #note the values for i used in for loop#
				pass[i]=alphabet[val];
			}
		}
	}
	
	public static void chars()
	{
		//runs 2 times because we only want 2 special characters
		for (int i=5;i<=6;i++)
		{
			//gets random number from 0-8
			Random rnd1 = new Random();
			//
			val=rnd1.nextInt(8);
			//uses the random number and sees what's in the specialChars
			//array at that value and stores it in the pass array
			//in 5-6 #note the values for i used in for loop#
			pass[i]=specialChars[val];
		}
	}
	
	public static void nums()
	{
		//runs 2 times because we only want 2 numbers
		for (int i=7;i<=8;i++)
		{
			//gets random number from 0-10
			Random rnd1 = new Random();
			val=rnd1.nextInt(10);
			//uses the random number and sees what's in the numbers
			//array at that value and stores it in the pass array
			//in 7-8 #note the values for i used in for loop#
			pass[i]=numbers[val];
		}
	}
	
	public static void main(String[] args) 
	{
		//runs what was defined above
		upperlower();
		chars();
		nums();		
		//shuffles what was stored in the array pass[]
		Collections.shuffle(Arrays.asList(pass));
		//prints out the shuffled array pass[]
		for (int i=0;i<=8;i++)
		{
			System.out.print(pass[i]);
		}
		
	}
}
