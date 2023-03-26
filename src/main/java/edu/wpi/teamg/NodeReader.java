package edu.wpi.teamg;

import java.io.*;

public class NodeReader {

<<<<<<< Updated upstream
  public static void main(String[] args) {
   // NodeReader reader = new NodeReader();
      // reader.NodeRead();
  }

  public void NodeRead() {
=======
  //  public static void main(String[] args) {
  //    NodeReader reader = new NodeReader();
  //    for (L1nodes node : reader.NodeRead()) {
  //      System.out.println(node);
  //    }
  //  }

  public LinkedList<L1nodes> NodeRead(String file) {
>>>>>>> Stashed changes
    BufferedReader br;
    // String file = "src/main/java/edu/wpi/teamg/L1Nodes.csv";
    String line;
    try {
      br = new BufferedReader(new FileReader(new File(file)));
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
