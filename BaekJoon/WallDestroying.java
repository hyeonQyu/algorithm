import java.io.*;
import java.util.*;

public class WallDestroying {
	static int n, m;
    static boolean[][] board;
    static boolean[][][] isVisit;
    static Queue<int[]> q = new LinkedList<>();
    static int[] row = {0, 0, 1, -1};
    static int[] col = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new boolean[n][];
        isVisit = new boolean[n][][];
        for(int i = 0; i < n; i++){
            board[i] = new boolean[m];
            isVisit[i] = new boolean[m][];
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j) - '0' == 1 ? true : false;
                isVisit[i][j] = new boolean[2];
            }
        }
        
        // i, j, 부순 벽, 이동거리
        int[] start = {0, 0, 0, 0};
        q.add(start);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == n - 1 && cur[1] == m - 1) {
            	System.out.println(cur[3] + 1);
                return;
            }
            
            for(int i = 0; i < 4; i++){
                int r = cur[0] + row[i];
                int c = cur[1] + col[i];
                
                try{
                    if(isVisit[r][c][cur[2]])
                        continue;
                    isVisit[r][c][cur[2]] = true;
                    
                    int[] next = {r, c, cur[2], cur[3] + 1};
                    // 벽을 부숨
                    if(board[r][c])
                        next[2]++;
                    
                    if(next[2] < 2)
                        q.add(next);
                } catch(Exception e){}
            }
        }
        System.out.println(-1);
    }
}
