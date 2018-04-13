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
    int vertIndex = vertexLabels.indexOf(vertLabel);
    for(int i = 0; i < graph[vertIndex].length; i++)
    {
     if(graph[vertIndex][i] == 1)
     {
      for(int j = 1; j < graph.length; j++)
      {
        if(graph[j][i] == 1)
        {
          T neighbour = vertexLabels.get(j);
          neighbours.add(neighbour);
        }
      }
     }
    }
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
    os.println();
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
 if(vertexLabels.contains(vertLabel1) && vertexLabels.contains(vertLabel2))
    {
      int source = vertexLabels.indexOf(vertLabel1);
      int target = vertexLabels.indexOf(vertLabel2);
      LinkedList<T> queue = new LinkedList<T>();
      int[] distances = new int[graph.length];
      Arrays.fill(distances, -1);
      queue.add(vertLabel1);
      distances[vertexLabels.indexOf(vertLabel1)] = 0;
      while(!queue.isEmpty())
      {
        // Get the index of the first vertex from the queue and remove it from the queue.
        T vertex = queue.poll();
        // Get all the neighbours of the vertex
        ArrayList<T> neighbours = neighbours(vertex);

        // Loop through the neighbours of the vertex
        for(T neighbour: neighbours)
        {
          // If we haven't visited the neighbour(vertex) yet then the distance will be -1
          // If we have visited already then the for loop will move to the next neighbour.
          if(distances[vertexLabels.indexOf(neighbour)] == -1)
          {
            // Set the distance of this neighbour = currentvertex distance +1
            distances[vertexLabels.indexOf(neighbour)] = distances[vertexLabels.indexOf(vertex)] + 1;
            // Add the neighbour to the queue to check it's neighbours next
            queue.add(neighbour);
          }
        }
      }

      int shortestPath = distances[vertexLabels.indexOf(vertLabel2)];
      return shortestPath;
    }
    else
    {
      return -1;
    }
} // end of shortestPathDistance()

} // end of class IndMatrix
