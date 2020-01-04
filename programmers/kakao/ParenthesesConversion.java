package kakao;

public class ParenthesesConversion {
	
	public String solution(String p) {
		if(p.equals(""))
			return "";
		
		return convert(p, 0);
	}
	
	String convert(String p, int start) {
		int open = 0;
		int close = 0;
		StringBuilder u = new StringBuilder();
		
		
		for(int i = start; i < p.length(); i++) {
			char c = p.charAt(i);
			
			if(c == '(')
				open++;
			else
				close++;
			
			u.append(c);
			
			// 균형잡힌 괄호 문자열 u가 분리됨
			if(open == close) {
				// u가 올바른 괄호 문자열이 아님
				if(u.charAt(0) == ')') {
					StringBuilder tmp = new StringBuilder("(");
					// v를 이어붙임
					tmp.append(convert(p, i + 1));
					tmp.append(')');
					
					// 뒤집은 u를 이어붙임
					for(int j = 1; j < u.length() - 1; j++) {
						if(u.charAt(j) == '(')
							tmp.append(')');
						else
							tmp.append('(');
					}
					return tmp.toString();
				}
				u.append(convert(p, i + 1));
				break;
			}
		}
		return u.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ParenthesesConversion().solution("()))((()");
	}

}
