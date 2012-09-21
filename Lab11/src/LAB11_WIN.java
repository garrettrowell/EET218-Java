import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class LAB11_WIN extends JFrame
{
	/**
	 * Name: Garrett Rowell
	 * Date: Apr,4 2012
	 * Class: EET 218
	 * Description: Generates a random password. User selects 
	 * 				weather to use upper case, lower case, or a
	 * 				combination of both in their password.
	 */
	//various character lists
	public static String alphabet[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
		"o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N",
		"O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	public static String specialChars[]={"!","@","#","$","%","^","&","*"};
	public static String numbers[]={"0","1","2","3","4","5","6","7","8","9"};
	//stores each element of the final password
	public static String pass[]= new String[9];
	//creates various swing components
	private JPanel pnl;
	private JButton GenBtn,exitBtn;
	private JCheckBox lowerCB,upperCB;
	private JLabel passlbl;
	//sets window dimensions
	private final int WINDOW_WIDTH = 320;
	private final int WINDOW_HEIGHT = 200;
	//stores the generated random number
	static int val=0;
	//stores the final password as one string
	static String finalpass="";
		
	public LAB11_WIN()
	{
		//names the frame
		super("Random Password Generator");
		//sets the frame size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		//allows the program to close using the x in the corner
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//creates an instance of the buildPanel void
		//ie. it executes that portion of code
		buildPanel();
		//adds pnl to our frame
		add(pnl);
		//allows the frame to be seen
		setVisible(true);	
	}
	public void buildPanel()
	{
		//defines the various swing components
		lowerCB = new JCheckBox("Use lower case ABC's");
		upperCB = new JCheckBox("Use upper case ABC's");
		GenBtn = new JButton("Generate Password");
		exitBtn = new JButton("EXIT");
		passlbl = new JLabel("");
		pnl = new JPanel();
		//adds the components to the panel
		pnl.add(lowerCB);
		pnl.add(upperCB);
		pnl.add(GenBtn);
		pnl.add(exitBtn);
		pnl.add(passlbl);
		//creates the listeners
		GenBtn.addActionListener(new GenLst());
		exitBtn.addActionListener(new exitLst());
	}
	private class exitLst implements ActionListener
	   {
		//if the exit button is clicked...
		   public void actionPerformed(ActionEvent a)
		   {
			   //closes the program
			   System.exit(0);
		   }
	   }
	private class GenLst implements ActionListener
	   {
		//when the generate button is clicked...
		   public void actionPerformed(ActionEvent c)
		   {
			   //clears the finalpass string 
			   finalpass="";
			   //gets lower case letters ONLY
			   if (lowerCB.isSelected()==true)
			   {
				   //grabs 5 letters
				   for (int i=0; i<=4;i++)
					{
					   //gets a random number
						Random rnd1 = new Random();
						val=rnd1.nextInt(25);
						//and stores it in the array
						pass[i]=alphabet[val];
					}
			   }
			   //gets upper case letters ONLY
			   if(upperCB.isSelected()==true)
			   {
				   //grabs 5 letters
				   for (int i=0; i<=4;i++)
					{
					    //gets a random number
						Random rnd1 = new Random();
						val=rnd1.nextInt(25);
						//and stores it in the array
						pass[i]=alphabet[val+26];
					}
			   }
			   //gets both upper and lower case letters
			   if (lowerCB.isSelected()==true && upperCB.isSelected()==true)
			   {
				   //grabs 5 letters
				   for (int i=0; i<=4;i++)
					{
					    //gets a random number
						Random rnd1 = new Random();
						val=rnd1.nextInt(52);
						//and stores it in the array
						pass[i]=alphabet[val];
					}
			   }
			   //if neither checkbox is selected...
			   if (lowerCB.isSelected()==false && upperCB.isSelected()==false)
			   {
				   //clears the password label
				   passlbl.setText("");
			   }
			   //grabs 2 special characters
			   for (int i=5;i<=6;i++)
				{
				    //gets a random number
					Random rnd1 = new Random();
					val=rnd1.nextInt(8);
					//and stores it in the array
					pass[i]=specialChars[val];
				}
			   for (int i=7;i<=8;i++)
				{
				    //gets a random number
					Random rnd1 = new Random();
					val=rnd1.nextInt(10);
					//and stores it in the array
					pass[i]=numbers[val];
				}
			   //randomizes the array that stores the generated password
			   Collections.shuffle(Arrays.asList(pass));
			   
			   for (int i=0;i<=8;i++)
				{
				    //stores every character in the password array
				    //in one string
					finalpass=(finalpass+pass[i]);
				}
			   //displays the generated password in a label
			   passlbl.setText(finalpass);
			   
		   }
	   }
}
