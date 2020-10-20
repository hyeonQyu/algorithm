import java.io.*;
import java.util.*;

public class Tetromino{
    static int[][] board;
    static boolean[][] isVisit;
    static int[] rows = {0, 0, 1, -1};
    static int[] cols = {1, -1, 0, 0};
    static int max = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        board = new int[row][col];
        isVisit = new boolean[row][col];
        
        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                isVisit[i][j] = true;
                dfs(i, j, board[i][j], 1);
                isVisit[i][j] = false;
                
                other(i, j);
            }
        }
        
        System.out.println(max);
    }
    
    static void other(int y, int x) {    	
    	try {
    		max = Math.max(max, board[y][x] + case1(y, x));    		
    	} catch (Exception e) {}
    	try {
    		max = Math.max(max, board[y][x] + case2(y, x));    		
    	} catch (Exception e) {}
    	try {
    		max = Math.max(max, board[y][x] + case3(y, x));    		
    	} catch (Exception e) {}
    	try {
    		max = Math.max(max, board[y][x] + case4(y, x));    		
    	} catch (Exception e) {}
    }
    
    static int case1(int y, int x) throws Exception{
    	return board[y][x - 1] + board[y - 1][x] + board[y + 1][x];
    }
    
    static int case2(int y, int x) {
    	return board[y + 1][x] + board[y - 1][x] + board[y][x + 1];
    }
    	
    static int case3(int y, int x) {
    	return board[y][x - 1] + board[y][x + 1] + board[y + 1][x];
    }

	static int case4(int y, int x) {
		return board[y][x - 1] + board[y][x + 1] + board[y - 1][x];
	}
    
    static void dfs(int y, int x, int sum, int time){
        if(time == 4){
            max = Math.max(sum, max);
            return;
        }
        for(int i = 0; i < 4; i++){
            int r = y + rows[i];
            int c = x + cols[i];
            try{
                if(!isVisit[r][c]){
                    isVisit[r][c] = true;
                    dfs(r, c, sum + board[r][c], time + 1);
                    isVisit[r][c] = false;
                }
            } catch(Exception e){}
        }
    }
}