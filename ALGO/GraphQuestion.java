package practicealgo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Graph{
    static int v;
    static LinkedList<Integer> adjList[];

    public Graph(int v) {
        this.v = v;
        adjList = new LinkedList[v];
        
        for(int i=0;i<v;i++)
            adjList[i] = new LinkedList<>();
    }
}
public class GraphQuestion {
    Scanner sc = new Scanner(System.in);
    
    public void createUndirectedGraphMat(){
        int totalVertex = sc.nextInt();
        int totalEdge = sc.nextInt();
        int mat[][] = new int[totalVertex][totalVertex];
        
        for(int i=0;i<totalEdge;i++)
            for(int j=0;j<totalEdge;j++)
                mat[i][j] = 0;
        
        for(int i=0;i<totalEdge;i++){
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            int data = sc.nextInt();
            mat[vertex1][vertex2]= 1;
            mat[vertex2][vertex1] = 1;
        }
        System.out.print("Graph using matrix:\n");
        for(int i=0;i<totalEdge;i++){
            System.out.print("\n");
            for(int j=0;j<totalEdge;j++)
                System.out.print(mat[i][j]+" ");
        }
        
    }
    
    public void createUndirectedGraphAdjList(){
        int vertex = sc.nextInt();
        int edges = sc.nextInt();
        Graph g = new Graph(vertex);
        for(int i=0;i<edges;i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            Graph.adjList[src].add(dest);
            Graph.adjList[dest].add(src);
        }
        System.out.print("\nPrinting graph\n");
        for(int i=0;i<vertex;i++){
            LinkedList<Integer> temp = Graph.adjList[i];
            System.out.print("\n"+i+":-> ");
            for(int j=0;j<temp.size();j++)
                System.out.print(temp.get(j)+" ");
        }
    }
    
    void graphDFS(int vertex){
        boolean visited[] = new boolean[Graph.v];
        Stack<Integer> s = new Stack<>();
        s.push(vertex);
        
        System.out.println("\nDFS of graph:-");
        while(!s.isEmpty()){
            int val = s.pop();
            if(visited[val]==false){
                visited[val] = true;
                System.out.print(val+", ");
            }
            Iterator<Integer> it = Graph.adjList[val].listIterator();
            while(it.hasNext()){
                int data = it.next();
                if(!visited[data]){
                    s.push(data);
                }
            }
        }
    }
    void graphBFS(int vertex){
        boolean visited[] = new boolean[Graph.v];
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        
        System.out.println("\nBFS of graph:-");
        while(!q.isEmpty()){
            int val = q.poll();
            if(visited[val]==false){
                visited[val] = true;
                System.out.print(val+", ");
            }
            Iterator<Integer> it = Graph.adjList[val].listIterator();
            while(it.hasNext()){
                int data = it.next();
                if(!visited[data]){
                    q.add(data);
                }
            }
        }
    }
    
    void checkPath(int src,int dest){
        boolean visited[] = new boolean[Graph.v];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int data=0;
        System.out.println("\n");
        boolean flag=false;
        while(!q.isEmpty()){
            int val = q.poll();
            if(visited[val]==false){
                visited[val] = true;
            }
            Iterator<Integer> it = Graph.adjList[val].listIterator();
            while(it.hasNext()){
                data = it.next();
                if(data==dest){
                    flag=true;
                    break;
                }
                else if(!visited[data]){
                    q.add(data);
                }
            }
            if(flag)
                break;
        }
        if(flag)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
