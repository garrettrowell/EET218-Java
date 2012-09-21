
import java.io.*;

public class Lab7 
{
	/**
	 * Name: Garrett Rowell
	 * Date: Mar 15, 2012
	 * Class: EET 218
	 * Description: Reads in a data file which contains students grades.
	 * 				Then calculates semester averages, determines the students
	 * 				final letter grade, and sorts the semester averages from
	 * 				least to greatest. Finally it writes out a separate data file 
	 * 				that shows the students ID number, semester average, and
	 * 				letter grade in their sorted order.
	 */
	//holds the students information from in file
	int ID,LAB,QUIZ, FINAL;
	//holds the students semester average
	double SemAVG;
	//holds the students letter grade
	String letterGrade;
	//Temporarily holds the students letter grade while sorting 
	static String temp_Letter;
	//Temporarily holds the students information while sorting 
	static int[] temp_Vals = new int[5];
	
	 public static void main(String[] args) 
	    {
		 //sets up the array to hold the students information
		Lab7 CLASS[] = new Lab7[11];
		//allows the class "grades" to be used
		grades Gradecalc = new grades();
		//used as counters at various times
		int i,j,k = 0,counter=0;
		//allows the bubble sort to stop
		boolean is_running=true;
		//makes the arrays as large as the amount of lines in the in file
		for(i=0;i<CLASS.length;i++)
			CLASS[i]= new Lab7();		
		//defines the in file
		File inFile = new File("Lab6.Dat");
		//defines the out file
		File outFile = new File("Lab_6.out");
		//used to hold a line of data from the in file
		String getLine="";
		//used to temporarily store the parsed data read in
		String result[];
		//if there is an error the program displays the error
		try
		{
			//allows the program to read in and write out
			FileInputStream inStream = new FileInputStream(inFile);
			FileOutputStream outStream = new FileOutputStream(outFile);
			BufferedReader buffRead = new BufferedReader(new InputStreamReader(inStream));
			BufferedWriter buffWrite = new BufferedWriter(new OutputStreamWriter(outStream));
			//reads the in file until the end
			while((getLine=buffRead.readLine()) !=null)
			{
				//parsed the data at every occurrence of a comma
				result= getLine.split("\\,");
				//stores the parsed data into its given array address
				CLASS[counter].ID=Integer.parseInt(result[0]);
				CLASS[counter].LAB=Integer.parseInt(result[1]);
				CLASS[counter].QUIZ=Integer.parseInt(result[2]);
				CLASS[counter].FINAL=Integer.parseInt(result[3]);
				//stores the calculated data into its given array address
				CLASS[counter].SemAVG=Gradecalc.calcWeight(CLASS[counter].LAB,CLASS[counter].QUIZ,CLASS[counter].FINAL);
				CLASS[counter].letterGrade=Gradecalc.letterAssign(CLASS[counter].SemAVG);
				//used to make sure each line goes in its right spot in the array
				counter++;
			}
			System.out.println("[FILE READ IN] -> SUCCESS!");
			//bubble sort
			while(is_running)
			{
				is_running=false;
				k++;
				//Analyzes every line in the CLASS arrays 
				for(j=0;j<CLASS.length-k;j++)
				{
					//compares two semester averages to see which is larger
					if(CLASS[j].SemAVG>CLASS[j+1].SemAVG)
					{
						temp_Vals[0]=CLASS[j].ID;
						temp_Vals[1]=CLASS[j].LAB;
						temp_Vals[2]=CLASS[j].QUIZ;
						temp_Vals[3]=CLASS[j].FINAL;
						temp_Vals[4]=(int) CLASS[j].SemAVG;
						temp_Letter=CLASS[j].letterGrade;
						CLASS[j].ID=CLASS[j+1].ID;
						CLASS[j].LAB=CLASS[j+1].LAB;
						CLASS[j].QUIZ=CLASS[j+1].QUIZ;
						CLASS[j].FINAL=CLASS[j+1].FINAL;
						CLASS[j].SemAVG=CLASS[j+1].SemAVG;
						CLASS[j].letterGrade=CLASS[j+1].letterGrade;
						CLASS[j+1].ID=temp_Vals[0];
						CLASS[j+1].LAB=temp_Vals[1];
						CLASS[j+1].QUIZ=temp_Vals[2];
						CLASS[j+1].FINAL=temp_Vals[3];
						CLASS[j+1].SemAVG=temp_Vals[4];
						CLASS[j+1].letterGrade=temp_Letter;
						is_running=true;
					}
				}
			}
			System.out.println("[GRADE SORT] -> SUCCESS!");
			//writes the header of the out file
			buffWrite.write("Student ID->Semester Average->Letter Grade"+"\r\n");
			buffWrite.write("Semester Averages Least to Greatest"+"\r\n");
			buffWrite.write(""+"\r\n");
			//writes all of the desired data to the out file
			for(i=0;i<counter;i++)
				buffWrite.write(CLASS[i].ID+","+CLASS[i].SemAVG+","+CLASS[i].letterGrade+"\r\n");
			//closes the read and write
			buffRead.close();
			buffWrite.close();	
			System.out.println("[FILE WRITE OUT] -> SUCCESS!");
			System.out.println("[JOB] -> COMPLETE");
		}
		//if an error occurs display the error message
		catch (Exception e)
			{
			System.out.println("Error" + e.getMessage());
			}
	   }
}

class grades
{
//determines the students letter grade
String letterAssign(double  t)
	{
		if (t>=90)
			return("A");
		if (t<90&&t>=80)
			return("B");
		if (t<80&&t>=70)
			return("C");
		if (t<70&&t>=60)
			return("D");
		else 
			return("F");
	}
//calculates the students semester average
double calcWeight (int Lab, int Quiz,int Final )
	{
	double semesterGrade;
	double labWE = Lab * 0.4;
	double quizWE = Quiz * 0.35;
	double finalWE = Final * 0.25;
	semesterGrade = (labWE+quizWE+finalWE);
	return (semesterGrade);
	}
}

