import java.io.*;
import java.util.*;

public class DataGenerator
{
  int MAX_NUMBER_LINES = 88235;
  public static void main(String[] args)
  {

    // randomly generate one number = number of lines you are getting from facebook. Create chunk of data with this amount of lines, run everything and calculate time then return then run this method 10 times.
    Random rand = new Random();


    ArrayList<String> lines = Utility.getLines((rand.nextInt(MAX_NUMBER_LINES)+1));
    ScenarioOne oneAdjMat = new ScenarioOne("adjmat");
    ScenarioOne oneIndMat = new ScenarioOne("indmat");

    for(int i = 0; i < 10; i++)
    {
      oneAdjMat.runScenarioOne(lines);
      //subset i adjmat number edges, number vertexs, graph density, time it took to run the add vertex's and add edges

    }

    for(int i = 0; i < 10; i++)
    {
      oneIndMat.runScenarioOne()
    }

    // Now get random number to determine where to start in the file randomly 10 different sets
    // if that random number is bigger than zero and less than facebook data - random lines number
    //
    // For each scenario get a random amount of lines from facebook.txt and generate use RandomAccessFile
    //print the time taken for scenario to complete
  }

}


