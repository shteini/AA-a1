import java.io.*;
import java.util.*;

public class DataGenerator
{
  public static void main(String[] args)
  {
    // int MAX_NUMBER_LINES = 88234;

    Utility util = new Utility();
    // randomly generate one number = number of lines you are getting from facebook. Create chunk of data with this amount of lines, run everything and calculate time then return then run this method 10 times.
    Random rand = new Random();

    // Scenario 1

    long averageAddEdgesIndMat = 0;
    long averageAddVerticesIndMat = 0;
    long averageAddEdgesAdjMat = 0;
    long averageAddVerticesAdjMat = 0;

    // long averageGrowingAddEdgesIndMat = 0;
    // long averageGrowingAddVerticesIndMat = 0;
    // long averageGrowingAddEdgesAdjMat = 0;
    // long averageGrowingAddVerticesAdjMat = 0;

    System.out.println("*** SCENARIO 1 ***");
    for(int i = 1; i <= 10; i++)
    {
      ScenarioOne oneAdjMat = new ScenarioOne("adjmat");
      ScenarioOne oneIndMat = new ScenarioOne("indmat");
      int amountOfLines = rand.nextInt(250)+1;
      System.out.printf("\n\nAmount Of Lines: %d", amountOfLines);
      ArrayList<String> lines = util.getLines(amountOfLines);

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



    //    Growing graph NOT WORKING
    //   ScenarioOne oneGrowIndMat = new ScenarioOne("indmat");
    //   // Incidence Matrix
    //   oneGrowIndMat.runScenarioOneIncreasedDensity(lines);
    //   System.out.printf("\t\n---SUBSET %d---\n",i);
    //   System.out.println("\tType of Matrix: IncidenceMatrix Increased Density");
    //   oneGrowIndMat.printData();
    //   // System.out.println("\tAdd Vertices Time taken Growing Graph: " + oneGrowIndMat.getTotalElapsedTimeAddVertices()+"ns.");
    //   // System.out.println("\tAdd Edges Time taken Growing Graph: " + oneGrowIndMat.getTotalElapsedTimeAddEdges()+"ns.");
    //   // averageGrowingAddEdgesIndMat += oneGrowIndMat.getTotalElapsedTimeAddEdges();
    //   // averageGrowingAddVerticesIndMat += oneGrowIndMat.getTotalElapsedTimeAddVertices();

    //   // // Adjacency Matrix
    //   // ScenarioOne oneGrowAdjMat = new ScenarioOne("adjmat");
    //   // oneGrowAdjMat.runScenarioOneIncreasedDensity(lines);
    //   // System.out.printf("\t\n---SUBSET %d---\n",i);
    //   // System.out.println("\tType of Matrix: Adjacency Matrix Increased Density");
    //   // oneGrowAdjMat.printData();
    //   // System.out.println("\tAdd Vertices Time taken Growing Graph: " + oneGrowAdjMat.getTotalElapsedTimeAddVertices()+"ns.");
    //   // System.out.println("\tAdd Edges Time taken Growing Graph: " + oneGrowAdjMat.getTotalElapsedTimeAddEdges()+"ns.");
    //   // averageGrowingAddEdgesAdjMat += oneGrowAdjMat.getTotalElapsedTimeAddEdges();
    //   // averageGrowingAddVerticesAdjMat += oneGrowAdjMat.getTotalElapsedTimeAddVertices();

    }
    System.out.println("Average Time taken for Edges IncidenceMatrix: " +averageAddEdgesIndMat/10+"ns.");
    System.out.println("Average Time taken for Vertices IncidenceMatrix: " +averageAddVerticesIndMat/10+"ns.");
    System.out.println("Average Time taken for Edges AdjacencyMatrix: " +averageAddEdgesAdjMat/10+"ns.");
    System.out.println("Average Time taken for Vertices AdjacencyMatrix: " +averageAddVerticesAdjMat/10+"ns.");
/*
    System.out.println("Average Time taken for Edges IncidenceMatrix Growing Graph: " +averageGrowingAddEdgesIndMat/10+"ns.");
    System.out.println("Average Time taken for Vertices IncidenceMatrix Growing Graph: " +averageGrowingAddVerticesIndMat/10+"ns.");
    System.out.println("Average Time taken for Edges AdjacencyMatrix Growing Graph: " +averageGrowingAddEdgesAdjMat/10+"ns.");
    System.out.println("Average Time taken for Vertices AdjacencyMatrix Growing Graph: " +averageGrowingAddVerticesAdjMat/10+"ns.");
*/

    // Scenario 2
    // long averageNeighboursIndMat = 0;
    // long averageShortestPathIndMat = 0;
    // long averageNeighboursAdjMat = 0;
    // long averageShortestPathAdjMat = 0;

    // System.out.println("*** SCENARIO 2 ***");
    // for(int i = 1; i <= 10; i++)
    // {
    //   ScenarioTwo twoAdjMat = new ScenarioTwo("adjmat");
    //   ScenarioTwo twoIndMat = new ScenarioTwo("indmat");
    //   int amountOfLines = rand.nextInt(1000)+1;
    //   System.out.printf("\n\nAmount Of Lines: %d", amountOfLines);
    //   ArrayList<String> lines = util.getLines(amountOfLines);

    //   // Incidence Matrix
    //   twoIndMat.runScenarioTwo(lines);
    //   System.out.printf("\t\n---SUBSET %d---\n",i);
    //   System.out.println("\tType of Matrix: IncidenceMatrix");
    //   twoIndMat.printData();
    //   System.out.println("\tNeighbours Time taken: " + twoIndMat.getTotalElapsedTimeNeighbours()+"ns.");
    //   System.out.println("\tShortestPath Time taken: " + twoIndMat.getTotalElapsedTimeShortestPath()+"ns.");
    //   averageNeighboursIndMat += twoIndMat.getTotalElapsedTimeNeighbours();
    //   averageShortestPathIndMat += twoIndMat.getTotalElapsedTimeShortestPath();

    //   // Adjacency Matrix
    //   twoAdjMat.runScenarioTwo(lines);
    //   System.out.printf("\t\n---SUBSET %d---\n",i);
    //   System.out.println("\tType of Matrix: IncidenceMatrix");
    //   twoIndMat.printData();
    //   System.out.println("\tNeighbours Time taken: " + twoAdjMat.getTotalElapsedTimeNeighbours()+"ns.");
    //   System.out.println("\tShortestPath Time taken: " + twoAdjMat.getTotalElapsedTimeShortestPath()+"ns.");
    //   averageNeighboursAdjMat += twoAdjMat.getTotalElapsedTimeNeighbours();
    //   averageShortestPathAdjMat += twoAdjMat.getTotalElapsedTimeShortestPath();
    // }
    // System.out.println("Average Time taken for Neighbours IncidenceMatrix: " +averageNeighboursIndMat/10+"ns.");
    // System.out.println("Average Time taken for Neighbours AdjacencyMatrix: " +averageNeighboursAdjMat/10+"ns.");
    // System.out.println("Average Time taken for ShortestPath IncidenceMatrix: " +averageShortestPathIndMat/10+"ns.");
    // System.out.println("Average Time taken for ShortestPath AdjacencyMatrix: " +averageShortestPathAdjMat/10+"ns.");

  //   //Scenario 3
    // long averageRemoveEdgesIndMat = 0;
    // long averageRemoveVerticesIndMat = 0;
    // long averageRemoveEdgesAdjMat = 0;
    // long averageRemoveVerticesAdjMat = 0;

    // System.out.println("*** SCENARIO 3 ***");
    // for(int i = 1; i <= 10; i++)
    // {
    //   ScenarioThree threeAdjMat = new ScenarioThree("adjmat");
    //   ScenarioThree threeIndMat = new ScenarioThree("indmat");
    //   int amountOfLines = rand.nextInt(100)+1;
    //   System.out.printf("\n\nAmount Of Lines: %d", amountOfLines);
    //   ArrayList<String> lines = util.getLines(amountOfLines);

    //   // Incidence Matrix
    //   threeIndMat.runScenarioThree(lines);
    //   System.out.printf("\t\n---SUBSET %d---\n",i);
    //   System.out.println("\tType of Matrix: IncidenceMatrix");
    //   System.out.println("\tRemove vertex Time taken: " + threeIndMat.getTotalElapsedTimeRemoveVertex()+"ns.");
    //   System.out.println("\tRemove edge Time taken: " + threeIndMat.getTotalElapsedTimeRemoveEdge()+"ns.");
    //   averageRemoveVerticesIndMat += threeIndMat.getTotalElapsedTimeRemoveVertex();
    //   averageRemoveEdgesIndMat += threeIndMat.getTotalElapsedTimeRemoveEdge();

    //   // Adjacency Matrix
    //   threeAdjMat.runScenarioThree(lines);
    //   System.out.printf("\t\n---SUBSET %d---\n",i);
    //   System.out.println("\tType of Matrix: IncidenceMatrix");
    //   System.out.println("\tRemove vertex Time taken: " + threeAdjMat.getTotalElapsedTimeRemoveVertex()+"ns.");
    //   System.out.println("\tRemove edge Time taken: " + threeAdjMat.getTotalElapsedTimeRemoveEdge()+"ns.");
    //   averageRemoveVerticesAdjMat += threeAdjMat.getTotalElapsedTimeRemoveVertex();
    //   averageRemoveEdgesAdjMat += threeAdjMat.getTotalElapsedTimeRemoveEdge();
    // }
    // System.out.println("Average Time taken for Remove Vertex IncidenceMatrix: " +averageRemoveVerticesIndMat/10+"ns.");
    // System.out.println("Average Time taken for Remove Vertex AdjacencyMatrix: " +averageRemoveVerticesAdjMat/10+"ns.");
    // System.out.println("Average Time taken for Remove Edge IncidenceMatrix: " +averageRemoveEdgesIndMat/10+"ns.");
    // System.out.println("Average Time taken for Remove Edge AdjacencyMatrix: " +averageRemoveEdgesAdjMat/10+"ns.");
  }

}




