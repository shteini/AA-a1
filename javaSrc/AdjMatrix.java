import java.io.*;
import java.util.*;


/**
* Adjacency matrix implementation for the FriendshipGraph interface.
*
* Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
*
* @author Jeffrey Chan, 2016.
*/
public class AdjMatrix <T extends Object> implements FriendshipGraph<T>
{
  ArrayList<Verticie> vertices;

/**
 * Contructs empty graph.
 */
  public AdjMatrix() {
    vertices = new ArrayList<Verticie>();
  } // end of AdjMatrix()


  public void addVertex(T vertLabel) {
    Verticie v = new Verticie(vertLabel);
    vertices.add(v);
  } // end of addVertex()


  public void addEdge(T srcLabel, T tarLabel) {

    // Check that both vertices are in the list as you can't add an edge if
    // either of them does not exist
    if(vertices.contains(srcLabel) && vertices.contains(tarLabel))
    {
      // temp variables to store the vertices to have an edge added.
      Verticie source = new Verticie();
      Verticie target = new Verticie();
      // Loop through vertices and assign the temp variables
      for(Verticie v: vertices)
      {
        //retrieve the source and target vertex's
        if(v.getLabel.equals(srcLabel))
        {
          source = v;
        }
        else if(v.getLabel.equals(tarLabel))
        {
          target = v;
        }
      }
      // add a connection to both the srclabel vertex
      // and the tarlabel vertex as they both have their own list of connections
      // e.g. B connected to C -> CB = 1 & BC = 1 where(1) means they are connected
      source.addEdge(target.getLabel());
      target.addEdge(source.getLabel());
    }
    else
    {
      System.out.print("One of your vertices does not exist in the list");
    }
  } // end of addEdge()


  public ArrayList<T> neighbours(T vertLabel) {
      ArrayList<T> neighbours = new ArrayList<T>();

      // Implement me!

      return neighbours;
  } // end of neighbours()


  public void removeVertex(T vertLabel) {
      // Implement me!
  } // end of removeVertex()


  public void removeEdge(T srcLabel, T tarLabel) {
      // Implement me!
  } // end of removeEdges()


  public void printVertices(PrintWriter os) {
      for(Verticie v: vertices)
      {
        System.out.print(v + " ");
      }
  } // end of printVertices()


  public void printEdges(PrintWriter os) {
      // Implement me!
  } // end of printEdges()


  public int shortestPathDistance(T vertLabel1, T vertLabel2) {
    // Implement me!

      // if we reach this point, source and target are disconnected
      return disconnectedDist;
  } // end of shortestPathDistance()

} // end of class AdjMatrix
