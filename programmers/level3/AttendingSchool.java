package level3;

public class AttendingSchool {
	
	public int solution(int m, int n, int[][] puddles) {
		int[][] paths = new int[m + 1][n + 1];
		// 갈수 없는 길은 -1로 만듦
		for(int i = 0; i < puddles.length; i++) {
			paths[puddles[i][0]][puddles[i][1]] = -1;
		}
		
		paths[1][0] = 1;
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				// 갈 수 없는 길이면 skip
				if(paths[i][j] == -1)
					continue;
				
				int fromLeft = paths[i][j - 1];
				int fromUp = paths[i - 1][j];
				if(fromLeft < 0)
					fromLeft = 0;
				if(fromUp < 0)
					fromUp = 0;
				
				paths[i][j] = (fromLeft + fromUp) % 1000000007;
			}
		}
		
		return paths[m][n];
	}

}
