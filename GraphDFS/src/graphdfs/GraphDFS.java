package graphdfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GraphDFS {

    //Instance Vars
    private int V;
    ArrayList<Integer>[] adjList;
    //Constructor for graph
    GraphDFS(int v){
        this.V = v;
        adjList = new ArrayList[v];
        for(int i=0;i<v;i++){
            adjList[i] = new ArrayList();
        }
    }
    
    private void addEdge(int a, int b){
        adjList[a].add(b);
    }
    
    private void DFSUtil(int v, boolean[] visited){
        visited[v] = true;
        System.out.println(v + " ");
        Iterator<Integer> i = adjList[v].listIterator();
        while(i.hasNext()){
            int nextVertex = i.next();
            if(visited[nextVertex] == false){
                DFSUtil(nextVertex,visited);
            }
        }
    }
    
    private void DFS(int startingVertex){
        boolean[] visited = new boolean[V];
        DFSUtil(startingVertex, visited);
    }
    
    public static void main(String[] args) {
        //Utils
        Scanner in = new Scanner(System.in);
        int vertices;
        vertices = 4;
        //Construct the graph
        GraphDFS graph = new GraphDFS(4);
        //Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        System.out.println("The DFS traversal result is:\n");
        graph.DFS(2); 
    }
    
}
