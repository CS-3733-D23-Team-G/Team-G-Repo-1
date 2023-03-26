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
      //      e.printStackTrace();
      System.err.println("SQL exception");
      printSQLException(e);
    }
  }

  public void createStatements(
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

      System.err.println("SQL exception");
      printSQLException(e);
      // e.printStackTrace();
    }
  }

  public ResultSet createStatements(String sql) {
    PreparedStatement ps;
    ResultSet rs = null;

    try {
      ps = connection.prepareStatement(sql);
      rs = ps.executeQuery();
    } catch (SQLException e) {
      System.err.println("SQL exception");
      printSQLException(e);
    }

    return rs;
  }

  public void closeConnection() {
    try {
      connection.close();
    } catch (SQLException e) {

      System.err.println("SQL exception");
      printSQLException(e);
    }
  }

  public static void printSQLException(SQLException ex) {
    for (Throwable e : ex) {
      if (e instanceof SQLException) {
        if (ignoreSQLException(((SQLException) e).getSQLState()) == false) {
          e.printStackTrace(System.err);
          System.err.println("SQLState: " + ((SQLException) e).getSQLState());
          System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
          System.err.println("Message: " + e.getMessage());
          Throwable t = ex.getCause();
          while (t != null) {
            System.out.println("Cause: " + t);
            t = t.getCause();
          }
        }
      }
    }
  }

  public static boolean ignoreSQLException(String sqlState) {
    if (sqlState == null) {
      System.out.println("The SQL state is not defined!");
      return false;
    }
    // X0Y32: Jar file already exists in schema
    if (sqlState.equalsIgnoreCase("X0Y32")) return true;
    // 42Y55: Table already exists in schema
    if (sqlState.equalsIgnoreCase("42Y55")) return true;
    return false;
  }
}
