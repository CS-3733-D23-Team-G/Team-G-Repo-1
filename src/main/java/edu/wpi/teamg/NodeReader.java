package edu.wpi.teamg;

import java.io.*;
import java.util.LinkedList;

public class NodeReader {
  private LinkedList<L1nodes> nodeList = new LinkedList<L1nodes>();

  public static void main(String[] args) {
    NodeReader reader = new NodeReader();
    for (L1nodes node : reader.NodeRead()) {
      System.out.println(node);
    }
  }

  public LinkedList<L1nodes> NodeRead() {
    BufferedReader br;
    String file = "src/main/java/edu/wpi/teamg/L1Nodes.csv";
    String line;
    try {
      br = new BufferedReader(new FileReader(new File(file)));
      br.readLine();
      while ((line = br.readLine()) != null) {
        fullL1NodeObject(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return nodeList;
  }

  public void fullL1NodeObject(String line) {
    String[] strArray = line.split(",");
    L1nodes l1node = new L1nodes();
    l1node.setNodeID(strArray[0]);
    l1node.setXcoord(Integer.parseInt(strArray[1]));
    l1node.setYcoord(Integer.parseInt(strArray[2]));
    l1node.setFloor(strArray[3]);
    l1node.setBuilding(strArray[4]);
    l1node.setLongName(strArray[5]);
    l1node.setShortName(strArray[6]);
    nodeList.add(l1node);
  }
}
