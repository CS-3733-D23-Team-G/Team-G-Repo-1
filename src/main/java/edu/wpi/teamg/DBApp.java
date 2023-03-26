package edu.wpi.teamg;

public class DBApp {
  public static void main(String[] args) {
    NodeImporter Nimporter = new NodeImporter();
    Nimporter.importFiletoDB();
    EdgeImporter Eimporter = new EdgeImporter();
    Eimporter.importFiletoDB();
  }
}
