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
			String fileName = "../testing/facebook_combined.txt";
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			int counter = 0;
			while ( (line = br.readLine()) != null)
			{
        if(counter == linesToRead) {
          break; }
        lines.add(line);
        counter++;
			}
		} catch (IOException ex)
		{
		   System.exit(1);
		}
		return lines;
	}
}



