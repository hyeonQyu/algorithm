package level2;

public class NextBiggerNum {
	
	public static int solution(int n) {
		String s = Integer.toBinaryString(n);
		int countOne = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '1')
				countOne++;
		}
		
		int count = 0;
		while(count != countOne) {
			count = 0;
			n++;
			s = Integer.toBinaryString(n);
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '1')
					count++;
			}
		}
		
		return n;
	}

}
