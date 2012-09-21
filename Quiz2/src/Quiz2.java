
import java.io.*;

public class Quiz2 {
	/**
	 * Name: Garrett Rowell
	 * Date: Mar 21, 2012
	 * Class: EET 218
	 * Description: Reads in a data file that contains students id's, gpa, and class rank
	 * 				and determines weather or not they are an honors student and assigns their class
	 * 				code. After this sorts the data by the students gpa and writes an out file
	 */
	//variables for the CLASS array
	int id,rank;
	double gpa;
	String honors="", classCode="";
	//arrays to store data temporarily for the bubble sort
	static double tempD[]=new double[1];
	static String tempS[]=new String[2];
	static int tempI[]=new int[2];
	
	 public static void main(String[] args) 
	    {
		 //calls in the various classes
		 GPA Honors = new GPA();
		 Rank classRank = new Rank();
		 Quiz2 CLASS[] = new Quiz2[21];
		 
		 int i,j,k = 0,counter=0;
		 for(i=0;i<CLASS.length;i++)
			 CLASS[i]= new Quiz2();
		 //gets in and out files
		 File inFile = new File("quiz2.txt");
		 File outFile = new File("garrett.txt");
		 //gets the in and out files from command line
		 //File inFile = new File(args[0]);
		 //File outFile = new File(args[1]);
		 String getLine="";
		 String result[];
		 boolean is_running=true;
		 try
			{
			//reads in the data file	
			 	FileInputStream inStream = new FileInputStream(inFile);
				FileOutputStream outStream = new FileOutputStream(outFile);
				BufferedReader buffRead = new BufferedReader(new InputStreamReader(inStream));
				BufferedWriter buffWrite = new BufferedWriter(new OutputStreamWriter(outStream));
				//skips the header in the data file assuming its only two lines
				buffRead.readLine();
				buffRead.readLine();
				//reads the data file till theres no more data
				while((getLine=buffRead.readLine()) !=null)
				{
					//grabs data at every comma and stores it in the CLASS array
					result= getLine.split("\\,");
					CLASS[counter].id=Integer.parseInt(result[0]);
					CLASS[counter].gpa=Double.parseDouble(result[1]);
					CLASS[counter].rank=Integer.parseInt(result[2]);
					CLASS[counter].honors=Honors.HNRS(CLASS[counter].gpa);
					CLASS[counter].classCode=classRank.cRank(CLASS[counter].rank);
					counter++;
				}
				//bubble sort
				//yes i know its sloppy but it works
				while(is_running)
				{
					is_running=false;
					k++;
					//Analyzes every line in the CLASS arrays 
					for(j=0;j<CLASS.length-k;j++)
					{
						//compares two gpa's to see which is larger
						if(CLASS[j].gpa>CLASS[j+1].gpa)
						{
							tempI[0]=CLASS[j].id;
							tempD[0]=CLASS[j].gpa;
							tempI[1]=CLASS[j].rank;
							tempS[0]=CLASS[j].honors;
							tempS[1]=CLASS[j].classCode;
							CLASS[j].id=CLASS[j+1].id;
							CLASS[j].gpa=CLASS[j+1].gpa;
							CLASS[j].rank=CLASS[j+1].rank;
							CLASS[j].honors=CLASS[j+1].honors;
							CLASS[j].classCode=CLASS[j+1].classCode;
							CLASS[j+1].id=tempI[0];
							CLASS[j+1].gpa=tempD[0];
							CLASS[j+1].rank=tempI[1];
							CLASS[j+1].honors=tempS[0];
							CLASS[j+1].classCode=tempS[1];
							is_running=true;
						}
					}
				}
				//writes out data
				buffWrite.write("ID->GPA->RANK->HONORS->CLASS CODE"+"\r\n");
				for(i=0;i<counter;i++)
					buffWrite.write(CLASS[i].id+","+CLASS[i].gpa+","+CLASS[i].rank+","+
							CLASS[i].honors+","+CLASS[i].classCode+"\r\n");
				//closes the read and write streams
				buffRead.close();
				buffWrite.close();
	    }
		 //if an error occurs return the error number
		 catch (Exception e)
			{
			System.out.println("Error" + e.getMessage());
			}
	    }
}

class GPA
{
	//checks the students gpa to determine weather or not they 
	//are an honors student
	String HNRS(double x)
	{
		if (x>=3.0)
			return ("H");
		else
			return("N");
	}
}

class Rank
{
	//determines weather the student is in middle school, lower or upper class
	//depending on their class rank
	String cRank(int x)
	{
		if (x<=8)
			return("M");
		if (x>=9&&x<=10)
			return("L");
		else
			return("U");
	}
	
}
