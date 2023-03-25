package edu.wpi.teamg;

import java.sql.*;
import java.sql.SQLException;

public class Gdb {
  public static void main(String[] args) throws SQLException {
    Connection connection =
        DriverManager.getConnection(
            "jdbc:postgresql://database.cs.wpi.edu:5432/teamgdb", "teamg", "teamg70");

    connection.close();
  }
}
