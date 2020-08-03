import java.io.*;
import java.util.*;

public class KnightMove{
    static int[] rowArr = {1, 1, -1, -1, 2, 2, -2, -2};
    static int[] colArr = {2, -2, 2, -2, 1, -1, 1, -1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] coord = new int[2][];
            for(int i = 0; i < 2; i++){
                coord[i] = new int[2];
                String[] arr = br.readLine().split(" ");
                for(int j = 0; j < 2; j++){
                    coord[i][j] = Integer.parseInt(arr[j]);
                }
            }
            sb.append(bfs(coord, n));
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    private static int bfs(int[][] coord, int n){
        boolean[][] isVisit = new boolean[n][];
        for(int i = 0; i < n; i++)
            isVisit[i] = new boolean[n];
        
        int[] dest = coord[1];
        int[] first = {coord[0][0], coord[0][1], 0};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(first);
        int[] cur = null;
        while(!q.isEmpty()){
            cur = q.poll();
            if(cur[0] == dest[0] && cur[1] == dest[1])
                break;
            
            for(int i = 0; i < 8; i++){
                int r = cur[0] + rowArr[i];
                int c = cur[1] + colArr[i];
                
                try {
                	if(isVisit[r][c])
                		continue;
                	
                	int tmp[] = {r, c, cur[2] + 1};
                	q.add(tmp);
                	isVisit[r][c] = true;                	
                } catch (Exception e) {}
            }
        }
        
        return cur[2];
    }
}