package datastructures;

import java.util.Scanner;

public class DataStructures {

    static Graph graph;
    
    static void graphQuestions(){
        Scanner s = new Scanner(System.in);
        System.out.print("Vertex:");
        int vertex = s.nextInt();
        /*graph = new Graph(vertex);
        graph.createUndirectedMatrixGraph();
        graph.printGraph();
        graph.createUndirectedGraphUsingList();
        graph.createDirectedGraphUsingList();
        graph.printList();
        graph.DFSTraversal();
        graph.BFSTraversal();
        graph.findParentNode();
        graph.detectCycle();
        graph.shortestPath(0, 7);*/
        
        graph = new Graph();
        graph.createWightedGraph(vertex);
        
    }
    
    public static void main(String[] args) {
        graphQuestions();
    }
    
}
