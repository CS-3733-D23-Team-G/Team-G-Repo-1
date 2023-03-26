package edu.wpi.teamg;

public class Graph {
  private Node[] V;
  private Edge[] E;
  public int[][] createWeightedAdj(Edge[] E1, Node[] N1){
    int[][] A1= new int[N1.length][N1.length];
    for(int i=0; i<E1.length; i++){//i is number of rows
        Node start= E1[i].getStartNode();
        Node end= E1[i].getEndNode();
        int vertice_numS=0;
        int vertice_numE=0;
        for (int j=0; j<N1.length; j++){
          if (N1[j].equals(start)) {
            vertice_numS=j;
          }
          if(N1[j].equals(end)){
            vertice_numE=j;
          }
        }
        A1[vertice_numS][vertice_numE]=E1[i].distance(start,end);
        A1[vertice_numE][vertice_numS]=E1[i].distance(start,end);


      }



    return null;
  }
  public Node[] bfs() {return null;}
}
