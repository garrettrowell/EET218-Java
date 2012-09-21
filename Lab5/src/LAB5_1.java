import java.io.*;
public class LAB5_1
{	
	//variables to store students info
	int ID,LAB,QUIZ,FINAL;
	
	public static void main(String[] args) 
{
	//creates an array to store student data
	LAB5_1 CLASS[] = new LAB5_1[11];
	
	//basic counter and [i] is place in the array 
	int i,counter=0;
	
	//creates new columns for the array
	for(i=0;i<CLASS.length;i++)
		CLASS[i]= new LAB5_1();
	
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
			
			//prints each out onto separate lines
			System.out.println(CLASS[counter].ID);
			System.out.println(CLASS[counter].LAB);
			System.out.println(CLASS[counter].QUIZ);
			System.out.println(CLASS[counter].FINAL);
			
			//Yay Counters...
			counter++;
		
		}
		
		//writes the data to the output file
		buffWrite.write("Student ID -> Lab Grade -> Quiz Grade -> Final Grade"+"\r\n");
		buffWrite.write(""+"\r\n");
		buffWrite.write("Original Numbers"+"\r\n");
				
		//writes the original data
		for(i=0;i<counter;i++)
			buffWrite.write(CLASS[i].ID+","+CLASS[i].LAB+","+CLASS[i].QUIZ+","
					+CLASS[i].FINAL+"\r\n");
		
		buffWrite.write(""+"\r\n");
		buffWrite.write("Multiplied by 5"+"\r\n");
		
		//multiplies each number by 5 and writes it out
		for(i=0;i<counter;i++)
			buffWrite.write(CLASS[i].ID*5+","+CLASS[i].LAB*5+","+CLASS[i].QUIZ*5+","
					+CLASS[i].FINAL*5+"\r\n");
		
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
