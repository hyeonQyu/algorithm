package kakao;

import java.util.Arrays;

public class Balance {
	
	public int solution(int[] weight) {
		Arrays.sort(weight);
		
		int sum = weight[0];
		for(int i = 1; i < weight.length; i++) {
			if(sum + 1 < weight[i])
				break;
			sum += weight[i];
		}
		
		return sum + 1;
	}

}
