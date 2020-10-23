import java.io.*;
import java.util.*;

public class Gear {
	static int[][] gears = new int[5][8];
	static int[] tops = new int[5];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 1; i < 5; i++) {
			String s = br.readLine();
			for(int j = 0; j < 8; j++) {
				gears[i][j] = s.charAt(j) - '0';
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int vector = Integer.parseInt(st.nextToken());
			
			rotate(index, vector);
		}
		
		int total = 0;
		int score = 1;
		for(int i = 1; i < 5; i++) {
			if(gears[i][tops[i]] == 1)
				total += score;
			score *= 2;
		}
		
		System.out.println(total);
	}
	
	static void rotate(int index, int vector) {
		int right = (tops[index] + 2) % 8;
		int left = (tops[index] + 6) % 8;
		
		rotateSide(index + 1, -vector, right, true);
		rotateSide(index - 1, -vector, left, false);
		
		changeTop(index, vector);
	}
	
	static void rotateSide(int index, int vector, int side, boolean isRight) {
		if(index == 5 || index == 0)
			return;

		int mySide = 0;
		int next = 0;
		// 왼쪽 인덱스를 구함
		if(isRight) {
			mySide = (tops[index] + 6) % 8;
			next = 1;
		}
		// 오른쪽 인덱스를 구함
		else {
			mySide = (tops[index] + 2) % 8;
			next = -1;
		}
		
		// 회전할 필요 없음
		if(gears[index][mySide] == gears[index - next][side])
			return;
		rotateSide(index + next, -vector, (mySide + 4) % 8, isRight);
		
		changeTop(index, vector);
	}
	
	static void changeTop(int index, int vector) {
		tops[index] -= vector;
		tops[index] += 8;
		tops[index] %= 8;
	}
}
