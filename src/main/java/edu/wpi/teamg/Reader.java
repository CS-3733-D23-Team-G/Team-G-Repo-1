package edu.wpi.teamg;

import java.io.*;
import java.util.LinkedList;

public class Reader {
    private LinkedList<L1edges> edgeList = new LinkedList<L1edges>();
    private LinkedList<L1nodes> nodeList = new LinkedList<L1nodes>();
    private String fileLocation;

    public LinkedList<L1edges> EdgeRead(){
        BufferedReader br;
        fileLocation = "src/main/java/edu/wpi/teamg/L1Edges.csv";
        String line;
        try{
            br = new BufferedReader(new FileReader(new File(fileLocation)));
            br.readLine();
            while((line = br.readLine())!=null){
                makeEdgeObject(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return edgeList;
    }
    public void makeEdgeObject(String line){
        String[] strArray = line.split(",");
        L1edges edge = new L1edges();
        edge.setEdgeID((strArray[0]));
        edge.setStartNode(strArray[2]);
        edge.setEndNode(strArray[3]);
        edgeList.add(edge);
    }


    public LinkedList<L1nodes> NodeRead(){
        BufferedReader br;
        fileLocation = "src/main/java/edu/wpi/teamg/L1Nodes.csv";
        String line;
        try{
            br = new BufferedReader(new FileReader(new File(fileLocation)));
            br.readLine();
            while((line = br.readLine())!=null){
                makeNodeObject(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nodeList;
    }

    public void makeNodeObject(String line){
        String[] strArray = line.split(",");
        L1nodes l1node = new L1nodes();
        l1node.setNodeID(strArray[0]);
        l1node.setXcoord(Integer.parseInt(strArray[1]));
        l1node.setYcoord(Integer.parseInt(strArray[2]));
        l1node.setFloor(strArray[3]);
        l1node.setBuilding(strArray[4]);
        l1node.setNodeType(strArray[5]);
        l1node.setLongName(strArray[6]);
        l1node.setShortName(strArray[7]);
        nodeList.add(l1node);
    }
}