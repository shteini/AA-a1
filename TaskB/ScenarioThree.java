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
    addVertices(lines);
    addEdges(lines);
    timeRemoveEdge(lines);
  	timeRemoveVertex(lines);
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

  private void addVertices(ArrayList<String> lines)
  {
    for(String line: lines)
    {
      String[] vertices = line.split(" ");
      matrix.addVertex(vertices[0]);
      matrix.addVertex(vertices[1]);
    }
  }

  private void addEdges(ArrayList<String> lines)
  {
    for(String line: lines)
    {
      String[] vertices = line.split(" ");
      matrix.addEdge(vertices[0], vertices[1]);
    }
  }

  public long getTotalElapsedTimeRemoveEdge()
  {
    return finishTimeRemoveEdge - startTimeRemoveEdge;
  }

  public long getTotalElapsedTimeRemoveVertex()
  {
    return finishTimeRemoveVertex - startTimeRemoveVertex;
  }

  public void printData()
  {
    matrix.printData();
  }
}
