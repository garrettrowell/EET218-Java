import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz_3 extends JFrame
{
	/**
	 * Name: Garrett Rowell
	 * Date: Apr,18 2012
	 * Class: EET 218
	 * 
	 * I GARRETT ROWELL PINKIE PROMISE THAT I DID NOT CONSULT WITH ANY 
	 * OTHER STUDENT... EVEN JOSH WHILE CODING THIS PROJECT
	 * 
	 * Description: Allow a user to register for a conference.
	 * 				User either can select professional or student then selects
	 * 				various additional workshops to attend
	 */
	//defines all the variables
	private JPanel mainpnl,regi,extra,totalS,btns;
	private JButton CalcBtn,ExitBtn;
	private JRadioButton Pro,Stu;
	private JCheckBox speaker,intro,web,java,network;
	private JLabel ans,lbl1,lbl2,lbl3,blank;
	private final int WINDOW_WIDTH = 450;
	private final int WINDOW_HEIGHT = 500;
	int total=0;
	String reciept="Your Order Summary:";
	
	public static void main(String[] args) 
    {
		//calls Quiz_3 class to run
		Quiz_3 draw = new Quiz_3();
    }
	
	public Quiz_3()
	{
		//names the frame
		super("Conference Registration");
		//sets the frames size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		//allows it to be closed by clicking the "x"
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//calls buildpanel class
		buildPanel();
		//adds mainpnl to the frame
		add(mainpnl);
		//allows the frame to be visible
		setVisible(true);	
	}
	
	public void buildPanel()
	{
		//declares all the diferent swing components
		mainpnl = new JPanel();
		regi = new JPanel();
		extra = new JPanel();
		totalS = new JPanel();
		btns = new JPanel();
		blank = new JLabel("");
		Pro = new JRadioButton("Professional - $895",true);
		Stu = new JRadioButton("Student - $495");
		lbl1 = new JLabel("Optional:");
		speaker = new JCheckBox("Keynote speaker - $30");
		lbl2 = new JLabel("Avaliable Workshops:");
		intro = new JCheckBox("Intro to Ecommerce - $295");
		web = new JCheckBox("Web Future - $295");
		java = new JCheckBox("Advanced Java - $395");
		network = new JCheckBox("Network Security - $395");
		lbl3 = new JLabel("Total: $");
		ans = new JLabel("");
		ExitBtn = new JButton("EXIT");
		CalcBtn = new JButton("Calculate");
		//creates button group
		ButtonGroup RdbGrp = new ButtonGroup();
		//adds radio buttons to button group
		RdbGrp.add(Pro);
		RdbGrp.add(Stu);
		//sets grid layouts
		mainpnl.setLayout(new GridLayout (3,0));
		regi.setLayout(new GridLayout (0,2));
		extra.setLayout(new GridLayout (9,0));
		//adds components to appropriate panels
		regi.add(Pro);
		regi.add(Stu);
		mainpnl.add(regi);
		extra.add(lbl1);
		extra.add(speaker);
		extra.add(blank);
		extra.add(lbl2);
		extra.add(intro);
		extra.add(web);
		extra.add(java);
		extra.add(network);
		totalS.add(lbl3);
		totalS.add(ans);
		extra.add(totalS);
		mainpnl.add(extra);
		btns.add(CalcBtn);
		btns.add(ExitBtn);
		mainpnl.add(btns);
		//creates action listeners
		CalcBtn.addActionListener(new CalcLst());
		ExitBtn.addActionListener(new ExitLst());
		
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
			total=0;
			//looks to see which radiobuttons and
			//checkboxes are selected
			if (Pro.isSelected()==true)
			{
				//adds the price 
				total=total + 895;
				//adds the component to the reciept
				reciept = reciept+"\nProfessional - $895";
			}
			if (Stu.isSelected()==true)
			{
				total=total + 495;
				reciept = reciept+"\nStudent - $495";
			}
			if (speaker.isSelected()==true)
			{
				total=total + 30;
				reciept = reciept+"\nKeynote speaker - $30";
			}
			if (intro.isSelected()==true)
			{
				total=total + 295;
				reciept = reciept+"\nIntro to Ecommerce - $295";
			}
			if (web.isSelected()==true)
			{
				total=total+295;
				reciept = reciept+"\nWeb Future - $295";
			}
			if (java.isSelected()==true)
			{
				total=total+395;
				reciept = reciept+"\nAdvanced Java - $395";
			}
			if (network.isSelected()==true)
			{
				total=total+395;
				reciept = reciept+"\nNetwork Security - $395";
			}
			reciept = reciept+"\nTotal: $"+total;
			//shows the users total in the ans label
			ans.setText(Integer.toString(total));
			//prints out the reciept
			System.out.print(reciept);
		}
	}
}
