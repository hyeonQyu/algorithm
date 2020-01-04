package kakao;

public class StringCompression {
	
	public int solution(String s) {
		int strLength = s.length();
		if(strLength == 1)
			return 1;
		int length = strLength / 2;
		
		int min = 1000;
		String answer = "";
		
		// i는 문자열을 자르는 단위
		for(int i = 1; i <= length; i++) {
			int count = 1;
			String compression = "";
			
			String tmp1 = s.substring(0, i);
			for(int j = i; j <= (strLength / i) * i; j = j + i) {
				String tmp2;
				try {
					tmp2 = s.substring(j, j + i);					
				} catch(Exception e) {
					tmp2 = s.substring(j, strLength);
				}

				if(tmp1.equals(tmp2)) {
					count++;
				}
				else {
					// 이전의 내용 넣음
					if(count > 1) {
						compression = compression + Integer.toString(count) + tmp1;
					}
					else {
						compression += tmp1;
					}
					count = 1;
				}
				
				tmp1 = tmp2;
			}
			
			if(count > 1) {
				compression = compression + Integer.toString(count) + tmp1;
			}
			else {
				compression += tmp1;
			}
			
			System.out.println(compression);
			if(min > compression.length()) {
				min = compression.length();
				answer = compression;
			}
		}
		
		System.out.println(answer);
		return min;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StringCompression().solution("abcabcdede");
	}

}
