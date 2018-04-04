import java.util.*;
public class Vertex
{
  String label;

  /* Where a connection is an edge between two vertices.
  // With this implementation, each vertex knows which vertices it
  // has a connection with.
  */
  ArrayList<> connections;

  public Vertex()
  {
    this.label = "NoLabel";
    this.connections = new ArrayList<String>();
  }
  public Vertex(String label)
  {
    this.label = label;
    this.connections = new ArrayList<String>();
  }

  public String getLabel()
  {
    return this.label;
  }

  public ArrayList<String> getConnections()
  {
    return this.connections;
  }

  public void addEdge(String connectedvertexLabel)
  {
    connections.add(connectedvertexLabel);
  }
}
