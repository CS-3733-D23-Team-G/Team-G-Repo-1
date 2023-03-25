package edu.wpi.teamg;

public class Edge {
    private String edgeID;
    private Node startNode;
    private Node endNode;

    public Edge(String ID, Node start, Node end){
        edgeID=ID;
        startNode=start;
        endNode=end;
    }

    public int distance(Node A, Node B){
        return 0;

    }

}
