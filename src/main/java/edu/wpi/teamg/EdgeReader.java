package edu.wpi.teamg;

import java.io.*;

public class EdgeReader {
    public void EdgeRead() {
        BufferedReader br;
        String file = "src/main/java/edu/wpi/teamg/L1Edges.csv";
        String line;
        try {
            br = new BufferedReader(new FileReader(new File(file)));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
