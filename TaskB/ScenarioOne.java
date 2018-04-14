public class ScenarioOne
{
  private FriendshipGraph matrix;
  private long startTime;
  private long finishTime;

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


  private String runScenarioOne(ArrayList<String> lines)
  {
    this.startTime = System.nanoTime();

    for(String line: lines)
    {
      String[] vertices = line.split(" ");
      matrix.addVertex(vertices[0]);
      matrix.addVertex(vertices[1]);
    }

    for(String line: lines)
    {
      String[] vertices = line.split(" ");
      matrix.addEdge(vertices[0], vertices[1]);
    }

    this.finishTime = System.nanoTime();
  }

  private getTotalElapsedTime()
  {
    return finishTime - startTime;
  }

  private getTotalElapsedTimeAddEdges()
  {
  	return finishTime - startTime;
  }
}
