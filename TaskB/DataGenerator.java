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

    // Scenario 1
    ScenarioOne oneAdjMat = new ScenarioOne("adjmat");
    ScenarioOne oneIndMat = new ScenarioOne("indmat");
    long averageAddEdgesIndMat = 0;
    long averageAddVerticesIndMat = 0;
    long averageAddEdgesAdjMat = 0;
    long averageAddVerticesAdjMat = 0;

    System.out.println("*** SCENARIO 1 ***");
    for(int i = 1; i <= 10; i++)
    {
      ArrayList<String> lines = util.getLines((rand.nextInt(100)+1));

      // Incidence Matrix
      oneIndMat.runScenarioOne(lines);
      System.out.printf("\t\n---SUBSET %d---\n",i);
      System.out.println("\tType of Matrix: IncidenceMatrix");
      oneIndMat.printData();
      System.out.println("\tAdd Vertices Time taken: " + oneIndMat.getTotalElapsedTimeAddVertices()+"ns.");
      System.out.println("\tAdd Edges Time taken: " + oneIndMat.getTotalElapsedTimeAddEdges()+"ns.");
      averageAddEdgesIndMat += oneIndMat.getTotalElapsedTimeAddEdges();
      averageAddVerticesIndMat += oneIndMat.getTotalElapsedTimeAddVertices();

      // Adjacency Matrix
      oneAdjMat.runScenarioOne(lines);
      System.out.printf("\t\n---SUBSET %d---\n",i);
      System.out.println("\tType of Matrix: Adjacency Matrix");
      oneAdjMat.printData();
      System.out.println("\tAdd Vertices Time taken: " + oneAdjMat.getTotalElapsedTimeAddVertices()+"ns.");
      System.out.println("\tAdd Edges Time taken: " + oneAdjMat.getTotalElapsedTimeAddEdges()+"ns.");
      averageAddEdgesAdjMat += oneAdjMat.getTotalElapsedTimeAddEdges();
      averageAddVerticesAdjMat += oneAdjMat.getTotalElapsedTimeAddVertices();
    }
    System.out.println("Average Time taken for Edges IncidenceMatrix: " +averageAddEdgesIndMat/10+"ns.");
    System.out.println("Average Time taken for Vertices IncidenceMatrix: " +averageAddVerticesIndMat/10+"ns.");
    System.out.println("Average Time taken for Edges AdjacencyMatrix: " +averageAddEdgesAdjMat/10+"ns.");
    System.out.println("Average Time taken for Vertices AdjacencyMatrix: " +averageAddVerticesAdjMat/10+"ns.");


    // Scenario 2
  //   ScenarioTwo twoAdjMat = new ScenarioTwo("adjmat");
  //   ScenarioTwo twoIndMat = new ScenarioTwo("indmat");
  //   long averageNeighboursIndMat = 0;
  //   long averageShortestPathIndMat = 0;
  //   long averageNeighboursAdjMat = 0;
  //   long averageShortestPathAdjMat = 0;

  //   System.out.println("*** SCENARIO 2 ***");
  //   for(int i = 1; i <= 10; i++)
  //   {
  //     ArrayList<String> lines = util.getLines((rand.nextInt(100)+1));

  //     // Incidence Matrix
  //     twoIndMat.runScenarioTwo(lines);
  //     System.out.printf("\t\n---SUBSET %d---\n",i);
  //     System.out.println("\tType of Matrix: IncidenceMatrix");
  //     twoIndMat.printData();
  //     System.out.println("\tNeighbours Time taken: " + twoIndMat.getTotalElapsedTimeNeighbours()+"ns.");
  //     System.out.println("\tShortestPath Time taken: " + twoIndMat.getTotalElapsedTimeShortestPath()+"ns.");
  //     averageNeighboursIndMat += twoIndMat.getTotalElapsedTimeNeighbours();
  //     averageShortestPathIndMat += twoIndMat.getTotalElapsedTimeShortestPath();

  //     // Adjacency Matrix
  //     twoAdjMat.runScenarioTwo(lines);
  //     System.out.printf("\t\n---SUBSET %d---\n",i);
  //     System.out.println("\tType of Matrix: IncidenceMatrix");
  //     twoIndMat.printData();
  //     System.out.println("\tNeighbours Time taken: " + twoAdjMat.getTotalElapsedTimeNeighbours()+"ns.");
  //     System.out.println("\tShortestPath Time taken: " + twoAdjMat.getTotalElapsedTimeShortestPath()+"ns.");
  //     averageNeighboursAdjMat += twoAdjMat.getTotalElapsedTimeNeighbours();
  //     averageShortestPathAdjMat += twoAdjMat.getTotalElapsedTimeShortestPath();
  //   }
  //   System.out.println("Average Time taken for Neighbours IncidenceMatrix: " +averageNeighboursIndMat/10+"ns.");
  //   System.out.println("Average Time taken for ShortestPath IncidenceMatrix: " +averageShortestPathIndMat/10+"ns.");
  //   System.out.println("Average Time taken for Neighbours AdjacencyMatrix: " +averageNeighboursAdjMat/10+"ns.");
  //   System.out.println("Average Time taken for ShortestPath AdjacencyMatrix: " +averageShortestPathAdjMat/10+"ns.");

  //   //Scenario 3
  //   ScenarioThree threeAdjMat = new ScenarioThree("adjmat");
  //   ScenarioThree threeIndMat = new ScenarioThree("indmat");
  //   long averageRemoveEdgesIndMat = 0;
  //   long averageRemoveVerticesIndMat = 0;
  //   long averageRemoveEdgesAdjMat = 0;
  //   long averageRemoveVerticesAdjMat = 0;

  //   System.out.println("*** SCENARIO 3 ***");
  //   for(int i = 1; i <= 10; i++)
  //   {
  //     ArrayList<String> lines = util.getLines((rand.nextInt(100)+1));

  //     // Incidence Matrix
  //     threeIndMat.runScenarioTwo(lines);
  //     System.out.printf("\t\n---SUBSET %d---\n",i);
  //     System.out.println("\tType of Matrix: IncidenceMatrix");
  //     threeIndMat.printData();
  //     System.out.println("\tRemove vertex Time taken: " + threeIndMat.getTotalElapsedTimeRemoveVertex()+"ns.");
  //     System.out.println("\tRemove edge Time taken: " + threeIndMat.getTotalElapsedTimeRemoveEdge()+"ns.");
  //     averageRemoveVerticesIndMat += threeIndMat.getTotalElapsedTimeRemoveVertex();
  //     averageRemoveEdgesIndMat += threeIndMat.getTotalElapsedTimeRemoveEdge();

  //     // Adjacency Matrix
  //     threeAdjMat.runScenarioTwo(lines);
  //     System.out.printf("\t\n---SUBSET %d---\n",i);
  //     System.out.println("\tType of Matrix: IncidenceMatrix");
  //     threeAdjMat.printData();
  //     System.out.println("\tRemove vertex Time taken: " + threeAdjMat.getTotalElapsedTimeRemoveVertex()+"ns.");
  //     System.out.println("\tRemove edge Time taken: " + threeAdjMat.getTotalElapsedTimeRemoveEdge()+"ns.");
  //     averageRemoveVerticesAdjMat += threeAdjMat.getTotalElapsedTimeRemoveVertex();
  //     averageRemoveEdgesAdjMat += threeAdjMat.getTotalElapsedTimeRemoveEdge();
  //   }
  //   System.out.println("Average Time taken for Remove Vertex IncidenceMatrix: " +averageRemoveVerticesIndMat/10+"ns.");
  //   System.out.println("Average Time taken for Remove Edge IncidenceMatrix: " +averageRemoveEdgesIndMat/10+"ns.");
  //   System.out.println("Average Time taken for Remove Vertex AdjacencyMatrix: " +averageRemoveVerticesAdjMat/10+"ns.");
  //   System.out.println("Average Time taken for Remove Edge AdjacencyMatrix: " +averageRemoveEdgesAdjMat/10+"ns.");
  // }

}


