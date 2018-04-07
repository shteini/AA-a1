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
  int[][] graph;
  ArrayList<String> vertexLabels;

/**
 * Contructs empty graph.
 */
  public AdjMatrix() {
    graph = new int[0][0];
    //Can we use Hashmap to store index and value i.e. index 0 = A
    vertexLabels = new ArrayList<String>();
  } // end of AdjMatrix()


  public void addVertex(T vertLabel) {
    vertexLabels.add(vertLabel.toString());
    int graphSize = graph.length;

    //Increase the size of the array by 1
    int[][] temp = new int[graphSize + 1][graphSize + 1];
    //If there is already at least one vertex
    if(graphSize > 0)
    {
      //Loop through old array and copy old edges to new temp array
      for(int i = 0; i < graph.length; i++)
      {
        for(int j = 0; j < graph[i].length; j++)
        {
          temp[i][j] = graph[i][j];
        }
      }
      graph = temp;
    }
    else
    {
      // No Vertices in the array
      graph = temp;
    }
  } // end of addVertex()

  public void removeVertex(T vertLabel) {


    if(vertexLabels.contains(vertLabel))
    {
      int graphSize = graph.length;
      int[][] temp = new int[graphSize - 1][graphSize - 1];
      int vertIndex = vertexLabels.indexOf(vertLabel);
      //Loop through old array and add copy old values to new temp array
      //CASE For when vertex is the last one in the array.
      removeEdgesForVertex(vertIndex);
      for(int i = 0; i < graph.length-1; i++)
      {
        for(int j = 0; j < graph[i].length-1; j++)
        {
          if(j == vertIndex)
          {
            temp[i][j] = graph[i][j+1];
            j++;
          }
          else if(i == vertIndex)
          {
            temp[i][j] = graph[i+1][j];
          }
        }
      }
      //remove from the vertexLabel list
      vertexLabels.remove(vertLabel);
      //With temp updated with the removed vertex row and column now we can save the graph
      graph = temp;
    }

  } // end of removeVertex()

  public void addEdge(T srcLabel, T tarLabel) {

    // Check that both vertices are in the list as you can't add an edge if
    // either of them does not exist
    if(vertexLabels.contains(srcLabel) && vertexLabels.contains(tarLabel))
    {
      //Get index of labels in array
      int srcIndex = vertexLabels.indexOf(srcLabel.toString());
      int tarIndex = vertexLabels.indexOf(tarLabel.toString());
      graph[srcIndex][tarIndex] = 1;
      graph[tarIndex][srcIndex] = 1;
    }

  } // end of addEdge()

  public void removeEdge(T srcLabel, T tarLabel) {

      //check both requested vertices are in the list
      if(vertexLabels.contains(srcLabel) && vertexLabels.contains(tarLabel))
      {
        //get index of labels in the array
        int srcIndex = vertexLabels.indexOf(srcLabel.toString());
        int tarIndex = vertexLabels.indexOf(tarLabel.toString());
        graph[srcIndex][tarIndex] = 0;
        graph[tarIndex][srcIndex] = 0;
        //go over with Sam
      }
      // Implement me!
  } // end of removeEdges()


  public ArrayList<T> neighbours(T vertLabel) {
      ArrayList<T> neighbours = new ArrayList<T>();

      if(vertexLabels.contains(vertLabel.toString()))
      {
        //if vertlabel is part of an edge
        //neighbours.add(vertLabel);
      }
      // Implement me!

      return neighbours;
  } // end of neighbours()

  public void printVertices(PrintWriter os) {
      for(String vertex: vertexLabels)
      {
        System.out.print(vertex + " ");
      }
  } // end of printVertices()


  public void printEdges(PrintWriter os) {
    os = new PrintWriter(System.out, true);

    for(int i = 0; i < graph.length; i++)
      {
        for(int j = 0; j < graph[i].length; j++)
        {
          if(graph[i][j] == 1)
          {
            String vertexOne = vertexLabels.get(i);
            String vertexTwo = vertexLabels.get(j);
            os.println(vertexOne + " " + vertexTwo);
          }
        }
      }
  } // end of printEdges()


  public int shortestPathDistance(T vertLabel1, T vertLabel2) {
    // Implement me!

      // if we reach this point, source and target are disconnected
      return disconnectedDist;
  } // end of shortestPathDistance()

  public void removeEdgesForVertex(int vertIndex)
  {
    for(int i = 0; i < graph.length; i++)
    {
      for(int j = 0; j < graph[i].length; j++)
      {
        if(i == vertIndex || j == vertIndex)
        {
          graph[i][j] = 0;
        }
      }
    }
  }

} // end of class AdjMatrix
