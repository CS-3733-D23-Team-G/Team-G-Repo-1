package edu.wpi.teamg;

public class Graph {
  private Node[] V;
  private Edge[] E;
  public int[][] createWeightedAdj(Edge[] E1, Node[] N1){
    int[][] A1= new int[N1.length][N1.length];
    // populate the adj matrix with zeros or inf change as nessary
      for(int i=0; i<N1.length; i++){
          for(int j=0; j<N1.length; j++){
              A1[i][j]=0;
          }
      }

    // this will connect the nodes to edges

    for(int i=0; i<E1.length; i++){//i is number of rows
       //we will get the frist edge out of the Edge[] array and
        // get the start and end nodes from it.
        Node start= E1[i].getStartNode();
        Node end= E1[i].getEndNode();
        int vertice_numS=0;
        int vertice_numE=0;
        //then we will find where the nodes are in the Node[] array and save the int value
        for (int j=0; j<N1.length; j++){
          if (N1[j].equals(start)) {
            vertice_numS=j;
          }
          if(N1[j].equals(end)){
            vertice_numE=j;
          }
        }
        //we then calulate the distance between the two nodes and put it in the A1[][] array
        //since the adj matrix is sysmetric the number in the rowxcolum and columxrow will be the same. 
        A1[vertice_numS][vertice_numE]=E1[i].distance(start,end);
        A1[vertice_numE][vertice_numS]=E1[i].distance(start,end);
      }
    return A1;
  }
  public Node[] bfs() {return null;}
}
