import java.util.*;

public class Quiz_1 {

	/**
	 * Name: Garrett Rowell
	 * Date: Feb 1, 2012
	 * Class: EET 218
	 * Description: Battleship! 
	 * 				generates sets of two numbers and sees if the patrol 
	 * 				boat has been hit.
	 * 				The patrol boat is located at C3&4 (see chart below). 
	 * 				You loose if ten sets of random numbers has been 
	 * 				generated and patrol boat is still floating.
	 * 					|================================|
	 * 					|	1	2	3	4	5	6	7	8|
	 * 					|================================|
	 *  				|A	-	-	-	-	-	-	-	-|
	 *  				|B	-	-	-	-	-	-	-	-|
	 *    				|C	-	-	x	x	-	-	-	-|	
	 *      			|D	-	-	-	-	-	-	-	-|
	 *        			|E	-	-	-	-	-	-	-	-|
	 *          		|F	-	-	-	-	-	-	-	-|
	 *            		|G	-	-	-	-	-	-	-	-|
	 *              	|H	-	-	-	-	-	-	-	-|
	 *              	|================================|
	 *              
	 */
	
	
	//creates array
	static String[][] grid = new String[8][8];
	//other variables used
	static int x,y,count=0;
	static Boolean twoTwo,twoThree=false;
	static String z="";
	
	
	public static void set_Grid()
	{
			//places the patrol boat on grid
			grid[2][2]="x";
			grid[2][3]="x";
			//Just looks pretty
			System.out.println("==========BATTLESHIP!==========");
			System.out.println("Your shot -> Hit/Miss");
	}
	
	public static void mapping()
	//all the mapping() does is look at the random number generated thats stored in x
	//then assigns the proper row letter to z. Then adds 1 to the integer stored in y 
	//and prints out to console
	{
		if(x==0){
			z = "A";
			System.out.print(z);
			System.out.print(y+1);}
		if(x==1){
			z="B";
			System.out.print(z);
			System.out.print(y+1);}
		if(x==2){
			z="C";
			System.out.print(z);
			System.out.print(y+1);}
		if(x==3){
			z="D";
			System.out.print(z);
			System.out.print(y+1);}
		if(x==4){
			z="E";
			System.out.print(z);
			System.out.print(y+1);}
		if(x==5){
			z="F";
			System.out.print(z);
			System.out.print(y+1);}
		if(x==6){
			z="G";
			System.out.print(z);
			System.out.print(y+1);}
		if(x==7){
			z="H";
			System.out.print(z);
			System.out.print(y+1);}
	}
	
	public static void sort()
	{
		while (count<64)
		{
			count++;
			//creates random numbers for coordinates
			Random rnd1 = new Random();
			Random rnd2= new Random();
			//uses only numbers 0-8 and saves to x&y respectively
			x=rnd1.nextInt(8);
			y=rnd2.nextInt(8);	
			//sees if patrol boat was hit
			
			mapping();
			if (grid[x][y]=="x")
			{
				System.out.println(" - Hit");
				//if C3 hit then save that in boolean twoTwo
				if (grid[x][y]==grid[2][2]){
					twoTwo=true;
					}
				//if C4 hit then save in boolean twoThree
				if(grid[x][y]==grid[2][3]){
					twoThree=true;
					}
				//if both C3 and C4 have been hit then stop the while loop
				if(twoTwo==true && twoThree==true){
					System.out.println(" - Hit And Sunk");
					count=66;}
					
			}
			
			//random number are not [2][2] or [2][3] then its a miss			
			else
				System.out.println(" - Miss");}
							
			if (count==64){
				System.out.println("Game over, you lose.");
				System.out.println("===============================");
			}
	}
	
	
	public static void main(String[] args) {
		
		//run initial setup
		set_Grid();
		//get random numbers (ten sets) then see if they hit patrol boat
		sort();
		

	}

}
