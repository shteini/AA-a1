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
  String[][] graph;
  String[] vertexLabels;

/**
 * Contructs empty graph.
 */
  public AdjMatrix() {
    graph = new String[0][0];
  } // end of AdjMatrix()


  public void addVertex(T vertLabel) {
    int graphSize = graph.length;
    String[][] temp = new String[graphSize + 1][graphSize + 1];

    //If there is already at least one vertex
    if(graphSize >= 1)
    {

      //Loop through old array and add copy old values to new temp array
      for(int i = 0; i < graph.length; i++)
      {
        for(int j = 0; j < graph[i].length; j++)
        {
          temp[i][j] = graph[i][j];
        }
      }

      //Add the new vertex
      temp[temp.length-1][temp.length-1] = vertLabel.toString();
      //With temp updated with the new vertex now we can save the graph
      graph = temp;
    }
    else
    {
      // No Vertices in the array
      temp[temp.length-1][temp.length-1] = vertLabel.toString();
      graph = temp;
    }
  } // end of addVertex()


  public void addEdge(T srcLabel, T tarLabel) {

    // Check that both vertices are in the list as you can't add an edge if
    // either of them does not exist

      // temp variables to store the vertices to have an edge added.

      // Loop through vertices and assign the temp variables
      //
        //retrieve the source and target vertex's

      // add a connection to both the srclabel vertex
      // and the tarlabel vertex as they both have their own list of connections
      // e.g. B connected to C -> CB = 1 & BC = 1 where(1) means they are connected

  } // end of addEdge()


  public ArrayList<T> neighbours(T vertLabel) {
      ArrayList<T> neighbours = new ArrayList<T>();

      // Implement me!

      return neighbours;
  } // end of neighbours()


  public void removeVertex(T vertLabel) {
    int graphSize = graph.length;
    String[][] temp = new String[graphSize - 1][graphSize - 1];

    //If there is already at least one vertex

      //Loop through old array and add copy old values to new temp array
      for(int i = 0; i < graph.length; i++)
      {
        for(int j = 0; j < graph[i].length; j++)
        {
          //If the vertex we are looking at is not equal to the one we wish to
          //remove, we add it to temp, if it is the one we want to remove, the
          //for loop skips it and it is not added to the temp array
          if(!(graph[i][j].equals(vertLabel)))
          {
            temp[i][j] = graph[i][j];
          }
        }
      }
      //With temp updated with the removed vertex now we can save the graph
      graph = temp;

  } // end of removeVertex()


  public void removeEdge(T srcLabel, T tarLabel) {
      // Implement me!
  } // end of removeEdges()


  public void printVertices(PrintWriter os) {
      for(int i = 0; i < graph.length; i++)
      {
        for(int j = 0; j < graph[i].length; j++)
        {
          os.print(graph[i][j]);
        }
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
