package edu.wpi.teamg;

import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;

public class DBApp {
  public static void main(String[] args) throws SQLException {
    Scanner scanner = new Scanner(System.in);

    Gdb connection = new Gdb();
    String sql;

    connection.createConnection();
    System.out.print(
        " Successfully connect to the database!\n Please select from the following action:\n");

    int version = 0;
    boolean valid_version = false;

    do {
      switch (version) {
        case 1:

          // TextTable tt = new TextTable(columnNames, data);

          System.out.println("  Displaying node and edge information...");
          sql = "select * from proto1.l1nodes";
          ResultSet rs = connection.createStatements(sql);
          System.out.format(
              " %-15s %-15s %-15s %-15s %-15s %-15s %-50s %-50s\n",
              "nodeID",
              "xcoord",
              "ycoord",
              "floor",
              "building",
              "nodeType",
              "longName",
              "shortName");

          while (rs.next()) {
            System.out.format(
                " %-15s %-15d %-15d %-15s %-15s %-15s %-50s %-50s\n",
                rs.getString("nodeid"),
                rs.getInt("xcoord"),
                rs.getInt("ycoord"),
                rs.getString("floor"),
                rs.getString("building"),
                rs.getString("nodetype"),
                rs.getString("longname"),
                rs.getString("shortname"));
          }

          System.out.println("\n");

          sql = "select * from teamgdb.proto1.l1edges";
          ResultSet rs2 = connection.createStatements(sql);
          System.out.format(" %-21s %10s %10s\n", "edgeID", "startNode", "endNode");
          while (rs2.next()) {
            System.out.format(
                " %-21s %10s %10s\n",
                rs2.getString("edgeid"), rs2.getString("startnode"), rs2.getString("endnode"));
          }
          System.out.println("\n");
          version = 0;
          break;
        case 2:
          String nodeID;
          int xcoord;
          int ycoord;

          System.out.println("Please enter the nodeID;");
          nodeID = scanner.nextLine();

          System.out.println("Please enter the x-coordinate:");
          xcoord = Integer.parseInt(scanner.nextLine());

          System.out.println("Please enter the y-coordinate:");
          ycoord = Integer.parseInt(scanner.nextLine());

          String query = "Update proto1.l1nodes set xcoord = ?, ycoord = ? where nodeID = ?";
          connection.createUpdateStatements(query, nodeID, xcoord, ycoord);
          System.out.println("Coordinates updated");

          version = 0;
          break;
        case 3:
          String building;
          System.out.println("Please enter the nodeID;");
          nodeID = scanner.nextLine();

          System.out.println("Please enter the name of the building");
          building = scanner.nextLine();

          query = "Update proto1.l1nodes set building = ? where nodeID = ?";
          connection.createLocationUpdate(query, nodeID, building);
          System.out.println("Building name updated");

          version = 0;
          break;
        case 4:
          System.out.println("Do you want to export node or edge?");
          String response = scanner.nextLine();
          if (response.toLowerCase().equals("node")) {
            Exporting exporter = new Exporting();
            exporter.makeNodeCSV();
            System.out.println("Node csv created!");
          } else if (response.toLowerCase().equals("edge")) {
            Exporting exporter = new Exporting();
            exporter.makeEdgeCSV();
            System.out.println("Edge csv created!");
          } else {
            System.out.println("invalid response");
          }
          version = 0;
          break;
        case 5:
          System.out.println(" Is is node of edge?");
          response = scanner.nextLine();
          if (response.toLowerCase().equals("node")) {
            System.out.println("  Please enter the directory of the CSV file: ");
            String filePath = scanner.nextLine();

            Importer importer = new Importer();
            importer.nodeImport(filePath);
          } else if (response.toLowerCase().equals("edge")) {
            System.out.println("  Please enter the directory of the CSV file: ");
            String filePath = scanner.nextLine();

            Importer importer = new Importer();
            importer.edgeImport(filePath);
          } else {
            System.out.println("invalid response");
          }

          version = 0;
          break;

        case 6:
          String ver1 = "Display node and edge information";
          String ver1_cont =
              "Retrieve all data from nodes and edges of Floor L1 and display the information nicely formatted tables.";

          String ver2 = "Update node coordinates";
          String ver2_cont =
              "Given a nodeID and new coordinates by the user, update the x-coordinate and y-coordinate of that node.";

          String ver3 = "Update name of location node";
          String ver3_cont =
              "Given a nodeID and new location name by the user, update the location name of that node.";

          String ver4 = "Export node table into a CSV file";
          String ver4_cont =
              "Given the file path to a CSV file by the user, write the node table data to that file.";

          String ver5 = "Import from a CSV file into the node table";
          String ver5_cont =
              "Given the file path to a CSV file by the user, insert the data from the file to the node table.";

          String ver6 = "Display Help";
          String ver6_cont =
              "Display a simple user manual explaining all the interfaces of the program.";

          String ver7 = "Exit";
          String ver7_cont = "Exit and terminates the program instance.";

          System.out.format("\t%-50s  \t%-100s\n\n", "Interface", "Description");
          System.out.format("\t%-50s | \t%-100s\n", ver1, ver1_cont);
          System.out.format("\t%-50s | \t%-100s\n", ver2, ver2_cont);
          System.out.format("\t%-50s | \t%-100s\n", ver3, ver3_cont);
          System.out.format("\t%-50s | \t%-100s\n", ver4, ver4_cont);
          System.out.format("\t%-50s | \t%-100s\n", ver5, ver5_cont);
          System.out.format("\t%-50s | \t%-100s\n", ver6, ver6_cont);
          System.out.format("\t%-50s | \t%-100s\n", ver7, ver7_cont);

          version = 0;
          break;

        case 7:
          valid_version = true;
          break;

        default:
          boolean valid;
          do {
            System.out.println(
                "\n   1- Display node and edge information \n"
                    + "   2- Update node coordinates \n"
                    + "   3- Update name of location node \n"
                    + "   4- Export node table into a CSV file \n"
                    + "   5- Import from a CSV file into the node table \n"
                    + "   6- Display Help \n"
                    + "   7- Exit \n");

            //

            version = Integer.parseInt(scanner.nextLine());
            valid = 0 < version && 8 > version;
            if (!valid) {
              System.err.println("Invalid Option!");
            }
          } while (!valid);
          break;
      }
    } while (!valid_version);

    // Close DBMS Connection
    connection.closeConnection();
    System.out.println("Connection is closed");
  }
}
