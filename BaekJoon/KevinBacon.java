import java.io.*;
import java.util.*;

public class KevinBacon {
	static boolean[][] adj;
    static int[] step;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        step = new int[n + 1];
        adj = new boolean[n + 1][];
        for(int i = 1; i <= n; i++)
            adj[i] = new boolean[n + 1];
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = true;
            adj[b][a] = true;
        }
        
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 1; i <= n; i++){
            step[i] = bfs(i);
            if(min > step[i]){
                min = step[i];
                minIndex = i;
            }
        }
        System.out.println(minIndex);
    }
    
    static int bfs(int index){
        int[] step = new int[n + 1];
        Queue<int[]> q = new LinkedList<>();
        int[] first = {index, 0};
        q.add(first);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i = 1; i <= n; i++){
                // 인접하고 방문하지 않은 노드라면
                if(adj[cur[0]][i] && step[i] == 0){
                    step[i] = cur[1] + 1;
                    int[] tmp = {i, step[i]};
                    q.add(tmp);
                }
            }
        }
        
        int count = 0;
        for(int i = 1; i <= n; i++)
            count += step[i];
        return count;
    }
}
