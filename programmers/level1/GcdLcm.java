package level1;

public class GcdLcm {
	
	public static int[] solution(int n, int m) {
		int[] answer = new int[2];
		int div;
		div = n > m ? m : n;
		
		for(int i = div; i > 0; i--) {
			if(n % i == 0 && m % i == 0) {
				int quotN = n / i;
				int quotM = m / i;
				answer[0] = i;
				answer[1] = i * quotN * quotM;
				break;
			}
		}
		return answer;
	}

}
