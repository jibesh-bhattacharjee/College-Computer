/**
 * Graph made with OOPs concept
 */
package graphpractice;

import java.util.LinkedList;
import java.util.Scanner;

public class GraphPractice {

    static class Graph {

        //Instance Vars
        int V;  //vertices
        LinkedList<Integer>[] adjListArray;

        //Constructor
        Graph(int V) {
            this.V = V;
            adjListArray = new LinkedList[V];
            //instanciate a new arraylist for each array element
            for (int i = 0; i < V; i++) {
                adjListArray[i] = new LinkedList<Integer>();
            }
        }
        //**********************************************************************
        void addEdge(int src, int dest) {
            this.adjListArray[src].add(dest);
            this.adjListArray[dest].add(src);
        }
        //**********************************************************************
        void printGraph() {
            for (int i = 0; i < this.V; i++) {
                System.out.print("Head:" + i);
                for (Integer adjVertices : this.adjListArray[i]) {
                    System.out.print("->" + adjVertices);
                }
                System.out.println("\n");
            }
        }
    }

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
            //addEdge(src,dest);
            graph.addEdge(src, dest);
        }
        System.out.println("The resultant graph is:\n");
        //printGraph(graph);
        graph.printGraph();
    }

}
