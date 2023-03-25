package edu.wpi.teamg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

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

  // shortcut: psvm

}
