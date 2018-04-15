import java.io.*;
import java.util.*;

public class Utility
{

	int MAX_NUMBER_LINES = 88234;
	public ArrayList<String> getLines(int linesToRead)
	{
		ArrayList<String> lines = new ArrayList<String>();
		try
		{
			//generate another randomLines as starting point
			//if that random number is bigger than zero and less than facebook data - linesToRead
			//read in from file and return a string with all the lines in this string
			Random r = new Random();
			int maxStartPosition = MAX_NUMBER_LINES - linesToRead;
			int startPosition = (r.nextInt(maxStartPosition) + 1);
			String fileName = "../testing/facebook_combined.txt";
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			int counter = 0;
			line = br.readLine();
			while ((line != null && counter < linesToRead))
			{
				lines.add(line);
				counter++;
				line = br.readLine();
			}
		} catch (IOException ex)
		{
		   System.exit(1);
		}
		return lines;
	}
}



