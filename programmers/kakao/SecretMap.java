package kakao;

public class SecretMap {
	
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		int[] arr3 = new int[n];
		int upperBit = 1 << n;
		
		for(int i = 0; i < n; i++) {
			answer[i] = "";
		}
		
		for(int i = 0; i < n; i++) {
			arr3[i] = (arr1[i] | arr2[i]) + upperBit;
			// answer[i]의 비트 수는 총 n+1개(upperBit를 더했으므로)
			String tmp = Integer.toBinaryString(arr3[i]);
			
			for(int j = 1; j <= n; j++) {
				if(tmp.charAt(j) == '1')
					answer[i] += "#";
				else
					answer[i] += " ";
			}
		}
		
		return answer;
	}

}
