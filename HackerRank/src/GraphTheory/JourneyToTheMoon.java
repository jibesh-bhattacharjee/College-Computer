package GraphTheory;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Jibesh
 * Result: All Test Cases Passed
 */
public class JourneyToTheMoon {

    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static int connectedCmps;
    static int astronautCnt;
    static ArrayList<Integer> astroCountryCnt;
    
    static int dfs(int node){
        visited[node] = true;
        astronautCnt++;
        for(int v = 0; v < adjList[node].size(); v++){
            if(!visited[adjList[node].get(v)])
                dfs(adjList[node].get(v));
        }
        return astronautCnt;
    }
    
    static void addEdge(int a, int b){
        adjList[a].add(b);
        adjList[b].add(a);
    }
    
    public static void main(String[] args) {
        //Utils
        Scanner in = new Scanner(System.in);
        //StringBuilder ans = new StringBuilder();
        //Vars and Input
        int N = in.nextInt();
        int P = in.nextInt();
        
        /**
         * Instantiating adjList and visited,
         * and also astroCountryCnt
         */
        visited = new boolean[N];
        adjList = new ArrayList[N];
        for(int v=0;v<N;v++){
            adjList[v] = new ArrayList();
        }
        astroCountryCnt = new ArrayList();
        /**
         * Filling up adjList
         */
        for(int r=0;r<P;r++){
            int a = in.nextInt();
            int b = in.nextInt();
            
            addEdge(a,b);
        }
        /**
         * Finding number of connected components
         * and the number of astronauts in them
         */
        for(int v=0;v<N;v++){
            if(!visited[v]){
                astronautCnt = 0;
                dfs(v);
                connectedCmps++;
                astroCountryCnt.add(astronautCnt);
                //System.out.println("The number of astronauts is: " + astronautCnt);
            }
        }
        //System.out.println("The number of connected components is: " + connectedCmps);
        
        /**
         * Number of astronauts and connected components works fine
         */
        
        long sum = 0L;
        long result = 0L;
        
        
        for(Integer size : astroCountryCnt){
            result += sum*size;
            sum += size;
        }
        System.out.println(result);
    }
}
