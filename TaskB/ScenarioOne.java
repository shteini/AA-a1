import java.util.*;
public class ScenarioOne
{
  private FriendshipGraph matrix;
  private long startTimeAddVertex;
  private long finishTimeAddVertex;
  private long startTimeAddEdges;
  private long finishTimeAddEdges;

  public ScenarioOne(String type)
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

  public void runScenarioOne(ArrayList<String> lines)
  {
  	addVertices(lines);
    addEdges(lines);
    
  }

  private void addEdges(ArrayList<String> lines)
  {
    this.startTimeAddEdges = System.nanoTime();
    for(String line: lines)
    {
      String[] vertices = line.split(" ");
      matrix.addEdge(vertices[0], vertices[1]);
    }
    this.finishTimeAddEdges = System.nanoTime();
  }

  private void addVertices(ArrayList<String> lines)
  {
    this.startTimeAddVertex = System.nanoTime();
    for(String line: lines)
    {
      String[] vertices = line.split(" ");
      matrix.addVertex(vertices[0]);
      matrix.addVertex(vertices[1]);
    }
    this.finishTimeAddVertex = System.nanoTime();
  }

  public long getTotalElapsedTimeAddVertices()
  {
    return finishTimeAddVertex - startTimeAddVertex;
  }

  public long getTotalElapsedTimeAddEdges()
  {
    return finishTimeAddEdges - startTimeAddEdges;
  }

  public void printData()
  {
    matrix.printData();
  }
}
