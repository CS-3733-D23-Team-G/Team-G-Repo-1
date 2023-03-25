package edu.wpi.teamg;

import java.io.*;

public class NodeReader {

  public static void main(String[] args) {
   // NodeReader reader = new NodeReader();
      // reader.NodeRead();
  }

  public void NodeRead() {
    BufferedReader br;
    String file = "src/main/java/edu/wpi/teamg/L1Nodes.csv";
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
