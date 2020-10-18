import java.io.*;
import java.util.*;

public class TreasureIsland {
	static char[][] map;
	static boolean[][] isVisit;
	static int[] rows = {0, 0, 1, -1};
	static int[] cols = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		map = new char[row][col];
		for(int i = 0; i < row; i++) {
			String s = br.readLine();
			for(int j = 0; j < col; j++)
				map[i][j] = s.charAt(j);
		}
		

		isVisit = new boolean[row][col];
		int max = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j] == 'L') {
					isVisit = new boolean[row][col];
					isVisit[i][j] = true;
					max = Math.max(max, bfs(i, j));
				}
			}
		}
		
		System.out.println(max);
	}
	
	static int bfs(int y, int x) {
		int max = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		int[] start = {y, x, 0};
		q.add(start);
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			max = Math.max(max, cur[2]);
			
			for(int i = 0; i < 4; i++) {
				int r = cur[0] + rows[i];
				int c = cur[1] + cols[i];
				
				try {
					if(isVisit[r][c] || map[r][c] == 'W')
						continue;
					
					isVisit[r][c] = true;
					int[] next = {r, c, cur[2] + 1};
					q.add(next);					
				} catch (Exception e) {}
			}
		}
		return max;
	}
}
