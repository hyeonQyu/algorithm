package level1;

public class String2Integer {
	
	static int getInteger(String s) {
		return Integer.parseInt(s);
	}
	
	public static int solution(String s) {
		int answer;

		switch(s.charAt(0)) {
			case '+':
				answer = getInteger(s.substring(1, s.length()));
				break;
			case '-':
				answer = -getInteger(s.substring(1, s.length()));
				break;
			default:
				answer = getInteger(s);
				break;
		}
		
		return answer;
	}

}
