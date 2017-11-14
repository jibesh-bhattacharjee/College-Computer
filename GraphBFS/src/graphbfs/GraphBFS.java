package graphbfs;

import java.util.LinkedList;

/**
 * @author Jibesh
 * 1. First, set up the graph
 * 2. Don't forget the instance variables while your at it
 * 3. All instances created using the custom constructor
 */
public class GraphBFS {

    //instance vars
    private int V;
    private LinkedList<Integer>[] adjList;
    //default constructor
    GraphBFS(){
        
    }
    //graph creating constructor
    GraphBFS(int v){
        this.V = v;
        adjList = new LinkedList[v];
        for(int i=0;i<v;i++){
            adjList[i] = new LinkedList();
        }
    }
    //method to add edge to the graph in Adj List form
    private void addEdge(int a, int b){
        adjList[a].add(b);
    }
    //method to print BFS of the graph
    private void printBFS(int start){
        //create the visited array
        boolean[] visited = new boolean[this.V];
        //create the queue of current node elements
        LinkedList<Integer> queue = new LinkedList();
        //set all vertices as not visited
        for(int i=0;i<this.V;i++){
            visited[i] = false;
        }
        //note the starting vertex as visited
        visited[start] = true;
        //enqueue the starting vertex
        queue.add(start);
        //NOW THE PRINTING LOGIC BEGINS
        while(queue.isEmpty() == false){
            int print = queue.poll();
            System.out.print(print + " ");
            /**
             * Now. Check the adjacent vertices of the current print.
             * Enqueue the vertices not yet visited.
             * And also mark those enqueued vertices as true
             */
            for(int i=0;i<adjList[print].size();i++){
                if(visited[adjList[print].get(i)] == false){
                    queue.add(adjList[print].get(i));
                    visited[adjList[print].get(i)] = true;
                }
            }
        }
    }
    //driver program
    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS(4);
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

