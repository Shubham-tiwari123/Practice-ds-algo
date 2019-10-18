package datastructures;

import java.util.Scanner;

public class Graph2 extends Graph{
    
    //minimum cost required to connect all the roads
    
    int findMin(Boolean visited[],int cost[]){
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i=0;i<cost.length;i++){
            if(visited[i]==false && cost[i]<min){
                min = cost[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    void MST(){
        int mat[][] = {{ 0, 2, 0, 6, 0 }, 
                        { 2, 0, 3, 8, 5 }, 
                        { 0, 3, 0, 0, 7 }, 
                        { 6, 8, 0, 0, 9 }, 
                        { 0, 5, 7, 9, 0 } };
        //find mst 
        int ver=5;
        int parent[] = new int[ver];
        int cost[] = new int[ver];
        Boolean visited[]= new Boolean[ver];
        
        for(int i=0;i<ver;i++){
            parent[i]=-1;
            visited[i]=false;
            cost[i] =Integer.MAX_VALUE;
        }
        parent[0]=-1;
        cost[0]=0;
        for(int i=0;i<ver-1;i++){
            int u = findMin(visited, cost);
            visited[u] = true;
            for(int v=0;v<ver;v++){
                if(mat[u][v]!=0 && visited[v]==false && mat[u][v]<cost[v]){
                    parent[v]=u;
                    cost[v] = mat[u][v];
                }
            }
        }
        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < ver; i++) 
            System.out.println(parent[i] + " - " + i + "\t" + mat[i][parent[i]]);
    }
    
    void connectAllRoads(){
        int mat[][] = {{0, 1, 1, 100, 0, 0},
                        {1, 0, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0, 0},
                        {100, 0, 0, 0, 2, 2},
                        {0, 0, 0, 2, 0, 2},
                        {0, 0, 0, 2, 2, 0}};
        //find mst 
        int ver=6;
        int parent[] = new int[ver];
        int cost[] = new int[ver];
        Boolean visited[]= new Boolean[ver];
        
        for(int i=0;i<ver;i++){
            parent[i]=-1;
            visited[i]=false;
            cost[i] =Integer.MAX_VALUE;
        }
        parent[0]=-1;
        cost[0]=0;
        for(int i=0;i<ver-1;i++){
            int u = findMin(visited, cost);
            visited[u] = true;
            for(int v=0;v<ver;v++){
                if(mat[u][v]!=0 && visited[v]==false && mat[u][v]<cost[v]){
                    parent[v]=u;
                    cost[v] = mat[u][v];
                }
            }
        }
        //add all the cost to find mincost:-
        int sum=0;
        for (int i = 1; i < ver; i++) 
            sum = sum+cost[i]; 
        System.out.print("\nMinimum cost required:-"+sum+"\n"); 
    }
}
