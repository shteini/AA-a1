import java.io.*;
import java.util.*;


/**
* Incidence matrix implementation for the FriendshipGraph interface.
*
* Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
*
* @author Jeffrey Chan, 2016.
*/
public class IndMatrix <T extends Object> implements FriendshipGraph<T>
{
int graph[][];
ArrayList<T> vertexLabels;
/**
* Contructs empty graph.
*/
public IndMatrix() {

    graph = new int[0][0];
    vertexLabels = new ArrayList<T>();

} // end of IndMatrix()


public void addVertex(T vertLabel) {

  if(!vertexLabels.contains(vertLabel)) {
      int[][] temp;

      vertexLabels.add(vertLabel);

      int rowNum = graph.length;

      if(rowNum == 0)
      {
        temp = new int[rowNum+1][rowNum];
      }
      else
      {
        int columnNum = graph[0].length;
        temp = new int[rowNum+1][columnNum];
      }

      if(rowNum > 0)
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
  }
  else
  {
    System.out.println("Vertex already exists");
  }
} // end of addVertex()


public void addEdge(T srcLabel, T tarLabel) {
  if(vertexLabels.contains(srcLabel) && vertexLabels.contains(tarLabel))
  {
    int rowSize = graph.length;
    int columnSize = graph[0].length;
    int sourceIndex = vertexLabels.indexOf(srcLabel);
    int tarIndex = vertexLabels.indexOf(tarLabel);
    int[][] temp = new int[rowSize][columnSize + 1];

      for(int i = 0; i < graph.length; i++)
      {
        for(int j = 0; j < graph[i].length; j++)
        {
        temp[i][j] = graph[i][j];
        }
      }
      graph = temp;
      graph[sourceIndex][graph[0].length-1] = 1;
      graph[tarIndex][graph[0].length-1] = 1;
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
  os = new PrintWriter(System.out, true);
  for(T vertex: vertexLabels)
  {
    os.print(vertex + " ");
  }
    // Implement me!
} // end of printVertices()


public void printEdges(PrintWriter os) {

  for(int i = 0; i < graph.length; i++)
  {
    for(int j = 0; j < graph[i].length; j++)
    {
      System.out.print(graph[i][j] + " |");
    }
    System.out.println();
    // Implement me!
  }
} // end of printEdges()


public int shortestPathDistance(T vertLabel1, T vertLabel2) {
  // Implement me!

    // if we reach this point, source and target are disconnected
    return disconnectedDist;
} // end of shortestPathDistance()

} // end of class IndMatrix
