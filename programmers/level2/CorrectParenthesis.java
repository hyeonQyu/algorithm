package level2;

public class CorrectParenthesis {
	
	boolean solution(String s) {
		int stackSize = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char parenthesis = s.charAt(i);
			if(parenthesis == '(') {
				stackSize++;
			}
			else {
				// 닫는 괄호
				if(stackSize == 0)
					return false;
				stackSize--;
			}
		}
		
		if(stackSize == 0)
			return true;
		return false;
	}

}
