package level1;

public class WatermellonString {
	
	public static String solution(int n) {
		String watermellon = "¼ö¹Ú";
		String answer = "";
		
		for(int i = 0; i < n/2; i++) {
			answer += watermellon;
		}
		
		if(n % 2 == 1)
			answer += "¼ö";
		
		return answer;
	}

}
