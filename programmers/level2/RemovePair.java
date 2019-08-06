package level2;

import java.util.Stack;

public class RemovePair {
	
	public static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		
		stack.push(s.charAt(0));
		for(int i = 1; i < s.length(); i++) {
			if(!stack.isEmpty() && stack.peek() == s.charAt(i))
				stack.pop();
			else
				stack.push(s.charAt(i));
		}
		
		if(stack.isEmpty())
			return 1;
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("baabaa"));
	}

}
