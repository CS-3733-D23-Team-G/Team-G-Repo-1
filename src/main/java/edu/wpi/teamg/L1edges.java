package edu.wpi.teamg;

public class L1edges {
  private String edgeID;
  private String startnode;
  private String endNode;

  public L1edges() {}

  public String getEdgeID() {
    return edgeID;
  }

  public void setEdgeID(String edgeID) {
    this.edgeID = edgeID;
  }

  public String getStartnode() {
    return startnode;
  }

  public void setStartNode(String startnode) {
    this.startnode = startnode;
  }

  public String getEndNode() {
    return endNode;
  }

  public void setEndNode(String endNode) {
    this.endNode = endNode;
  }

  public String toString() {
    return "Edge [edgeID= " + edgeID + ", startNode= " + startnode + ", endNode= " + endNode;
  }
}
