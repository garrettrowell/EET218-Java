import java.io.*;

public class LAB6
{	
	//variables to store students info
	int ID,LAB,QUIZ,FINAL;
	//array to temporarily store values so bubble sort can happen
	static int[] temp_Vals = new int[4];
	
	public static void main(String[] args) 
{
	//creates an array to store student data
	LAB6 CLASS[] = new LAB6[11];
	
	//basic counter and [i] is place in the array 
	int i,j,k = 0,counter=0;
	boolean is_running=true;
	
	//creates new columns for the array
	for(i=0;i<CLASS.length;i++)
		CLASS[i]= new LAB6();
	
	//defines the input file
	File inFile = new File("Lab6.Dat");
	//to use command line to input data comment the previous line
	//and uncomment the following
	//File inFile = new File(args[0]);
	
	//defines the desired out file
	File outFile = new File("Lab_6.out");
	//to use command line to output data comment the previous line 
	//and uncomment the following
	//File outFile = new File(args[1]);
	
	//creates a variable to store data as it gets read in
	String getLine="";
	
	//array to store the parsed data
	String result[];
	
	//try statement keeps the program from crashing if 
	//a problem occurs in file read in
	try
	{
		//makes it possible for the program to read & write data
		FileInputStream inStream = new FileInputStream(inFile);
		FileOutputStream outStream = new FileOutputStream(outFile);
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(inStream));
		BufferedWriter buffWrite = new BufferedWriter(new OutputStreamWriter(outStream));
		
		//reads the data file until the end
		while((getLine=buffRead.readLine()) !=null)
		{
			//parses each line when a comma occurs
			result= getLine.split("\\,");
			
			//the first number is the students ID#
			CLASS[counter].ID=Integer.parseInt(result[0]);
			
			//second number is students lab grade
			CLASS[counter].LAB=Integer.parseInt(result[1]);
			
			//third number is students quiz grade
			CLASS[counter].QUIZ=Integer.parseInt(result[2]);
		
			//fourth number is students final grade
			CLASS[counter].FINAL=Integer.parseInt(result[3]);
			
			//prints each student on one line
			System.out.print(CLASS[counter].ID+",");
			System.out.print(CLASS[counter].LAB+",");
			System.out.print(CLASS[counter].QUIZ+",");
			System.out.print(CLASS[counter].FINAL+"\n");
			
			//Yay Counters...
			counter++;
		
		}
		//performs bubble sort
		while(is_running)
		{
			is_running=false;
			k++;
			for(j=0;j<CLASS.length-k;j++)
			{
				if(CLASS[j].FINAL>CLASS[j+1].FINAL)
				{
					temp_Vals[0]=CLASS[j].ID;
					temp_Vals[1]=CLASS[j].LAB;
					temp_Vals[2]=CLASS[j].QUIZ;
					temp_Vals[3]=CLASS[j].FINAL;
					CLASS[j].ID=CLASS[j+1].ID;
					CLASS[j].LAB=CLASS[j+1].LAB;
					CLASS[j].QUIZ=CLASS[j+1].QUIZ;
					CLASS[j].FINAL=CLASS[j+1].FINAL;
					CLASS[j+1].ID=temp_Vals[0];
					CLASS[j+1].LAB=temp_Vals[1];
					CLASS[j+1].QUIZ=temp_Vals[2];
					CLASS[j+1].FINAL=temp_Vals[3];
					is_running=true;
				}
			}
			
		}
		
		System.out.println("\n"+"Sorted Final Grades from Least to Greatest");
		
		for (i=0;i<CLASS.length;i++)
		{
			//prints each student on one line
			System.out.print(CLASS[i].ID+",");
			System.out.print(CLASS[i].LAB+",");
			System.out.print(CLASS[i].QUIZ+",");
			System.out.print(CLASS[i].FINAL+"\n");
		}
		
		//writes the data to the output file
		buffWrite.write("Student ID -> Lab Grade -> Quiz Grade -> Final Grade"+"\r\n");
		buffWrite.write("Final Grades Least to Greatest"+"\r\n");
		buffWrite.write(""+"\r\n");
		
		//writes the original data
		for(i=0;i<counter;i++)
			buffWrite.write(CLASS[i].ID+","+CLASS[i].LAB+","+CLASS[i].QUIZ+","
					+CLASS[i].FINAL+"\r\n");
						
		//closes the reader
		buffRead.close();
		//closes the writer
		buffWrite.close();
					
	}
	//if a file read error occurs print the error for the user to read
	catch (Exception e)
		{
		System.out.println("Error" + e.getMessage());
		}
		
}

}
