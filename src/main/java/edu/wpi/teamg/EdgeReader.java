package edu.wpi.teamg;

import java.io.*;
import java.util.LinkedList;

public class EdgeReader {
  private LinkedList<L1edges> edgeList = new LinkedList<L1edges>();

  public static void main(String[] args) {
    EdgeReader reader = new EdgeReader();
    for (L1edges edge : reader.EdgeRead()) {
      System.out.println(edge);
    }
  }

  public LinkedList<L1edges> EdgeRead() {
    BufferedReader br;
    String file = "src/main/java/edu/wpi/teamg/L1Edges.csv";
    String line;
    try {
      br = new BufferedReader(new FileReader(new File(file)));
      br.readLine();
      while ((line = br.readLine()) != null) {
        fullL1EdgeObject(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return edgeList;
  }

  public void fullL1EdgeObject(String line) {
    String[] strArray = line.split(",");
    L1edges l1edge = new L1edges();
    l1edge.setEdgeID(strArray[0]);
    l1edge.setStartNode(strArray[1]);
    l1edge.setEndNode(strArray[2]);
    edgeList.add(l1edge);
  }
}
