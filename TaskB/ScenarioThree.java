import java.util.*;
public class ScenarioThree
{
  private FriendshipGraph matrix;
  private long startTimeRemoveEdge;
  private long finishTimeRemoveEdge;
  private long startTimeRemoveVertex;
  private long finishTimeRemoveVertex;

  public ScenarioThree(String type)
  {
    if(type.equals("adjmat"))
    {
      matrix = new AdjMatrix();
    }
    else if(type.equals("indmat"))
    {
      matrix = new IndMatrix();
    }
  }

  public void runScenarioThree(ArrayList<String> lines)
  {
  	timeRemoveVertex(lines);
  	timeRemoveEdge(lines);
  }
  
  private void timeRemoveEdge(ArrayList<String> lines)
  {
    this.startTimeRemoveEdge = System.nanoTime();
    for(String line: lines)
    {
      String[] vertices = line.split(" ");
      matrix.removeEdge(vertices[0], vertices[1]);
    }
    this.finishTimeRemoveEdge = System.nanoTime();
  }

  private void timeRemoveVertex(ArrayList<String> lines)
  {
    this.startTimeRemoveVertex = System.nanoTime();
    for(String line: lines)
    {
      String[] vertices = line.split(" ");
      matrix.removeVertex(vertices[0]);
      matrix.removeVertex(vertices[1]);
    }
    this.finishTimeRemoveVertex = System.nanoTime();
  }

  public long getTotalTimeElapsedRemoveEdge()
  {
    return finishTimeRemoveEdge - startTimeRemoveEdge;
  }

  public long getTotalElapsedRemoveVertex()
  {
    return finishTimeRemoveVertex - startTimeRemoveVertex;
  }

  public void printData()
  {
    matrix.printData();
  }
}
