package level1;

public class XnNum {
	
	public static long[] solution(int x, int n) {
		long[] list = new long[n];
		long temp = x;
		
		for(int i = 0; i < n; i++) {
			list[i] = temp;
			temp += x;
		}
		
		return list;
	}

}
