import javax.swing.*;
import java.awt.event.*;

public class Lab9Win extends JFrame
{
	/**
	 * Name: Garrett Rowell
	 * Date: Mar 28, 2012
	 * Class: EET 218
	 * Description: Calculates the sales tax for a store (county, state, and city)
	 * 				using radio buttons and a calculate button. Also has an exit button.
	 * 				Yay GUI's... oh and does not allow negative numbers to be inputed
	 * 				since the government doesn't pay you taxes... tis too bad tho. Also since
	 * 				im cool it also doesn't crash when no number is calculated
	 * 				(ie. textfield is left blank and CalcButton is pressed) instead 
	 * 				it gives you a friendly reminder to enter a number... yeah right thats
	 * 				no fun so to jazz it up a bit it yells at ya so don't screw up or else!
	 */
		//all the variables needed to get everything to work...
		//pretty self explanatory i think
	   private JPanel pnl;
	   private JLabel lbl;
	   private JTextField txtFld;
	   private JButton calcBtn,exitBtn;
	   private JRadioButton county,state,city;
	   private String str;
       private double tax=.2,totalTax;
       //variables that hold the size of the window
       //also very straight forward...
	   private final int WINDOW_WIDTH = 320;
	   private final int WINDOW_HEIGHT = 200;	   
       
	   public Lab9Win()
	   {
		   //names the frame
		   super("Sales Tax Calculator");
		   //sets the panel size
		   setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		   //tells the program to exit when the "X" button is clicked
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   //executes the buildPanel command defined below
		   buildPanel();
		   //adds the panel to the frame
		   add(pnl);
		   //makes it visible ie. you can see it
		   //but you knew that right?... id hope so
		   setVisible(true);		   
	   }
	   private void buildPanel()
	   {
		   //sets values to the variables to be displayed on the screen
	      lbl = new JLabel("Enter Sales Tax: $");
	      txtFld = new JTextField(10);
	      calcBtn = new JButton("Calculate");
	      exitBtn = new JButton("Exit");
	      //makes county selected by default
	      county = new JRadioButton("County",true);	      
	      state = new JRadioButton("State");
	      city = new JRadioButton("City");
	      //creates a group for the radiobuttons
	      //that way only one can be selected at a time
	      ButtonGroup rdbgrp = new ButtonGroup();
	      //adds the readiobuttons to the group
	      rdbgrp.add(county);
	      rdbgrp.add(state);
	      rdbgrp.add(city);
	      //makes a panel
	      pnl = new JPanel();
	      //adds everything to the panel
	      pnl.add(lbl);
	      pnl.add(txtFld);
	      pnl.add(calcBtn);
	      pnl.add(exitBtn);
	      pnl.add(county);
	      pnl.add(state);
	      pnl.add(city);
	      //creates listeners to see what the user is clicking on
	      calcBtn.addActionListener(new calcBtnLst());
	      exitBtn.addActionListener(new Exit());
	      county.addActionListener(new rdbLst());
	      state.addActionListener(new rdbLst());
	      city.addActionListener(new rdbLst());	      
	   }
	   private class Exit implements ActionListener
	   {
		   public void actionPerformed(ActionEvent z)
		   {
			   //closes the program
			   System.exit(0);
		   }
	   }
	   private class rdbLst implements ActionListener
	   {
		   public void actionPerformed(ActionEvent d)
		   {
			   //sets the tax rate depending on which 
			   //radiobutton is selected
			   if (county.isSelected()==true)
			   {
				   tax = 0.2;
			   }
			   else if (state.isSelected()==true)
			   {
				   tax = 0.3;
			   }
			   else if (city.isSelected()==true)
			   {
				   tax = 0.4;
			   }
		   }
	   }
	   private class calcBtnLst implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	    	 try
	    	 {
	    		 //grabs the users input
	    		 str = txtFld.getText();
	    		 //checks if it a negative
		         if (str.contains("-")==true)
		         {
		        	 //and since thats a big No-No it creates a 
		        	 //pop up that yells at you
		        	 JOptionPane.showMessageDialog(null,"NO NEGATIVES!!!");
		         }
		         //if its a positive number like it should be
		         else
		         {
		        	 //since you were a good boy/girl it takes the 
		        	 //users input as a double and then calculates the 
		        	 //desired sales tax
		        	 totalTax = Double.parseDouble(str) * tax;
		        	 //and for your convenience displays the sales tax in a popup
		        	 JOptionPane.showMessageDialog(null,"Sales tax of $"+str+ " is: $" + totalTax);
		         } 
	    	 }
	    	 //if ya went and tried calculating nothing like a ding-bat...
	    	 catch(Exception f)
	    	 {
	    		 //instead of crashing the program it yells at ya instead!
	    		 JOptionPane.showMessageDialog(null, "ENTER SOME NUMBERS!!!");
	    	 }	 
	      }
	   }
}
 