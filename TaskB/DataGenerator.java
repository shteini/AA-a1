import java.io.*;
import java.util.*;

public class DataGenerator 
{
	int MAX_NUMBER = 88235;


	//if that random number is bigger than zero and less than facebook data - random lines number

	public static void main(String[] args) {

		Tester t = new Tester();

		ArrayList<String> data = t.getLines(500);
		for(String line: data)
		{
			System.out.println(line);
		}
	}






}


