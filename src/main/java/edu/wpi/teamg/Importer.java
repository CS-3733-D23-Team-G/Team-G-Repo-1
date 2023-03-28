package edu.wpi.teamg;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Importer {
  Reader reader;
  Gdb connection;
  String sql;

  public void nodeImport(String filePath) {
    reader = new Reader();
    connection = new Gdb();

    connection.createConnection();
    System.out.println("Connection made");
    for (L1nodes node : reader.NodeRead(filePath)) {
      sql =
          "insert into proto1.l1nodes(nodeID, xcoord, ycoord, floor, building, nodetype, longName, shortName)values(?,?,?,?,?,?,?,?)";
      createStatementsNode(
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
    connection.closeConnection();
    System.out.println("Connection closed");
  }

  public void edgeImport(String filePath) {
    reader = new Reader();
    connection = new Gdb();
    connection.createConnection();
    System.out.println("Connection created");

    for (L1edges edge : reader.EdgeRead(filePath)) {
      sql = "insert into proto1.l1edges(edgeID, startNode, endNode)values(?,?,?)";
      createStatementsEdge(sql, edge.getEdgeID(), edge.getStartnode(), edge.getEndNode());
    }
    connection.closeConnection();
    System.out.println("Connection is closed");
  }

  public void createStatementsEdge(String sql, String edgeID, String startNode, String endNode) {
    PreparedStatement ps;
    try {
      ps = connection.getConnection().prepareStatement(sql);
      ps.setString(1, edgeID);
      ps.setString(2, startNode);
      ps.setString(3, endNode);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void createStatementsNode(
      String sql,
      String nodeID,
      int xcoord,
      int ycoord,
      String floor,
      String building,
      String nodeType,
      String longName,
      String shortName) {
    PreparedStatement ps;
    try {
      ps = connection.getConnection().prepareStatement(sql);
      ps.setString(1, nodeID);
      ps.setInt(2, xcoord);
      ps.setInt(3, ycoord);
      ps.setString(4, floor);
      ps.setString(5, building);
      ps.setString(6, nodeType);
      ps.setString(7, longName);
      ps.setString(8, shortName);
      ps.executeUpdate();

    } catch (SQLException e) {
      System.err.println("SQL exception");
      e.printStackTrace();
    }
  }
}
