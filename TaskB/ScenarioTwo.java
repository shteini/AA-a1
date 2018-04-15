import java.util.*;
public class ScenarioTwo
{
  private FriendshipGraph matrix;
  private long startTimeNeighbours;
  private long finishTimeNeighbours;
  private long startTimeShortestPath;
  private long finishTimeAddShortestPath;

  public ScenarioTwo(String type)
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

  public void runScenarioTwo(ArrayList<String> lines)
  {
    addVertices(lines);
    addEdges(lines);
  	timeShortestPath(lines);
  	timeNeighbours(lines);
  }

  private void timeShortestPath(ArrayList<String> lines)
  {
    this.startTimeShortestPath = System.nanoTime();
    for(String line: lines)
    {
      String[] vertices = line.split(" ");
      matrix.shortestPathDistance(vertices[0], vertices[1]);
    }
    this.finishTimeAddShortestPath = System.nanoTime();
  }

  private void timeNeighbours(ArrayList<String> lines)
  {
    this.startTimeNeighbours = System.nanoTime();
    for(String line: lines)
    {
      String[] vertices = line.split(" ");
      matrix.neighbours(vertices[0]);
      matrix.neighbours(vertices[1]);
    }
    this.finishTimeNeighbours = System.nanoTime();
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

  public long getTotalElapsedTimeNeighbours()
  {
    return finishTimeNeighbours - startTimeNeighbours;
  }

  public long getTotalElapsedTimeShortestPath()
  {
    return finishTimeAddShortestPath - startTimeShortestPath;
  }

  public void printData()
  {
    matrix.printData();
  }
}
