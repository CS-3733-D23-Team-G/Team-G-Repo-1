package edu.wpi.teamg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;

public class Exporting {
  static int edgeCount;
  static int nodeCount;

  public static void main(String[] args) {
    edgeCount = 0;
    nodeCount = 0;
    makeNodeCSV();
    makeEdgeCSV();
  }

  private static void makeEdgeCSV() {
    edgeCount++;
    try {
      PrintWriter pw =
          new PrintWriter(new File("src/main/java/edu/wpi/teamg/L1Edges" + edgeCount + ".csv"));
      StringBuilder sb = new StringBuilder();

      Gdb connection = new Gdb();
      connection.createConnection();

      String query = "select * from teamgdb.proto1.l1edges";
      PreparedStatement ps = connection.getConnection().prepareStatement(query);
      ResultSet rs = null;
      rs = ps.executeQuery();
      sb.append("edgeid");
      sb.append(",");
      sb.append("startnode");
      sb.append(",");
      sb.append("endnode");
      sb.append("\r\n");
      while (rs.next()) {
        sb.append(rs.getString("edgeid"));
        sb.append(",");
        sb.append(rs.getString("startnode"));
        sb.append(",");
        sb.append(rs.getString("endnode"));
        sb.append("\r\n");
      }

      pw.write(sb.toString());
      pw.close();
      System.out.println("Edge writing has finished");

      connection.closeConnection();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static void makeNodeCSV() {
    nodeCount++;
    try {
      PrintWriter pw =
          new PrintWriter(new File("src/main/java/edu/wpi/teamg/L1Nodes" + nodeCount + ".csv"));
      StringBuilder sb = new StringBuilder();
      Gdb connection = new Gdb();
      connection.createConnection();

      String query = "select * from teamgdb.proto1.l1nodes";
      PreparedStatement ps = connection.getConnection().prepareStatement(query);
      ResultSet rs = null;
      rs = ps.executeQuery();
      sb.append("nodeid");
      sb.append(",");
      sb.append("xcoord");
      sb.append(",");
      sb.append("ycoord");
      sb.append(",");
      sb.append("floor");
      sb.append(",");
      sb.append("building");
      sb.append(",");
      sb.append("nodetype");
      sb.append(",");
      sb.append("longname");
      sb.append(",");
      sb.append("shortname");
      sb.append("\r\n");

      while (rs.next()) {
        sb.append(rs.getString("nodeid"));
        sb.append(",");
        sb.append(rs.getInt("xcoord"));
        sb.append(",");
        sb.append(rs.getInt("ycoord"));
        sb.append(",");
        sb.append(rs.getString("floor"));
        sb.append(",");
        sb.append(rs.getString("building"));
        sb.append(",");
        sb.append(rs.getString("nodetype"));
        sb.append(",");
        sb.append(rs.getString("longname"));
        sb.append(",");
        sb.append(rs.getString("shortname"));
        sb.append("\r\n");
      }

      pw.write(sb.toString());
      pw.close();
      System.out.println("Node writing has finished");
      connection.closeConnection();

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
