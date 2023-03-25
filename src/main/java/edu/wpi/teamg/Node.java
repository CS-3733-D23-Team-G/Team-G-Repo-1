package edu.wpi.teamg;

public class Node {


    private String NodeID;
    private int nodeX;
    private int nodeY;
    private String floor;
    private String building;
    private String longName;
    private String shortName;

    public Node(String NodeID, int nodeX, int nodeY, String floor, String building, String longName, String shortName){
        this.NodeID = NodeID;
        this.nodeX = nodeX;
        this.nodeY = nodeY;
        this.floor = floor;
        this.building = building;
        this.longName = longName;
        this.shortName = shortName;

    }

    public int getNodeX(){
        return nodeX;
    }
    public int getNodeY(){
        return nodeY;
    }




}
