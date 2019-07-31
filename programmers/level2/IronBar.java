package level2;

public class IronBar {

	public static int solution(String arrangement) {
		int pieces = 0;
		int stackSize = 0;
		
		for(int i = 0; i < arrangement.length(); i++) {
			char shape = arrangement.charAt(i);
			
			if(shape == '(') {
				if(arrangement.charAt(i + 1) == ')')
					pieces += stackSize;
				else
					stackSize++;
			}
			
			else if(shape == ')') {		
				if(arrangement.charAt(i - 1) == ')') {
					pieces++;
					stackSize--;
				}
			}
		}
		
		return pieces;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("((()())()(()))()()"));
	}

}
