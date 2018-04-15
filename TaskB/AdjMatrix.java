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
  ArrayList<T> vertexLabels;

/**
 * Contructs empty graph.
 */
  public AdjMatrix() {
    graph = new int[0][0];
    //Can we use Hashmap to store index and value i.e. index 0 = A
    vertexLabels = new ArrayList<T>();
  } // end of AdjMatrix()


  public void addVertex(T vertLabel) {
    if(!vertexLabels.contains(vertLabel))
    {

      vertexLabels.add(vertLabel);
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
    }
    // else
    // {
    //   System.out.println("Vertex already exists");
    // }
  } // end of addVertex()

  public void removeVertex(T vertLabel) {


    if(vertexLabels.contains(vertLabel))
    {
      int graphSize = graph.length;
      int[][] temp = new int[graphSize - 1][graphSize - 1];

      //The index of the vertex we are trying to delete
      int vertIndex = vertexLabels.indexOf(vertLabel);

      //remove any edges that the vertex being deleted has with other vertices
      //otherwise remaining vertices that had an edge with the deleted vertex
      //will show unexpected edges

      //Loop through old array and add copy old values to new temp array
      //Only if the row or column we are in is != to the row or column we are
      //trying to delete
      int tempI = 0;
      int tempJ = 0;
      for(int i = 0; i < graph.length; i++)
      {
        tempJ = 0;
        if(i == vertIndex && i == graph.length-1)
        {
          break;
        }
        else if(i == vertIndex && i != graph.length-1)
        {
          tempI = i;
          continue;

        }
        for(int j = 0; j < graph[i].length; j++)
        {
          //If the current column is the column we want to delete,
          //save the current column position in temp as the next one in graph
          //i.e. skip over it. We then increment j to the next position manually,
          //this next position we have already accessed in the previous line.
          //the for loop also increments j so we get to the next position
          if(j == vertIndex)
          {
            tempJ = j;
            continue;
          }
          else
          {
            temp[tempI][tempJ] = graph[i][j];
            tempJ++;
          }

        }
        tempI++;
      }
      //remove from the vertexLabel list
      vertexLabels.remove(vertLabel);
      //With temp updated with the removed vertex row and column now we can save the graph
      graph = temp;
    }
    else
    {
      System.out.println("Vertex Does Not Exist");
    }
  } // end of removeVertex()

  public void addEdge(T srcLabel, T tarLabel) {

    // Check that both vertices are in the list as you can't add an edge if
    // either of them does not exist
    if(vertexLabels.contains(srcLabel) && vertexLabels.contains(tarLabel))
    {
      //Get index of labels in array
      int srcIndex = vertexLabels.indexOf(srcLabel);
      int tarIndex = vertexLabels.indexOf(tarLabel);
      graph[srcIndex][tarIndex] = 1;
      graph[tarIndex][srcIndex] = 1;
    }

  } // end of addEdge()

  public void removeEdge(T srcLabel, T tarLabel) {
    if(vertexLabels.contains(srcLabel) && vertexLabels.contains(tarLabel))
    {
      int srcIndex = vertexLabels.indexOf(srcLabel);
      int tarIndex = vertexLabels.indexOf(tarLabel);
      graph[srcIndex][tarIndex] = 0;
      graph[tarIndex][srcIndex] = 0;
    }
  } // end of removeEdges()


  public ArrayList<T> neighbours(T vertLabel) {
      ArrayList<T> neighbours = new ArrayList<T>();
      int vertIndex = vertexLabels.indexOf(vertLabel.toString());


      if(vertexLabels.contains(vertLabel))
      {
        //Get the index
        int vertLabelIndex = vertexLabels.indexOf(vertLabel);
        //if vertlabel is part of an edge
        for(int j = 0; j < graph[vertLabelIndex].length; j++)
        {
          if(graph[vertLabelIndex][j] == 1)
          {
            // If our row A, B or C etc has any edges
            // with any other vertices we only need to check our row
            // i.e. A and B have an edge graph[0][1] = 1; and graph[1][0] = 1;
            // we only need to check graph[indexOfVertexWeAreGettingNeighboursFor][everyColumnInRow]
            neighbours.add(vertexLabels.get(j));
          }
        }

        //neighbours.add(vertLabel);
      }
      // Implement me!

      return neighbours;
  } // end of neighbours()

  public void printVertices(PrintWriter os) {
    for(T vertex: vertexLabels)
    {
      os.print(vertex + " ");
      os.flush();
    }
  } // end of printVertices()


  public void printEdges(PrintWriter os) {
    for(int i = 0; i < graph.length; i++)
    {
      for(int j = 0; j < graph[i].length; j++)
      {
        if(graph[i][j] == 1)
        {
          String vertexOne = vertexLabels.get(i).toString();
          String vertexTwo = vertexLabels.get(j).toString();
          os.println(vertexOne + " " + vertexTwo);
          os.flush();
        }
      }
    }
  } // end of printEdges()

  public ArrayList<T> getVertices() {
    return this.vertexLabels;
  }

  public int numberOfVertices()
  {
    return graph.length;
  }

  public int numberOfEdges()
  {
    int edgeNumber = 0;
    for(int i = 0; i < graph.length; i ++)
    {
      for(int j = 0; j < graph[i].length; j++)
      {
        if(graph[i][j] == 1)
        {
          edgeNumber++;
        }
      }
    }
    return edgeNumber / 2;
  }

  public float density()
  {
    int numEdges = numberOfEdges();
    int numVert = numberOfVertices();
    int vertSquared = numVert * numVert;
    float density = (float)numEdges/(float)vertSquared;
    return density;
  }

  public void printData()
  {
    System.out.println("\tNumber of Vertices: " + numberOfVertices());
    System.out.println("\tNumber of Edges: " + numberOfEdges());
    System.out.println("\tDensity: " + density());
  }


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

} // end of class AdjMatrix
