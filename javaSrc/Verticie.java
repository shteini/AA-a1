import java.util.*;
public class Verticie
{
  String label;

  /* Where a connection is an edge between two vertices.
  // With this implementation, each vertex knows which vertices it
  // has a connection with.
  */
  ArrayList<String> connections;

  public Verticie()
  {
    this.label = "NoLabel";
    this.connections = new ArrayList<String>();
  }
  public Verticie(String label)
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

  public void addEdge(String connectedVerticieLabel)
  {
    connections.add(connectedVerticieLabel);
  }
}
