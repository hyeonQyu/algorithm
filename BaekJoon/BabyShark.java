import java.io.*;
import java.util.*;

public class BabyShark {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] sea = new int[n][n];
		int[] start = new int[3];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if(sea[i][j] == 9) {
					start[0] = i;
					start[1] = j;
					sea[i][j] = 0; 
				}
			}
		}
		
		Comparator<int[]> c = new Comparator<int[]>() {	
			@Override
			public int compare(int[] pos1, int[] pos2) {
				int c = Integer.compare(pos1[2], pos2[2]);
				if(c == 0)
					c = Integer.compare(pos1[0], pos2[0]);
				if(c == 0)
					return Integer.compare(pos1[1], pos2[1]);
				return c;
			}
		};
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(c);
		pq.add(start);
		int size = 2;
		int count = 0;
		int turn = 0;
		int[] rows = {-1, 0, 0, 1};
		int[] cols = {0, -1, 1, 0}; 
		boolean[][] isVisit = new boolean[n][n];
		isVisit[start[0]][start[1]] = true;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			// 물고기가 있음
			if(sea[cr][cc] > 0) {
				// 먹을 수 있는 물고기
				if(sea[cr][cc] < size) {
					sea[cr][cc] = 0;
					if(++count == size) {
						size++;
						count = 0;
					}
					turn = cur[2];
					
					pq = new PriorityQueue<int[]>(c);
					isVisit = new boolean[n][n];
				}
			}
			
			// 다음으로 이동
			for(int i = 0; i < 4; i++) {
				int nr = cr + rows[i];
				int nc = cc + cols[i];
				
				try {
					if(isVisit[nr][nc] || size < sea[nr][nc])
						continue;
					int[] next = {nr, nc, cur[2] + 1};
					pq.add(next);
					isVisit[nr][nc] = true;
				} catch (Exception e) {}
			}
		}
		System.out.println(turn);
	}
}
