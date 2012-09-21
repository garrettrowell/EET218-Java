import java.util.*;

public class Sellstock {

	/**
	 * Name: Garrett Rowell
	 * Date: Jan 18, 2012
	 * Class: EET 218
	 * Description: Calculates the value of x amount of shares,
	 * 				the amount of commission and the net proceeds
	 */

// Defines all of the doubles used for the calculations	
double Stock_Price, Num_Shares, Shares_Val, Commission_Rate, Commission, Net_Procedes;
	
	// Does the multiplication for the value of shares
	double mult(double n1, double n2)
	{	double x;
		x = n1 * n2;
		return(x);
	}	
	
	//calculates the commission rate
	double commis(double n1, double n2)
	{	double x,y;
		y = n1 *n2;
		x = (y / 100);
		return x;
	}
	
	//calculates the net proceeds
	double net(double n1, double n2)
	{	double x;
		x = n1 - n2;
		return x;
	}
	
	
	public static void main(String[] args) {
		
		
		 // The Scanner Stocks as defined below finds the user's
		 // input from the keyboard
		Scanner Stocks = new Scanner (System.in);
		Sellstock sell = new Sellstock();
							
		System.out.print("Enter Stock Price:");
		 //Stocks.nextDouble() is used to tell when the user inputs
		 // another double and saves it in the specified variable
		sell.Stock_Price = Stocks.nextDouble();
		
		System.out.print("Enter Number of Shares:");
		sell.Num_Shares = Stocks.nextDouble();
	
		// Multiplies Stock_Price and Num_Shares and then stores
		// the data in the variable Shares_Val
		sell.Shares_Val = sell.mult(sell.Stock_Price, sell.Num_Shares);
		System.out.print("Value of Shares: $");
		
		// Prints Shares_Val with only 2 decimal places
		System.out.format("%.2f\n",sell.Shares_Val);
		
		//commission rate stuff
		System.out.print("Enter Commission Rate (as percentage):");
		sell.Commission_Rate = Stocks.nextDouble();
		//commission
		sell.Commission = sell.commis(sell.Shares_Val, sell.Commission_Rate);
		System.out.print("Commission: $");
		System.out.format("%.2f\n",sell.Commission);
		//net proceeds
		sell.Net_Procedes = sell.net(sell.Shares_Val, sell.Commission);
		System.out.print("Net Procedes: $");
		System.out.format("%.2f\n",sell.Net_Procedes);
		
	}
}
