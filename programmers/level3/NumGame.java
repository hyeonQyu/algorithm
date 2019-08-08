package level3;

import java.util.Arrays;

public class NumGame {
	
	public int solution(int[] A, int[] B) {
		int point = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		
		int j = 0;
		for(int i = 0; i < B.length; i++) {
			if(A[j] < B[i]) {
				j++;
				point++;
			}
		}
		
		return point;
	}

}
