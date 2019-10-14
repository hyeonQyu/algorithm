package level3;

public class LongestPalindrome {
	
	public int solution(String s) {
		int max = 0;
		boolean isEven = true;
		boolean finalIsEven = true;
		
		for(int i = 0; i < s.length() - 1;) {
			int k = 1;
			for(k = 1; i + k < s.length(); k++) {
				if(s.charAt(i) != s.charAt(i + k))
					break;
			}
			
			int j = 1;
			// 중심이 짝수개
			if(k % 2 == 0) {
				isEven = true;
				// 중심 위치 변경
				i += (k / 2);
				
				for(j = k / 2; i - j - 1 >= 0 && i + j <= s.length() - 1; j++) {
					// i번째의 단어 기준으로 왼쪽 오른쪽 단어가 다르면
					if(s.charAt(i - j - 1) != s.charAt(i + j))
						break;
				}
			}
			// 중심이 홀수개
			else {
				isEven = false;
				// 중심 위치 변경
				i += (k / 2);
				
				for(j = (k + 1) / 2; i - j >= 0 && i + j <= s.length() - 1; j++) {
					// i번째의 단어 기준으로 왼쪽 오른쪽 단어가 다르면
					if(s.charAt(i - j) != s.charAt(i + j))
						break;
				}	
			}		
			
			if(max < j) {
				max = j;
				finalIsEven = isEven;
			}
			
			if(isEven)
				i += (k / 2);
			else
				i += (k / 2) + 1;
		}
		
		if(max == 0)
			return 1;
		if(finalIsEven)
			return max * 2;
		return (max * 2) - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestPalindrome().solution("abbbcc"));
	}

}
