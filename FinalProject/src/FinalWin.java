import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;

public class FinalWin extends JFrame implements KeyEventPostProcessor
{
	/**
	 * Name: Garrett Rowell
	 * Date: Apr,30 2012
	 * Class: EET 218
	 * 
	 * I GARRETT ROWELL PINKIE PROMISE THAT I DID NOT CONSULT WITH ANY 
	 * OTHER STUDENT... EVEN JOSH WHILE CODING THIS PROJECT
	 * 
	 * Description: Allows the user to select their favorite type of beer
	 * 				and calculate the amount of calories in 
	 * 				the amount that they wish to. ie X calories in 
	 *				a 6 pack of Y brand.
	 */

	//definitions of arrays, variables, and JFrame components
	static String Brand[] = new String[20],Readin[],temp="";
	static double ABV[] = new double[20],Calories[] = new double[20],ans=0;
	static int counter=0,init=0;
	JComboBox BeerSel;
	private JPanel mainpnl,leftpnl,rightpnl,upperpnl,lowerpnl;
	private JButton CalcBtn,ExitBtn;
	private JRadioButton oz,cans,pack_6,pack_12,pack_24,pack_30,pony,keg;
	private JTextField amount;
	private JLabel calories,abv,calTxt,abvTxt;
	private final int WINDOW_WIDTH = 450;
	private final int WINDOW_HEIGHT = 300;
	int index;
	//Lists to sort through
	public static String alphabet[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
		"o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I",
		"J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	public static String specialChars[]={"!","@","#","$","%","^","&","*",",",".",";",":","/","?",
		"{","[","}","]","\\","|","(",")","-","_","=","+","`","~"};
	//Formats the decimal to 2 decimal places
	DecimalFormat df = new DecimalFormat("#.##");
	
	public static void main(String[] args) 
    {
		//reads in the data file
		FileReadIn();
		//then creates an instance of the GUI
		FinalWin draw = new FinalWin();
    }
	
	public static void FileReadIn()
	{
		//defines the string to temporarily store the data being read in
		String getLine="";
		//Attempts to read in the data file
		try
		{
			//the magic lines of code that read in the data file
			BufferedReader buffRead = null;
			buffRead=new BufferedReader(new InputStreamReader(FinalWin.class.getClassLoader().getResourceAsStream("beer_calories.txt")));
			buffRead.readLine();
			//reads in the data file until the end
			while((getLine=buffRead.readLine()) !=null)
			{
				//parses the data at every comma
				Readin= getLine.split("\\,");
				//stores the data in its corresponding array
			    Brand[counter]=Readin[0];
				ABV[counter]=Double.parseDouble(Readin[1]);
				Calories[counter]=Double.parseDouble(Readin[2]);
				counter++;
			}
			//closes the buffered reader
			buffRead.close();
		}
		catch (Exception e)
		{
			//if an error occurs display the problem
			System.out.println("Error" + e.getMessage());
		}
	}
		
	public FinalWin()
	{
		//names the frame
		super("Beer Calories Calculator");
		//sets the frames size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		//allows it to close by pressing the X in the corner
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//builds the panel
		buildPanel();
		//adds the main panel to the frame
		add(mainpnl);
		//makes the frame in all its glory visible
		setVisible(true);	
	}
	
	public void buildPanel()
	{
		//defines the various swing components
		BeerSel = new JComboBox(Brand);
		oz = new JRadioButton("oz's",true);
		cans = new JRadioButton("Can(s) / Bottle(s) - (12oz)");
		pack_6 = new JRadioButton("6 Pack(s)");
		pack_12 = new JRadioButton("12 Pack(s)");
		pack_24 = new JRadioButton("24 Pack(s)");
		pack_30 = new JRadioButton("30 Pack(s)");
		pony = new JRadioButton("Pony Keg(s) - (984oz)");
		keg = new JRadioButton("Keg - (1984oz)");
		CalcBtn = new JButton("Calculate");
		ExitBtn = new JButton("EXIT");
		calTxt = new JLabel("Calories: ");
		calories = new JLabel("0.00");
		abvTxt = new JLabel("ABV (%): ");
		abv = new JLabel("0.0");
		amount = new JTextField("Enter Amount",10);
		//creates the different panels and defines the amount of rows and columns
		//in each
		mainpnl = new JPanel();
		mainpnl.setLayout(new GridLayout (0,2));
		rightpnl = new JPanel();
		rightpnl.setLayout(new GridLayout (0,1));
		leftpnl = new JPanel();
		leftpnl.setLayout(new GridLayout (2,0));
		upperpnl = new JPanel();
		lowerpnl = new JPanel();
		lowerpnl.setLayout(new GridLayout (3,2));
		//creates a button group so that only one radio button can be
		//selected at one time
		ButtonGroup RdbGrp = new ButtonGroup();
		RdbGrp.add(oz);
		RdbGrp.add(cans);
		RdbGrp.add(pack_6);
		RdbGrp.add(pack_12);
		RdbGrp.add(pack_24);
		RdbGrp.add(pack_30);
		RdbGrp.add(pony);
		RdbGrp.add(keg);
		//adds the components to the various panels
		upperpnl.add(BeerSel);
		rightpnl.add(oz);
		rightpnl.add(cans);
		rightpnl.add(pack_6);
		rightpnl.add(pack_12);
		rightpnl.add(pack_24);
		rightpnl.add(pack_30);
		rightpnl.add(pony);
		rightpnl.add(keg);
		rightpnl.add(amount);
		lowerpnl.add(abvTxt);
		lowerpnl.add(abv);
		lowerpnl.add(calTxt);
		lowerpnl.add(calories);
		rightpnl.add(CalcBtn);
		rightpnl.add(ExitBtn);
		//adds different panels to other panels to
		//achieve the desired look
		leftpnl.add(upperpnl);
		leftpnl.add(lowerpnl);
		mainpnl.add(leftpnl);
		mainpnl.add(rightpnl);
		//creates the listeners
		ExitBtn.addActionListener(new ExitLst());
		CalcBtn.addActionListener(new CalcLst());
		BeerSel.addActionListener(new Selection());
		amount.addMouseListener(new Mouse());
		//allows the program to "listen" for keys being pressed
		//on the keyboard
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventPostProcessor(this);
		//presets
		abv.setText(Double.toString(ABV[index]));
	}
	
	public boolean postProcessKeyEvent(KeyEvent ke) 
	{
		//if enter is pressed on the keyboard
        if (ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode() == KeyEvent.VK_ENTER) 
        {
        	//the action that occurs when CalcBtn is selected is called
        	CalcBtn.doClick();
            // Tell keyboard focus manager that event has been fully handled.
            return true;
        }
        //if ESC is pressed on the keyboard
        if (ke.getID()== KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_ESCAPE)
        {
        	//the action that occurs when ExitBtn is selected is called
        	ExitBtn.doClick();
        	return true;
        }
        // Let keyboard focus manager handle the event further.
        return false;
    }
	
	private class Mouse implements MouseListener
	{
		public void mouseEntered(MouseEvent e) 
		{
			
		}
		//when the mouse is clicked in the amount textfield
		public void mouseClicked(MouseEvent e) 
		{
			//at the start of the program...
			if(init==0)			
			{
				//clear the preset text in the textfeild
				amount.setText("");
				init=1;
			}
			//after the first time...
			else
			{
				//select all of the existing text
				amount.selectAll();
			}
		}
		public void mouseExited(MouseEvent e) 
		{
			
		}
		public void mousePressed(MouseEvent e) 
		{
			
		}
		public void mouseReleased(MouseEvent e) 
		{
			
		}
	}
	
	private class ExitLst implements ActionListener
	   {
		//if the exit button is clicked...
		   public void actionPerformed(ActionEvent a)
		   {
			   //closes the program
			   System.exit(0);
		   }
	   }
	
	private class CalcLst implements ActionListener
	{
		public void actionPerformed(ActionEvent b)
		{
			//when the CalcBtn is pressed...
			temp = amount.getText();
			try 
			{
				//if the number entered is a negative number yell at the user
				if (Double.parseDouble(temp)<0)
				{
					if(JOptionPane.showConfirmDialog(null, "Sorry you cannot drink negative beer.\n " +
						"No throwing up does not count!\n Did you learn your lesson?",
						"FAIL!!", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE)
						==JOptionPane.YES_OPTION)
					{
						//clear the textfeild
						amount.setText("");
					}
					else
					{
						//if they want to be cocky and not fix their mistake yell at them and...
						JOptionPane.showConfirmDialog(null,"FINE BE THAT WAY!"
								,"GOOD BYE",JOptionPane.PLAIN_MESSAGE);
						//teach them a lesson by closing the program
						System.exit(0);
					}
				}
				//if the number entered is 0 inform the user of their stupidity
				if (Double.parseDouble(temp)==0)
				{
					JOptionPane.showConfirmDialog(null,"Uhh the point of this is to preform a calculation" +
							"\nso why are you entering a 0?"
							,"FAIL!",JOptionPane.PLAIN_MESSAGE);
				}
				//if the number is a positive number
				if (Double.parseDouble(temp)>0)
				{
					//see which function is desired
					if (oz.isSelected()==true)
						//then store the amount of calories in a variable
						ans=((Calories[index]/12)*Double.parseDouble(temp));
					if(cans.isSelected()==true)
						ans=(((Calories[index])*Double.parseDouble(temp)));
					if (pack_6.isSelected()==true)
						ans=(((Calories[index])*6)*Double.parseDouble(temp));
					if (pack_12.isSelected()==true)
						ans=(((Calories[index])*12)*Double.parseDouble(temp));
					if (pack_24.isSelected()==true)
						ans=(((Calories[index])*24)*Double.parseDouble(temp));
					if (pack_30.isSelected()==true)
						ans=(((Calories[index])*30)*Double.parseDouble(temp));
					if (pony.isSelected()==true)
						ans=(((Calories[index]/12)*984)*Double.parseDouble(temp));
					if (keg.isSelected()==true)
						ans=(((Calories[index]/12)*1984)*Double.parseDouble(temp));
					//display the amount of calories in the calories label
					calories.setText((df.format(ans)));
				}
			}
			catch (Exception e)
			{
				//if the user is all sorts of special (not in a good way either)...
				//pass whatever mess they entered to the Search function
				Search(temp);
			}
		}
	}
	
	public void Search(String x)
	{
		counter=0;
		int i=0;
		//check if they entered a letter
		for (i=0;i<51;i++) 
		{
			if (x.contains(alphabet[i])==true)
			{
				//counter only allows it to yell once per error
				if (counter<=0)
				{
					//then yell at them
					JOptionPane.showConfirmDialog(null,"Uhh this isn't algebra..." +
							"DONT use letters!"
							,"FAIL!",JOptionPane.PLAIN_MESSAGE);
					counter++;
				}
			}	
		}
		counter=0;
		//check if they entered a special character		
		for (i=0;i<27;i++)
		{
			if (x.contains(specialChars[i])==true)
			{
				if (counter<=0)
				{
					//then yell at them
					JOptionPane.showConfirmDialog(null,"Next time don't use special characters..."
							+"\nThose are a no-no!","FAIL!",JOptionPane.PLAIN_MESSAGE);	
					counter++;
				}
			}
			
		}
	}
	
	private class Selection implements ActionListener
	{
		//when a different beer is selected in the combobox
		public void actionPerformed(ActionEvent c)
		{
			//see which one was selected
			index = BeerSel.getSelectedIndex();
			//then set calories to 0 and display the ABV value
			calories.setText(Integer.toString(0));
			abv.setText(Double.toString(ABV[index]));
			//depending on the beer enable which sizes they
			//are available in
			if (index==0||index==1||index==3||index==6||index==7)
			{
				pack_6.setEnabled(true);
				pack_12.setEnabled(true);
				pack_24.setEnabled(true);
				pack_30.setEnabled(true);
				pony.setEnabled(true);
				keg.setEnabled(true);
			}
			if (index==2||index==10||index==11||index==14||index==15||
					index==17||index==16||index==13||index==12||index==8)
			{
				pack_6.setEnabled(true);
				pack_12.setEnabled(true);
				pack_24.setEnabled(true);
				pack_30.setEnabled(false);
				pony.setEnabled(true);
				keg.setEnabled(true);
			}
			if (index==4||index==5)
			{
				pack_6.setEnabled(true);
				pack_12.setEnabled(true);
				pack_24.setEnabled(true);
				pack_30.setEnabled(false);
				pony.setEnabled(false);
				keg.setEnabled(false);
			}
			if (index==9)
			{
				pack_6.setEnabled(true);
				pack_12.setEnabled(false);
				pack_24.setEnabled(true);
				pack_30.setEnabled(false);
				pony.setEnabled(false);
				keg.setEnabled(false);
			}
			if (index==18)
			{
				pack_6.setEnabled(true);
				pack_12.setEnabled(true);
				pack_24.setEnabled(false);
				pack_30.setEnabled(true);
				pony.setEnabled(true);
				keg.setEnabled(true);
			}
		}
	}
}
		

	

