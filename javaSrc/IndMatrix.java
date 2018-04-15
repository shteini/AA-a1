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
      for(int j = 0; j < graph.length; j++)
      {
        if(graph[j][i] == 1 && j != vertIndex)
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

    int graphSize = graph.length;
    ArrayList<Integer> vertexEdgeList = new ArrayList<Integer>();

    //The index of the vertex we are trying to delete
    int vertIndex = vertexLabels.indexOf(vertLabel);

    //for loop reach the 1 in the row and remove the column
    for(int i=0; i < graph[vertIndex].length; i++)
    {
      //if it finds a 1
      if(graph[vertIndex][i] == 1)
      {
        for(int j = 0; j< graphSize; j++)
        {
          if(graph[j][i] == 1 && j != vertIndex)
          {
            vertexEdgeList.add(j);
          }
        }
      }
    }
    //remove this column with a for loop that adds the vertLabel as source and item from arraylist as target
    for(int m = 0; m < vertexEdgeList.size(); m++)
    {
      removeEdge(vertLabel, vertexLabels.get(vertexEdgeList.get(m)));
    }
    int[][] temp = new int[graphSize - 1][graph[0].length];
    int tempI = 0;
    for(int i = 0; i < graph.length; i++)
    {

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
        temp[tempI][j] = graph[i][j];
      }
      tempI++;
    }
    //remove from the vertexLabel list
    vertexLabels.remove(vertLabel);
    //With temp updated with the removed vertex row and column now we can save the graph
    graph = temp;

} // end of removeVertex()


public void removeEdge(T srcLabel, T tarLabel) {
  if(vertexLabels.contains(srcLabel) && vertexLabels.contains(tarLabel))
  {
    // index of srcLabel
    int srcIndex = vertexLabels.indexOf(srcLabel);
    // index of tarLabel
    int tarIndex = vertexLabels.indexOf(tarLabel);
    // resize graph to be 1 less in columns, we will copy graph to this new
    // temp array once we have discovered the index of the column to remove
    // which we will do by simply not adding that column to the new array
    int[][] temp = new int[graph.length][graph[0].length-1];
    // This int will hold the index(position) of the column we want to remove
    int columnToRemove = -1;

    // This for loop find the column where both srcLabel(i.e. vertex A)
    // and tarLabel(i.e. vertex B) are == 1 meaning that there is an edge between
    // vertex A and vertex B this will be the column we want to remove, represented
    // as i. We then save the index of this column to use in the next step
    for(int i = 0; i < graph[srcIndex].length; i++)
    {
     if(graph[srcIndex][i] == 1 && graph[tarIndex][i] == 1)
     {
      columnToRemove = i;
     }
    }
    // If column to remove is still -1 at this point it means that we did not
    // find an edge between the given vertices so we tell the user that in the
    // else statment. Otherwise we enter here and remove that column
    if(columnToRemove != -1)
    {
      int tempJ = 0;
      for(int i = 0; i < graph.length; i++)
      {
        tempJ = 0;
        for(int j = 0; j < graph[i].length; j++)
        {
          //If the current column is the column we want to delete,
          //save the current column position in tempJ and increment J++
          //i.e. skip over it. This next position we have already accessed in the previous line.
          //the for loop also increments j again so we get to the next position i.e. skip one column
          if(j == columnToRemove)
          {
            tempJ = j;
            continue;
          }
          else
          {
            temp[i][tempJ] = graph[i][j];
            tempJ++;
          }
        }
      }
    }
    else
    {
      System.out.println("There was no edge to remove between those two vertices");
    }
    //With temp updated with the removed column, now we can save the graph
    graph = temp;
  }
  else
  {
    System.out.println("One or both of the given vertices do not exist");
  }
} // end of removeEdges()


public void printVertices(PrintWriter os) {
    for(T vertex: vertexLabels)
    {
      os.print(vertex + " ");
    }
    os.flush();
} // end of printVertices()


public void printEdges(PrintWriter os) {
  for(int i = 0; i < graph.length; i++)
  {
    for(int j = 0; j < graph[0].length; j++)
    {
      if(graph[i][j] == 1)
      {
        os.print(vertexLabels.get(i) + " ");
        for(int k = 0; k < graph.length; k++)
        {
          if(graph[k][j] == 1 && k != i)
          {
            os.print(vertexLabels.get(k));
            os.println();
          }
        }

      }
    }
    os.println();
    os.flush();
  }

  // os = new PrintWriter(System.out, true);

  // for(int i = 0; i < graph.length; i++)
  // {
  //   for(int j = 0; j < graph[i].length; j++)
  //   {
  //     os.print(graph[i][j] + " |");
  //   }
  //   os.println();
  // }
 // end of printEdges()
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

} // end of class IndMatrix
