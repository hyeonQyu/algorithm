package level1;

import java.util.Arrays;

public class Budget {
	
	public static int solution(int[] d, int budget) {
		Arrays.sort(d);
		int result = 0;
		
		for(int i = 0; i < d.length; i++) {
			budget -= d[i];
			if(budget < 0)
				break;
			result++;
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
