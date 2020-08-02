import java.io.*;
import java.util.*;

public class Tomatoes {
static int day = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int m = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);
        int h = Integer.parseInt(arr[2]);
        
        int rows = n * h;
        int[][] board = new int[rows][];
        int[][] days = new int[rows][];
        int rest = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < rows; i++){
            board[i] = new int[m];
            days[i] = new int[m];
            arr = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(arr[j]);
                // 익지 않은 토마토 수
                if(board[i][j] == 0)
                    rest++;
                else if(board[i][j] == 1){
                    int[] tmp = {i, j};
                    q.add(tmp);
                }
            }
        }
                
        while(!q.isEmpty()){           
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int curDay = days[r][c];
            
            // 인접한 익지 않은 토마토 검사
            rest -= checkAddQ(board, r, c + 1, days, curDay, q);
            rest -= checkAddQ(board, r, c - 1, days, curDay, q);
            if((r + 1) % n != 0)
            	rest -= checkAddQ(board, r + 1, c, days, curDay, q);
            if(r % n != 0)
            	rest -= checkAddQ(board, r - 1, c, days, curDay, q);
            rest -= checkAddQ(board, r + n, c, days, curDay, q);
            rest -= checkAddQ(board, r - n, c, days, curDay, q);
        }
        
        if(rest > 0)
            day = -1;
        System.out.println(day);
    }
    
    private static int checkAddQ(int[][] board, int r, int c, int[][] days, int curDay, Queue<int[]> q){
        try{
            if(board[r][c] == 0){
                // 새 토마토가 익음
                days[r][c] = curDay + 1;
                day = days[r][c];
                board[r][c] = 1;
                int[] tmp = {r, c};
                q.add(tmp);
                return 1;
            }
        } catch(Exception e){}
        return 0;
    }
}
