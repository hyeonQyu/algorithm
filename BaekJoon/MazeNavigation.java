import java.io.*;
import java.util.*;

public class MazeNavigation {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        
        byte[][] maze = new byte[n][m];
        // (0,0)으로부터 해당 위치까지의 최단 거리
        int[][] count = new int[n][m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                maze[i][j] = (byte) (s.charAt(j) - '0');
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        int[] coord = new int[2];
        coord[0] = coord[1] = 0;
        count[0][0] = 1;
        q.offer(coord);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            int nextCount = count[i][j] + 1;
            
            // 아래
            try{
                if(maze[i + 1][j] == 1){
                    enqueue(q, i + 1, j, count, nextCount);
                }
            } catch(Exception e){}                  
            // 오른쪽
            try{
                if(maze[i][j + 1] == 1){
                	enqueue(q, i, j + 1, count, nextCount);
                }
            } catch(Exception e){}
            // 왼쪽
            try{
                if(maze[i][j - 1] == 1){
                	enqueue(q, i, j - 1, count, nextCount);
                }
            } catch(Exception e){}
            // 위
            try{
                if(maze[i - 1][j] == 1){
                	enqueue(q, i - 1, j, count, nextCount);
                }
            } catch(Exception e){}
            
        }

        System.out.println(count[n - 1][m - 1]);
    }
	
	private static void enqueue(Queue<int[]> q, int i, int j, int[][] count, int nextCount) {
		if(count[i][j] == 0){
            count[i][j] = nextCount;
            int[] next = new int[2];
            next[0] = i;
            next[1] = j;
            q.offer(next);
        }
	}

}
