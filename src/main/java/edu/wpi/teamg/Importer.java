package edu.wpi.teamg;

public class Importer {
    Reader reader;
    Gdb connection;
    String sql;
    public void nodeImport(){
        reader = new Reader();
        connection = new Gdb();

        connection.createConnection();
        System.out.println("Connection made");
        for(L1nodes node : reader.NodeRead()){
            sql=
            "insert into proto1.l1nodes(nodeID, xcoord, ycoord, floor, building, nodetype, longName, shortName)values(?,?,?,?,?,?,?,?)";
            connection.createStatementsNode(
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

    public void edgeImport(){
        reader = new Reader();
        connection = new Gdb();
        connection.createConnection();
        System.out.println("Connection created");

        for(L1edges edge: reader.EdgeRead()){
            sql = "insert into proto1.l1edges(edgeID, startNode, endNode)values(?,?,?)";
            connection.createStatementsEdge(
                    sql, edge.getEdgeID(), edge.getStartnode(), edge.getEndNode());
        }
        connection.closeConnection();
        System.out.println("Connection is closed");
    }
}
