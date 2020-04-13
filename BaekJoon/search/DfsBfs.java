package search;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class DfsBfs {
	
    static int n;
    static boolean[][] adj;
    static boolean[] check;
    static int visit = 0;
    static Queue<Integer> q = new LinkedList<>();
    static HashSet<Integer> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        String[] arr = s.split(" ");
        n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int v = Integer.parseInt(arr[2]);
        
        adj = new boolean[n + 1][n + 1];
        check = new boolean[n + 1];
        for(int i = 0; i < m; i++){
            s = br.readLine();
            arr = s.split(" ");
            int v1 = Integer.parseInt(arr[0]);
            int v2 = Integer.parseInt(arr[1]);
            
            adj[v1][v2] = true;
            adj[v2][v1] = true;
            
            set.add(v1);
            set.add(v2);
        }
        
        dfs(v);
        
        System.out.println();
        for(int i = 1; i < n + 1; i++){
            check[i] = false;
        }
        visit = 0;
        
        bfs(v);
    }
    
    private static void dfs(int v){
        System.out.print(v + " ");
    	check[v] = true;
        visit++;
        
        if(visit == set.size())
            return;
        
        for(int i = 1; i < n + 1; i++){
            // 인접하고 방문하지 않은 노드라면
            if(adj[v][i] && !check[i]){
                dfs(i);
            }
        }
    }
    
    private static void bfs(int v){
        q.add(v);
        check[v] = true;
        visit++;
        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur + " ");
            
            for(int i = 1; i < n + 1; i++){
                // 인접하고 방문하지 않은 노드라면
                if(adj[cur][i] && !check[i]){
                    q.add(i);
                    check[i] = true;
                    visit++;
                }
            }
        }
    }

}
