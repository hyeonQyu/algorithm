import java.io.*;
import java.util.*;

public class Virus {
	static boolean[][] adj;
    static boolean[] isVisit;
    static int n;
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        adj = new boolean[n + 1][];
        isVisit = new boolean[n + 1];
        for(int i = 0; i <= n; i++)
            adj[i] = new boolean[n + 1];
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = true;
            adj[b][a] = true;
        }
        
        isVisit[1] = true;
        dfs(1);
        System.out.println(count);
    }
    
    static void dfs(int cur){
        for(int i = 1; i <= n; i++){
            if(adj[cur][i] && !isVisit[i]){
                isVisit[i] = true;
                count++;
                dfs(i);
            }
        }
    }
}
