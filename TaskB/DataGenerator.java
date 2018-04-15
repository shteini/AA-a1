import java.io.*;
import java.util.*;

public class DataGenerator
{

  public static void main(String[] args)
  {
    int MAX_NUMBER_LINES = 88234;
    Utility util = new Utility();
    // randomly generate one number = number of lines you are getting from facebook. Create chunk of data with this amount of lines, run everything and calculate time then return then run this method 10 times.
    Random rand = new Random();

    ScenarioOne oneAdjMat = new ScenarioOne("adjmat");
    ScenarioOne oneIndMat = new ScenarioOne("indmat");
    long averageAddEdges = 0;
    long averageAddVertices = 0;

    System.out.println("*** SCENARIO 1 ***");
    for(int i = 1; i <= 10; i++)
    {
      ArrayList<String> lines = util.getLines((rand.nextInt(100)+1));

      oneIndMat.runScenarioOne(lines);
      System.out.printf("\n---SUBSET %d---\n",i);
      System.out.println("Type of Matrix: IncidenceMatrix");
      oneIndMat.printData();
      System.out.println("Add Vertices Time taken: " + oneIndMat.getTotalElapsedTimeAddVertices()+"ms.");
      System.out.println("Add Edges Time taken: " + oneIndMat.getTotalElapsedTimeAddEdges()+"ms.");
      averageAddEdges += oneIndMat.getTotalElapsedTimeAddEdges();
      averageAddVertices += oneIndMat.getTotalElapsedTimeAddVertices();
    }
    System.out.println("Average Time taken for Edges: " +averageAddEdges/10+"ms.");
    System.out.println("Average Time taken for Vertices: " +averageAddVertices/10+"ms.");

      // oneAdjMat.runScenarioOne(lines);
      // System.out.println("\n---SUBSET "+i+"---");
      // System.out.println("Type of Matrix: AdjacencyMatrix");
      // oneAdjMat.printData();
      // System.out.println("Add Vertices Time taken: " + oneAdjMat.getTotalElapsedTimeAddVertices()+"ms.");
      // System.out.println("Add Edges Time taken: " + oneAdjMat.getTotalElapsedTimeAddEdges()+"ms.");
      // subset i adjmat number edges, number vertexs, graph density,
      // time it took to run the add vertex's and add edges



    // Now get random number to determine where to start in the file randomly 10 different sets
    // if that random number is bigger than zero and less than facebook data - random lines number
    //
    // For each scenario get a random amount of lines from facebook.txt and generate use RandomAccessFile
    //print the time taken for scenario to complete
  }

}


