package edu.wpi.teamg;

public class NodeImporter {
  public void importFiletoDB(String file) {
    NodeReader reader = new NodeReader();
    Gdb connection = new Gdb();
    String sql;

    // connection.createConnection();
    // System.out.print("connection is created");

    for (L1nodes node : reader.NodeRead(file)) {
      sql =
          "insert into proto1.l1nodes(nodeID, xcoord, ycoord, floor, building, nodetype, longName, shortName)values(?,?,?,?,?,?,?,?)";
      connection.createStatements(
          sql,
          node.getNodeID(),
          node.getXcoord(),
          node.getYcoord(),
          node.getFloor(),
          node.getBuilding(),
          node.getNodeType(),
          node.getLongName(),
          node.getShortName());
    }
    // connection.closeConnection();
    // System.out.println("Connection is closed");
  }
}
