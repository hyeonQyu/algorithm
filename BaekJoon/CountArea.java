import java.io.*;
import java.util.*;

public class CountArea {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int rows, cols, k;
        rows = Integer.parseInt(arr[0]);
        cols = Integer.parseInt(arr[1]);
        k = Integer.parseInt(arr[2]);
        
        boolean[][] map = new boolean[rows][];
        for(int i = 0; i < rows; i++)
            map[i] = new boolean[cols];
        
        int[][] squares = new int[k][];
        for(int i = 0; i < k; i++){
            squares[i] = new int[4];
            arr = br.readLine().split(" ");
            for(int j = 0; j < 4; j++){
                squares[i][j] = Integer.parseInt(arr[j]);
            }
            
            // 색칠
            for(int r = squares[i][1]; r < squares[i][3]; r++){
                for(int c = squares[i][0]; c < squares[i][2]; c++){
                    map[r][c] = true;
                }
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(map[i][j])
                    continue;
                
                int count = countCells(map, i, j);
                pq.add(count);
            }
        }
        
        System.out.println(pq.size());
        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }
    }
    
    private static int countCells(boolean[][] map, int i, int j){
        try{
            if(map[i][j])
                return 0;
        } catch(Exception e){
            return 0;
        }
        map[i][j] = true;
        
        return 1 + countCells(map, i, j - 1) + countCells(map, i, j + 1) + countCells(map, i - 1, j) + countCells(map, i + 1, j);
    }
}
