package org.ds;

import org.graph.Graph;
import org.graph.GraphDistance;
import org.graph.Node;
import org.graph.SimpleGraph;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        GraphDistance<String> graph = new GraphDistance<>();
        /*graph.add(1, 2);
        graph.add(1, 3);
        graph.add(2, 6);
        graph.add(2, 4);
        graph.add(3, 4);
        graph.add(3, 5);
        graph.display();
        graph.dfs();*/

        graph.connect("S", "B", 2);
        graph.connect("S", "A", 7);
        graph.connect("S", "C", 3);
        graph.connect("A", "B", 3);
        graph.connect("A", "D", 4);
        graph.connect("B", "D", 4);
        graph.connect("B", "H", 1);
        graph.connect("D", "F", 5);
        graph.connect("H", "F", 3);
        graph.connect("H", "G", 2);
        graph.connect("G", "E", 2);
        graph.connect("C", "L", 2);
        graph.connect("L", "I", 4);
        graph.connect("L", "J", 4);
        graph.connect("I", "J", 6);
        graph.connect("I", "K", 4);
        graph.connect("J", "K", 4);
        graph.connect("K", "E", 4);

        graph.display();
        //graph.dijkstra("A");
        graph.addHeuristicDistance("A", "E", 9);
        graph.addHeuristicDistance("B", "E", 7);
        graph.addHeuristicDistance("S", "E", 10);
        graph.addHeuristicDistance("D", "E", 8);
        graph.addHeuristicDistance("F", "E", 6);
        graph.addHeuristicDistance("H", "E", 6);
        graph.addHeuristicDistance("G", "E", 3);
        graph.addHeuristicDistance("K", "E", 3);
        graph.addHeuristicDistance("J", "E", 4);
        graph.addHeuristicDistance("L", "E", 6);
        graph.addHeuristicDistance("I", "E", 4);
        graph.addHeuristicDistance("C", "E", 8);
        graph.aStar("S");

        
        //graph.cycleCountAndDisplay();
        //System.out.println("Graph contains cycle " + graph.dfsCycle());



    }
}