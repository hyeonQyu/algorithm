import java.io.*;
import java.util.*;

public class RobotCleaner {

	static int n, m;
	static byte[][] room;
	static int[] rows = {-1, 0, 1, 0};
	static int[] cols = {0, 1, 0, -1};
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		room = new byte[n][m];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < m; j++) {
				room[i][j] = Byte.parseByte(st.nextToken());
			}
		}
		
		clean(r, c, d);
	}
	
	static void clean(int r, int c, int vector) {
		if(room[r][c] == 0) {
			room[r][c] = 2;
			count++;
		}
		
		int lookAt = vector;
		for(int i = 0; i < 4; i++) {
			lookAt = getLeft(lookAt);
			
			int row = r + rows[lookAt];
			int col = c + cols[lookAt];
			
			if(row >= n || col >= m || row < 0 || col < 0) {
				continue;
			}
			
			if(room[row][col] > 0) {
				continue;
			}

			clean(row, col, lookAt);
			return;
		}
		
		// 청소를 못하고 후진
		int back = getBack(vector);
		int row = r + rows[back];
		int col = c + cols[back];
		if(room[row][col] == 1) {
			System.out.println(count);
			System.exit(0);
		}
		clean(row, col, vector);
	}
	
	static int getLeft(int vector) {
		return (vector + 3) % 4;
	}
	
	static int getBack(int vector) {
		return (vector + 2) % 4;
	}

}
