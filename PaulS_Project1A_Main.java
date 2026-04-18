
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PaulS_Project1A_Main 
{
	public static int countData(String filename, BufferedWriter logFile) throws IOException
	{
		logFile.write("Entering countData()\n");
		int count = 0;
		Scanner scanner = new Scanner(new FileReader(filename));
		while(scanner.hasNextInt())
		{
			scanner.nextInt();
			count++;
		}
		scanner.close();
		logFile.write("Exiting countData(), count = " + count + "\n");
		return count;
	}    

	public static void loadData(String filename, int[] dataArray, int count, BufferedWriter logFile) throws IOException
	{
		logFile.write("Entering loadData()\n");
		int index = 0;
		Scanner scanner = new Scanner(new FileReader(filename));
		while(scanner.hasNextInt() && index < count)
		{
			dataArray[index] = scanner.nextInt();//store data in array
			index++;//increment index
		}
		scanner.close();
		logFile.write("Exiting loadData()\n");
	}

	public static void printData(int[] dataArray, BufferedWriter outFile) throws IOException
	{
		for(int i = 0; i < dataArray.length; i++)
		{
			outFile.write(i + "\t" + dataArray[i] + "\n");
		}
	}
	public static void main(String[] args) throws IOException 
	{
		if(args.length != 3)
		{
			System.out.println("Program needs 3 arguments");
			System.exit(1);
		}
		BufferedWriter outFile = null;
		BufferedWriter logFile = null;
		try
		{
			outFile = new BufferedWriter(new FileWriter(args[1]));
			System.out.println("outFile opened successfully");
		}
		catch(IOException e)
		{
			System.out.println("outFile cannot be opened");
		}
		try
		{
			logFile = new BufferedWriter(new FileWriter(args[2]));
			System.out.println("logFile opened successfully");
		}
		catch(IOException e)
		{
			System.out.println("logFile cannot be opened");
		}
		int count = countData(args[0], logFile);
		logFile.write("In main(), count = " + count + "\n");
		int[] dataArray = new int[count];
		loadData(args[0], dataArray, count, logFile);
		outFile.write("** The content of array **\n");
		outFile.write("Index\tdata\n");
		outFile.write("=========\n");


		printData(dataArray, outFile);

		outFile.close();
		logFile.close();

	}
}



