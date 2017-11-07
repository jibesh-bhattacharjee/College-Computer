package graphadjacencylist;

import java.util.LinkedList;
import java.util.Scanner;

public class GraphAdjacencyList {

    static class Graph{
        //Instance Vars
        int V;
        LinkedList<Integer>[] adjListArray;
        //Constructor
        Graph(int V){
            this.V = V; //the no. of vertices of this graph will be the number of vertices passed in as argument to constructor
            //instansiate the array of linked list 
            adjListArray = new LinkedList[V];
            //instanciate all the linked lists in the array
            for(int i=0;i<V;i++){
                adjListArray[i] = new LinkedList<Integer>();
            }
            
        }
    }
    //*******************************************************************************************************
    static void addEdge(Graph graph,int src,int dest){
        graph.adjListArray[src].add(dest);
        graph.adjListArray[dest].add(src);
    }
    //*******************************************************************************************************
    static void printGraph(Graph graph){
        for(int i=0;i<graph.V;i++){
            System.out.print("Head:" + i);
            for(Integer adjVertices: graph.adjListArray[i]){
                System.out.print("->" + adjVertices);
            }
            System.out.println("\n");
        }
    }
    //*******************************************************************************************************
    public static void main(String[] args) {
        //Utils
        Scanner in = new Scanner(System.in);
        //Vars
        int V;
        int E;
        
        //program
        System.out.print("Enter the no. of vertices: ");
        V = in.nextInt();
        Graph graph = new Graph(V);
        System.out.println("Enter the no. edges you want: ");
        E = in.nextInt();
        System.out.println("Enter the edges:");
        for(int i=0;i<E;i++){
            System.out.println("Edge-"+(i+1) + ": ");
            int src = in.nextInt();
            int dest = in.nextInt();
            addEdge(graph,src,dest);
        }
        
        System.out.println("The resultant graph is:\n");
        printGraph(graph);
    }
    
}
