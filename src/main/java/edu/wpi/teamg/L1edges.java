package edu.wpi.teamg;

public class L1edges {
  private String edgeID;
  private L1nodes startnode;
  private L1nodes endNode;

  public L1edges() {}

  public String getEdgeID() {
    return edgeID;
  }

  public void setEdgeID(String edgeID) {
    this.edgeID = edgeID;
  }

  public L1nodes getStartnode() {
    return startnode;
  }

  public void setStartnode(L1nodes startnode) {
    this.startnode = startnode;
  }

  public L1nodes getEndNode() {
    return endNode;
  }

  public void setEndNode(L1nodes endNode) {
    this.endNode = endNode;
  }
}
