package datastructures;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
class WeightedGraph implements Comparator<WeightedGraph>{
    int dest;
    int weight;
    public WeightedGraph(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
    
    @Override
    public int compare(WeightedGraph o1, WeightedGraph o2) {
        if(o1.weight< o2.weight)
            return -1;
        if(o1.weight> o2.weight)
            return 1;
        return 0;
    }

    public WeightedGraph() {
    }
    
    
}
public class Graph {
    
    final private Scanner sc;
    private int V;
    private static int mat[][];
    private static LinkedList<Integer> adjList[];
    private Stack<Integer> stack;
    private Queue<Integer> queue;
    private Iterator<Integer> itr;
    private static LinkedList<WeightedGraph> adjlist[];
    private Iterator<WeightedGraph> itr1;
            
    public Graph() {
        sc = new Scanner(System.in);
    }

    public Graph(int vertex) {
        this.V = vertex;
        sc = new Scanner(System.in);
        mat = new int[vertex][vertex];
        for(int i=0;i<vertex;i++){
            for(int j=0;j<vertex;j++)
                mat[i][j]=0;
        }
        adjList = new LinkedList[vertex];
        for(int i=0;i<vertex;i++)
            adjList[i] = new LinkedList<>();
    }
    
    void createUndirectedMatrixGraph(){
        System.out.print("Edges:");
        int edges = sc.nextInt();
        for(int i=0;i<edges;i++){
            int point1 = sc.nextInt();
            int point2 = sc.nextInt();
            mat[point1][point2]=1;
            mat[point2][point1]=1;
        }
    }
    
    void printGraph(){
        for(int i=0;i<mat.length;i++){
            System.out.print("\n");
            for(int j=0;j<mat.length;j++)
                System.out.print(mat[i][j]+" ");
        }
    }
    
    void createUndirectedGraphUsingList(){
        System.out.print("Edges:");
        int edges = sc.nextInt();
        for(int i=0;i<edges;i++){
            int point1 = sc.nextInt();
            int point2 = sc.nextInt();
            adjList[point1].add(point2);
            adjList[point2].add(point1);
        }
    }
    
    void printList(){
        for(int i=0;i<adjList.length;i++){
            System.out.print("\n"+i+": "+adjList[i]);
        }
    }
    
    void DFSTraversal(){
        System.out.print("\nDFS: ");
        boolean vis[] = new boolean[adjList.length];
        for(int i=0;i<vis.length;i++)
            vis[i] = false;
        
        stack = new Stack<>();
        stack.push(0);
        
        while(!stack.isEmpty()){
            int val = stack.pop();
            if(!vis[val]){
                vis[val] = true;
                System.out.print(val+" ");
            }
            itr = adjList[val].iterator();
            while(itr.hasNext()){
                int data = itr.next();
                if(!vis[data])
                    stack.add(data);
            }
        }
    }
    
    void BFSTraversal(){
        System.out.print("\nBFS: ");
        
        boolean vis[] = new boolean[adjList.length];
        for(int i=0;i<vis.length;i++)
            vis[i] = false;
        
        queue = new LinkedList<>();
        queue.add(0);
        
        while(!queue.isEmpty()){
            int val = queue.poll();
            if(!vis[val]){
                vis[val] = true;
                System.out.print(val+" ");
            }
            itr = adjList[val].iterator();
            while(itr.hasNext()){
                int data = itr.next();
                if(!vis[data])
                    queue.add(data);
            }
        }
    }
    
    void createDirectedGraphUsingList(){
        System.out.print("Edges:");
        int edges = sc.nextInt();
        for(int i=0;i<edges;i++){
            int point1 = sc.nextInt();
            int point2 = sc.nextInt();
            adjList[point1].add(point2);
        }
    }
    
    void findParentNode(){
        // first perform dfs for every node in list using for loop and store the last node of dfs in v
        // then perform dfs/bfs from last node v
        // then check if every node if visited on not
        //O(V+E)
        boolean vis[] = new boolean[adjList.length];
        for(int i=0;i<vis.length;i++)
            vis[i] = false;
        int v=0;
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                stack = new Stack<>();
                stack.push(i);

                while(!stack.isEmpty()){
                    int val = stack.pop();
                    if(!vis[val]){
                        vis[val] = true;
                    }
                    itr = adjList[val].iterator();
                    while(itr.hasNext()){
                        int data = itr.next();
                        if(!vis[data])
                            stack.add(data);
                    }
                }
                v=i;
            }
        }
        System.out.print("v:-"+v);
        for(int i=0;i<vis.length;i++)
            vis[i] = false;
        
        queue = new LinkedList<>();
        queue.add(v);
        while(!queue.isEmpty()){
            int val = queue.poll();
            if(!vis[val]){
                vis[val] = true;
            }
            itr = adjList[val].iterator();
            while(itr.hasNext()){
                int data = itr.next();
                if(!vis[data])
                    queue.add(data);
            }
        }
        boolean flag=true;
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                flag=false;
                break;
            }
        }
        if(flag)
            System.out.print("\nNode "+v+" is parent node");
        else
            System.out.print("\nNo parent node");
        
    }
    
    void detectCycle(){
        boolean vis[] = new boolean[adjList.length];
        for(int i=0;i<vis.length;i++)
            vis[i] = false;
        
        queue = new LinkedList<>();
        queue.add(0);
        boolean flag = true;
        while(!queue.isEmpty()){
            int val = queue.poll();
            if(!vis[val]){
                vis[val] = true;
            }
            itr = adjList[val].iterator();
            while(itr.hasNext()){
                int data = itr.next();
                if(!vis[data])
                    queue.add(data);
                else{
                    flag=false;
                    break;
                }
            }
            if(!flag)
                break;
        }
        if(!flag)
            System.out.println("\nGraph contain loop");
        else
            System.out.println("\nNo loop");
    }
    
    void shortestPath(int src, int dest){
        boolean vist[] = new boolean[V];
        int dist[] = new int[V];
        int pre[] = new int[V];
        boolean flag = false;
        for(int i=0;i<V;i++){
            pre[i]=-1;
            vist[i]= false;
            dist[i] = Integer.MAX_VALUE;
        }
        vist[src]=true;
        dist[src]=0;
        queue = new LinkedList<>();
        queue.add(src);
        
        while(!queue.isEmpty()){
            int val = queue.poll();
            itr = adjList[val].iterator();
            while(itr.hasNext()){
                int data = itr.next();
                if(!vist[data]){
                    vist[data]=true;
                    dist[data] = dist[val]+1;
                    pre[data]=val;
                    queue.add(data);
                    if(data==dest){
                        flag=true;
                        break;
                    }
                }
            }
            if(flag)
                break;
        }
        List<Integer> path = new LinkedList<>();
        if(flag){
            int crawl = dest;
            path.add(crawl);
            while(pre[crawl]!=-1){
                path.add(pre[crawl]);
                crawl = pre[crawl];
            }
            System.out.println("\nPath Length: "+dist[dest]+" path:-"+path);
        }
        else{
            System.out.println("\nNo path between src and dis");
        }
        
    }
    
    void createWightedGraph(int vertex){
        adjlist = new LinkedList[vertex];
        for(int i=0;i<vertex;i++){
            adjlist[i] = new LinkedList<>();
        }
        int edges= sc.nextInt();
        for(int i=0;i<edges;i++){
            int point1 = sc.nextInt();
            int point2 = sc.nextInt();
            int weight = sc.nextInt();
            WeightedGraph edge = new WeightedGraph(point2, weight);
            adjlist[point1].add(edge);
        }
        System.out.print("\nPrint weighted graph:\n");
        for(int i=0;i<vertex;i++){
            int count=adjlist[i].size();
            int j=0;
            System.out.print("s("+i+"):-->");
            while(count-->0){
                WeightedGraph e = adjlist[i].get(j);
                System.out.print("w("+e.weight+")--d("+e.dest+"), ");
                j++;
            }
            System.out.print("\n");
        }
    }
    
    void dijkstraShortestPath(int src,int vertex){
        PriorityQueue<WeightedGraph> pq = new PriorityQueue<>(vertex,new WeightedGraph());
        Set<Integer>set = new HashSet<>();
        int dist[] = new int[vertex];
        for(int i=0;i<vertex;i++)
            dist[i]=Integer.MAX_VALUE;
        dist[src]=0;
        pq.add(new WeightedGraph(src, 0));
        
        while(set.size()!=vertex){
            int val = pq.remove().dest;
            set.add(val);
            itr1 =  adjlist[val].iterator();
            while(itr1.hasNext()){
                WeightedGraph e = itr1.next();
                if(!set.contains(e.dest)){
                    int newDist = dist[val]+e.weight;
                    if(dist[e.dest]>newDist)
                        dist[e.dest] = newDist;
                    pq.add(new WeightedGraph(e.dest, dist[e.dest]));
                }
            }
        }
        
        for (int i = 0; i < dist.length; i++) 
            System.out.println(src + " to " + i + " is "
                               + dist[i]); 
    }
    
    void createUndirWightedGraph(int vertex){
        adjlist = new LinkedList[vertex];
        for(int i=0;i<vertex;i++){
            adjlist[i] = new LinkedList<>();
        }
        int edges= sc.nextInt();
        for(int i=0;i<edges;i++){
            int point1 = sc.nextInt();
            int point2 = sc.nextInt();
            int weight = sc.nextInt();
            WeightedGraph edge1 = new WeightedGraph(point2, weight);
            WeightedGraph edge2 = new WeightedGraph(point1, weight);
            adjlist[point1].add(edge1);
            adjlist[point2].add(edge2);
        }
        System.out.print("\nPrint weighted graph:\n");
        for(int i=0;i<vertex;i++){
            int count=adjlist[i].size();
            int j=0;
            System.out.print("s("+i+"):-->");
            while(count-->0){
                WeightedGraph e = adjlist[i].get(j);
                System.out.print("w("+e.weight+")--d("+e.dest+"), ");
                j++;
            }
            System.out.print("\n");
        }
    }
    
    void prismAlgo(int src,int vertex){
        PriorityQueue<WeightedGraph> pq = new PriorityQueue<>(vertex,new WeightedGraph());
        Set<Integer>set = new HashSet<>();
        int dist[] = new int[vertex];
        int path[] = new int[vertex];
        for(int i=0;i<vertex;i++)
            dist[i]=Integer.MAX_VALUE;
        dist[src]=0;
        pq.add(new WeightedGraph(src, 0));
        
        while(set.size()!=vertex){
            int val = pq.remove().dest;
            set.add(val);
            itr1 =  adjlist[val].iterator();
            while(itr1.hasNext()){
                WeightedGraph e = itr1.next();
                System.out.println("set:-"+set);
                if(!set.contains(e.dest)){
                    int newDist = dist[val]+e.weight;
                    if(dist[e.dest]>newDist){
                        dist[e.dest] = e.weight;}
                    path[e.dest]=e.dest;
                    pq.add(new WeightedGraph(e.dest, dist[e.dest]));
                }
            }
        }
        System.out.print("\nPrinting path\n");
        for (int i = 0; i < dist.length; i++) 
            System.out.println(path[i]+" ");
        
        
    }
}