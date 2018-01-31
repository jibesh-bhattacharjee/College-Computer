package GraphTheory;

import java.util.ArrayList;
import java.util.Scanner;

public class JourneyToTheMoon {

    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static int connectedCmps;
    
    static void dfs(int node){
        visited[node] = true;
        for(int v = 0; v < adjList[node].size(); v++){
            if(!visited[adjList[node].get(v)])
                dfs(adjList[node].get(v));
        }
    }
    
    static void addEdge(int a, int b){
        adjList[a].add(b);
        adjList[b].add(a);
    }
    
    public static void main(String[] args) {
        //Utils
        Scanner in = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        //Vars and Input
        int N = in.nextInt();
        int P = in.nextInt();
        
        adjList = new ArrayList[N];
        for()
        
        for(int r=0;r<P;r++){
            int a = in.nextInt();
            int b = in.nextInt();
            
            addEdge(a,b);
        }
        
        for(int i=0;i<)
        
        
    }
    
}
