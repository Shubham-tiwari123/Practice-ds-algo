package datastructures;

import java.util.Scanner;

public class DataStructures {

    static Graph graph;
    
    static void graphQuestions(){
        Scanner s = new Scanner(System.in);
        System.out.print("Vertex:");
        int vertex = s.nextInt();
        graph = new Graph(vertex);
        graph.createUndirectedMatrixGraph();
        graph.printGraph();
        graph.createUndirectedGraphUsingList();
        graph.createDirectedGraphUsingList();
        graph.printList();
        graph.DFSTraversal();
        graph.BFSTraversal();
        graph.findParentNode();
        graph.detectCycle();
        graph.shortestPath(0, 7);
        
        graph = new Graph();
        graph.createWightedGraph(vertex);
        System.out.print("\nDijkstra shortest path directed weighted graph\n");
        graph.dijkstraShortestPath(0,vertex);
        
        graph.createUndirWightedGraph(vertex);
        System.out.print("\nDijkstra shortest path undirected weighted graph\n");
        graph.dijkstraShortestPath(0, vertex);
        System.out.print("\nPrism shortest path undirected weighted graph\n");
        graph.prismAlgo(0, vertex);
        
        
    }
    
    static void graph2Questions(){
        Graph2 graph2 = new Graph2();
        graph2.MST();
        graph2.connectAllRoads();
    }
    
    static void priorityQueue(){
        PriorityQue pq = new PriorityQue();
        int arr[]={11,15,12,16,17,14,13};
        pq.createMaxHeap(arr);
        int arr1[] = {17,13,6,1,4,2,5};
        int res[] = pq.createMinHeap(arr1);
        System.out.print("\nPrint min heap:");
        for(int i=0;i<arr1.length;i++){
            System.out.print(res[i]+" ");
        }
        pq.findLargestMinHeap(pq.createMinHeap(arr1));
        
        int res2[] = pq.deleteElement(1, res);
        System.out.print("\nPrint min heap after delete operation:");
        for(int i=0;i<res2.length-1;i++){
            System.out.print(res2[i]+" ");
        }
        pq.mergeTwoMaxHeap(arr, arr1);
        
        //Heap using priority queue
        pq.createPriorityQueue();
        pq.stackUsingPQ();
        pq.megreKsortedList();
        pq.findLargestPair();
        
    }
    public static void main(String[] args) {
        //graphQuestions();
        //graph2Questions();
        priorityQueue();
    }
    
}
