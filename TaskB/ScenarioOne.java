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
      matrix = new AdjMatrix<T>();
    }
    else if(type.equals('indmat'))
    {
      matrix = new IndMatrix<T>();
    }
  }

  public void addEdges()
  {
    this. = System.nanoTime();
     for(String line: lines)
    {
      String[] vertices = line.split(" ");
      matrix.addEdge(vertices[0], vertices[1]);
    }

    this.finishTime = System.nanoTime();
  }

  public void addVertices(ArrayList<String> lines)
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


  private void runScenarioOne(ArrayList<String> lines)
  {



  }

  private long getTotalElapsedTimeAddVertices()
  {
    return finishTimeAddVertex - startTimeAddVertex;
  }
}
