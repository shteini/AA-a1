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



  public static void main(String[] args)
  {

    // randomly generate one number = number of lines you are getting from facebook. Create chunk of data with this amount of lines, run everything and calculate time then return then run this method 10 times.
    ScenarioOne oneAdjMat = new ScenarioOne("adjmat");
    ScenarioOne oneIndMat = new ScenarioOne("indmat");

    for(int i = 0; i < 10; i++)
    {

    }


    // Now get random number to determine where to start in the file randomly 10 different sets
    // if that random number is bigger than zero and less than facebook data - random lines number
    //
    // For each scenario get a random amount of lines from facebook.txt and generate use RandomAccessFile
    //print the time taken for scenario to complete
  }

}


