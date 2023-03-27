package edu.wpi.teamg;

import java.util.Random;

public class Main {



  public static void main(String[] args) {

    Node[] N1 = new Node[10];
    Random r = new Random(5591);
    for (int i = 0; i < 10; i++) {
      N1[i] =
          new Node(
              String.valueOf(i),
              (int) r.nextInt(100) + i,
              (int) r.nextInt(100) + i,
              "L1",
              "dsfajd;",
              "jk;ldsjf",
              "dsfaj;sldk");
    }
    Edge[] E1 = new Edge[10];
    E1[0] = new Edge("e1", N1[0], N1[1]);
    E1[1] = new Edge("e2", N1[1], N1[2]);
    E1[2] = new Edge("e3", N1[1], N1[3]);
    E1[3] = new Edge("e4", N1[2], N1[4]);
    E1[4] = new Edge("e5", N1[3], N1[4]);
    E1[5] = new Edge("e6", N1[4], N1[5]);
    E1[6] = new Edge("e7", N1[5], N1[6]);
    E1[7] = new Edge("e8", N1[6], N1[7]);
    E1[8] = new Edge("e9", N1[5], N1[8]);
    E1[9] = new Edge("e10", N1[8], N1[9]);
    Graph G1 = new Graph(N1, E1);
    int[][] Adj = G1.createWeightedAdj();
    // new int[10][10];

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        System.out.print(Adj[i][j] + ", ");
      }
      System.out.println();
    }
  }
  /*

    try {
      File myObj = new File("C:\\Users\\thoma\\Downloads\\L1Nodes (1).csv");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {

        System.out.println(myReader.next());

      }
      myReader.close();

    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    System.out.println("Nathan");
    System.out.println("Thomas");
  }

     */




}
