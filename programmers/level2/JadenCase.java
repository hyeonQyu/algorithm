package level2;

public class JadenCase {

	public String solution(String s) {
		int length = s.length();
		String answer = "";
		
		char c = s.charAt(0);
		if(Character.isLetter(c))
			answer += Character.toString(c).toUpperCase();
		else
			answer += c;
		
		boolean isFirst = false;
		for(int i = 1; i < length; i++) {
			c = s.charAt(i);
			
			if(c == ' ') {
				isFirst = true;
				answer += c;
				continue;
			}
			
			if(Character.isDigit(c))
				answer += c;
			else {
				if(isFirst)
					answer += Character.toString(c).toUpperCase();
				else
					answer += Character.toString(c).toLowerCase();
			}
			isFirst = false;
		}
		
		return answer;
	}

}
