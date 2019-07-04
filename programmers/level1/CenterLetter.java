package level1;

public class CenterLetter {

	public static String solution(String s) {
		int length = s.length();
		int half = length / 2;
		
		if(length % 2 == 1) {
			return s.substring(half, half + 1);
		}
		else {
			return s.substring(half - 1, half + 1);
		}
	}

}
