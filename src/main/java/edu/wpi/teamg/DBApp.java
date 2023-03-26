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
        "Successfully connect to the database!\nPlease select from the following action.\n");

    int version = 0;
    boolean valid_version = false;

    // If version is passed in via command line, set the value
    //    if (args.length >= 3) {
    //      version = Integer.parseInt(args[2]);
    //      valid_version = true;
    //    }

    do {
      switch (version) {
        case 1:

          // TextTable tt = new TextTable(columnNames, data);

          System.out.println("Displaying node and edge information...");
          sql = "select * from proto1.l1nodes";
          ResultSet rs = connection.createStatements(sql);
          System.out.format(
              "%-15s %-15s %-15s %-15s %-15s %-15s %-50s %-50s\n",
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
                "%-15s %-15d %-15d %-15s %-15s %-15s %-50s %-50s\n",
                rs.getString("nodeid"),
                rs.getInt("xcoord"),
                rs.getInt("ycoord"),
                rs.getString("floor"),
                rs.getString("building"),
                rs.getString("nodetype"),
                rs.getString("longname"),
                rs.getString("shortname"));
          }

          version = 0;
          valid_version = false;
          break;

        case 6:
          System.out.println("Please enter the directory of the CSV file:");
          String filePath = scanner.nextLine();

          NodeImporter importer = new NodeImporter();
          importer.importFiletoDB(filePath);

          version = 0;
          valid_version = false;
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
