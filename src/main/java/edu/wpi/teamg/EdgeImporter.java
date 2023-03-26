package edu.wpi.teamg;

public class EdgeImporter {
  public void importFiletoDB() {
    EdgeReader reader = new EdgeReader();
    Gdb connection = new Gdb();
    String sql;

    connection.createConnection();
    System.out.println("Connection is created");

    for (L1edges edge : reader.EdgeRead()) {
      sql = "insert into proto1.l1edges(edgeID, startNode, endNode)values(?,?,?)";
      connection.createStatementsEdge(
          sql, edge.getEdgeID(), edge.getStartnode(), edge.getEndNode());
    }
    connection.closeConnection();
    System.out.println("Connection closed");
  }
}
