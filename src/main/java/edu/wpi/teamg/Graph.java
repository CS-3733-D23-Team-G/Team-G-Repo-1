package edu.wpi.teamg;

public class Graph {
  private Node[] V;
  private Edge[] E;

  public int[][] createWeightedAdj() {
    int[][] A1 = new int[V.length][V.length];
    // populate the adj matrix with zeros or inf (change as needed)
    for (int i = 0; i < V.length; i++) {
      for (int j = 0; j < V.length; j++) {
        A1[i][j] = 0;
      }
    }

    // this will connect the nodes to edges
    for (int i = 0; i < E.length; i++) { // i is number of rows
      // we will get the frist edge out of the Edge[] array and
      // get the start and end nodes from it.
      Node start = E[i].getStartNode();
      Node end = E[i].getEndNode();
      int vertice_numS = 0;
      int vertice_numE = 0;
      // then we will find where the nodes are in the Node[] array and save the int value
      for (int j = 0; j < V.length; j++) {
        if (V[j].equals(start)) {
          vertice_numS = j;
        }
        if (V[j].equals(end)) {
          vertice_numE = j;
        }
      }
      // we then calulate the distance between the two nodes and put it in the A1[][] array
      // since the adj matrix is sysmetric the number in the rowxcolum and columxrow will be the
      // same.
      A1[vertice_numS][vertice_numE] = E[i].distance(start, end);
      A1[vertice_numE][vertice_numS] = E[i].distance(end, start);
    }
    return A1;
  }

  public Node[] bfs() {
    return null;
  }
}
