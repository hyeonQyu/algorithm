import java.io.*;
import java.util.*;

public class Wedding {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        boolean[][] adj = new boolean[n + 1][];
        for(int i = 1; i < n + 1; i++){
            adj[i] = new boolean[n + 1];
        }
        
        for(int i = 0; i < m; i++){
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            adj[a][b] = true;
            adj[b][a] = true;
        }
        
        int[] levels = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        levels[1] = 1;
        int count = 0;
        while(!q.isEmpty()){
            int tmp = q.poll();
            
            if(levels[tmp] >= 3)
                continue;
            
            for(int i = 1; i < n + 1; i++){
                if(adj[tmp][i] && levels[i] == 0){
                    q.add(i);
                    levels[i] = levels[tmp] + 1;
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
