import java.io.*;
import java.util.*;

public class Utility {

	public ArrayList<String> getLines(int linesToRead) {

		ArrayList<String> lines = new ArrayList<String>();
		try{
		
		//generate another randomLines as starting point
		//if that random number is bigger than zero and less than facebook data - linesToRead
		//read in from file and return a string with all the lines in this string
		String fileName = "../testing/facebook_combined.txt";
		RandomAccessFile raf = new RandomAccessFile(fileName, "r");
		raf.seek(0);
		String line;
		int counter = 0;


		while ((line = raf.readLine()) != null && counter < linesToRead) {


			lines.add(line);
			counter++;

		}

		return lines;

	} catch (IOException ex)
		{
         ex.printStackTrace();
         return lines;
		}
 }

}



