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
        Graph g = new Graph(vertex+1);
        for(int i=0;i<edges;i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            Graph.adjList[src].add(dest);
            Graph.adjList[dest].add(src);
        }
        System.out.print("\nPrinting graph\n");
        for(int i=0;i<Graph.v;i++){
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
    
    void findNeighbour(int src,int dis){
        boolean visited[] = new boolean[Graph.v];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int data;
        while(--dis>0){
            int temp = q.poll();
            visited[temp]=true;
            Iterator<Integer> it = Graph.adjList[temp].listIterator();
            while(it.hasNext()){
                data = it.next();
                if(visited[data]==false)
                    q.add(data);
            }
            System.out.println("q:-"+q);
        }
        
        System.out.println("visted");
        for(int i=0;i<visited.length;i++)
            System.out.println(i+":-> "+visited[i]);
        int count=0;
        Queue<Integer> q1 = q;
        while(!q.isEmpty()){
            int value = q.poll();
            if(visited[value]==false){
                visited[value]=true;
                Iterator<Integer> it = Graph.adjList[value].listIterator();
                while(it.hasNext()){
                    data = it.next();
                    if(visited[data]==false && !q1.contains(data)){
                        System.out.println("data:-"+data);
                        visited[data]=true;
                        count++;
                    }
                    else
                        visited[data]=true;
                }
            }
            
        }
        System.out.println("count:-"+count);
    }
   
    void findLevel(){
        boolean visited[] = new boolean[Graph.v];
        int level[] = new int[Graph.v];
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q1 = new LinkedList<>();
        Iterator<Integer> it1 = Graph.adjList[0].listIterator();
        int levelCount=0;
        if(it1.hasNext()){
            q.add(0);
        }
        else{
            q.add(1);
        }
        
        int data=0;
        while(!q.isEmpty() || !q1.isEmpty()){
            while(!q.isEmpty()){
                int val = q.poll();
                level[val] = levelCount;
                if(visited[val]==false){
                    visited[val] = true;
                }
                Iterator<Integer> it = Graph.adjList[val].listIterator();
                while(it.hasNext()){
                    data = it.next();
                    if(!visited[data]){
                        q1.add(data);
                    }
                }
            }
            levelCount++;
            while(!q1.isEmpty()){
                int val = q1.poll();
                level[val] = levelCount;
                if(visited[val]==false){
                    visited[val] = true;
                }
                Iterator<Integer> it = Graph.adjList[val].listIterator();
                while(it.hasNext()){
                    data = it.next();
                    if(!visited[data]){
                        q.add(data);
                    }
                }
            }
            levelCount++;
        }
        System.out.print("\nLevel:-");
        for(int i=0;i<Graph.v;i++){
            System.out.println(i+":->"+level[i]);
        }
    }
}
