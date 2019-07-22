package level2;

public class Num124 {
	
	public static String solution(int n) {
		String answer = "";
		int ten = 1;
		int quot, rest;
		
		quot = n;
		while(quot >= 1) {
			rest = quot % 3;
			quot = quot / 3;
			
			if(rest == 0) {
				quot -= 1;
				rest = 4;
			}
			
			answer += rest;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(5));
	}

}
