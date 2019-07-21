package level1;

import java.util.Arrays;

public class IntegerDesc {
	
	public static long solution(long n) {
		String str = Long.toString(n);
		long[] arr = new long[str.length()];
		
		int index = 0;
		while(n > 0) {
			arr[index++] = n % 10;
			n /= 10;
		}
		Arrays.sort(arr);
		
		long answer = 0;
		long ten = 1;
		for(int i = 0; i < arr.length; i++) {
			answer += ten * arr[i];
			ten *= 10;
		}
		
		return answer;
	}

}
