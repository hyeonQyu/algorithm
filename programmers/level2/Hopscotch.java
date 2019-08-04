package level2;

public class Hopscotch {
	
	int solution(int[][] land) {
		
		for(int i = land.length - 2; i >= 0; i--) {
			int[] max = new int[4];
			
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 4; k++) {
					if(j != k) {
						if(max[j] < land[i + 1][k])
							max[j] = land[i + 1][k];
					}
				}
				land[i][j] += max[j];
			}
		}
		
		int max = 0;
		for(int i = 0; i < 4; i++) {
			if(max < land[0][i])
				max = land[0][i];
		}
		
		return max;
	
	}

}
