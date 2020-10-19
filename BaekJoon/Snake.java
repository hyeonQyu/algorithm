import java.io.*;
import java.util.*;

public class Snake {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		byte[][] board = new byte[n][n];
		
		int loop = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 0; t < loop; t++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			board[r][c] = 1;
		}
		
		loop = Integer.parseInt(br.readLine());
		int[] times = new int[loop];
		char[] vectors = new char[loop];
		for(int t = 0; t < loop; t++) {
			st = new StringTokenizer(br.readLine());
			times[t] = Integer.parseInt(st.nextToken());
			vectors[t] = st.nextToken().charAt(0);
		}
		
		LinkedList<int[]> snake = new LinkedList<>();
		int[] start = {0, 0};
		snake.add(start);
		board[0][0] = 2;
		
		int vector = 0;
		int index = 0;
		int time = 0;
		// 1은 사과자리, 2는 뱀이 위치한 곳
		while(true) {
			// 방향 변경
			try {
				if(time == times[index]) {
					vector = getNextVector(vector, vectors[index]);
					index++;
				}				
			} catch (Exception e) {}
			
			time++;
			
			// 머리 이동
			try {
				move(board, snake, vector);				
			} catch (Exception e) {
				break;
			}
		}
		
		System.out.println(time);
	}

	static int getNextVector(int vector, char rotation) {
		int next;
		if(rotation == 'D')
			next = (vector + 1) % 4;
		else
			next = (vector + 3) % 4;
		return next;
	}
	
	static void move(byte[][] board, LinkedList<int[]> snake, int vector) throws Exception{
		// 현재 머리
		int[] cur = snake.getFirst();
		
		int[] next = getNextHead(cur, vector);
		int nextBoard = board[next[0]][next[1]];
		
		// 머리 이동
		snake.addFirst(next);
		board[next[0]][next[1]] = 2;
		// 꼬리 제거
		if(nextBoard == 0) {
			int[] tail = snake.removeLast();
			board[tail[0]][tail[1]] = 0;
		}
		// 자기 자신에 닿음
		else if(nextBoard == 2)
			throw new Exception();
	}
	
	static int[] getNextHead(int[] cur, int vector) {
		int[] next = {cur[0], cur[1]};

		switch (vector) {
		case 0:
			next[1]++;
			break;		
		case 1:
			next[0]++;
			break;			
		case 2:
			next[1]--;
			break;			
		case 3:
			next[0]--;
			break;
		}
		
		return next;
	}
}
