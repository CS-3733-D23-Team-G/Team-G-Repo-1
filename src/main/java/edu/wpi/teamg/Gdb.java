package edu.wpi.teamg;

import java.sql.*;

public class Gdb {

  static Connection connection;

  public void createConnection() {
    try {
      connection =
          DriverManager.getConnection(
              "jdbc:postgresql://database.cs.wpi.edu:5432/teamgdb", "teamg", "teamg70");
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
      ps = connection.prepareStatement(sql);
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
      e.printStackTrace();
    }
  }

  public void createStatementsEdge(String sql, String edgeID, String startNode, String endNode) {
    PreparedStatement ps;
    try {
      ps = connection.prepareStatement(sql);
      ps.setString(1, edgeID);
      ps.setString(2, startNode);
      ps.setString(3, endNode);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void closeConnection() {
    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
