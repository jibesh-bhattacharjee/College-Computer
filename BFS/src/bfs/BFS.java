package bfs;

import java.util.LinkedList;

public class BFS {

    //instance variables
    private int V;
    private LinkedList<Integer>[] adjList;
    
    BFS(){
        
    }
    
    BFS(int v){
        this.V = v;
        adjList = new LinkedList[V];
        for(int i=0;i<this.V;i++){
            adjList[i] = new LinkedList();
        }
    }
    
    public void addEdge(int a,int b){
        adjList[a].add(b);
    }
    
    public void printBFS(int start){
        //the visited boolean array
        boolean[] visited = new boolean[this.V];
        //make the queue
        LinkedList<Integer> queue = new LinkedList();
        //set all values of visited to false
        for(int i=0;i<this.V;i++){
            visited[i] = false;
        }
        //set the starting vertex as visited
        visited[start] = true;
        queue.add(start);
        //now the looping for BFS
        while(queue.isEmpty() == false){
            //get the vertex from the queue
            int print = queue.poll();
            System.out.print(print + " ");
            //take all the adjecent vertices of the vertex,
            //add them to the queue if they are not visited, and
            //mark them as visited
            for(int i=0;i<adjList[print].size();i++){
                if(visited[adjList[print].get(i)] == false){
                    queue.add(adjList[print].get(i));
                    visited[adjList[print].get(i)] = true;
                }
            }
        }
    }
    
    //the main driver program
    public static void main(String[] args) {
        BFS graph = new BFS(4);
        //add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        //print the BFS of the graph
        graph.printBFS(2);
    }
    
}
