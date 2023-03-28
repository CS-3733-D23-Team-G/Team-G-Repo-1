package edu.wpi.teamg;

import java.sql.*;
import java.util.ArrayList;

public class NodeDAO {


    public static void main(String[] args) throws SQLException {


        //Create a connection
        Connection connection = DriverManager.getConnection();

        //Make a Statement
        Statement statement = connection.createStatement();

        //Execute statement
        ResultSet rs = statement.execute();

        while(rs.next()){

        }

        //Close connection
        connection.close();
    }



    public NodeDAO(){

    }


    /*
    public listO getList(ArrayList<Node> listOfNodes){

    }

     */
}
