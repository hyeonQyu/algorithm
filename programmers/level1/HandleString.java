package level1;

public class HandleString {
	
	public static boolean solution(String s) {
		if(s.length() == 4 || s.length() == 6) {
			for(int i = 0; i < s.length(); i++) {
				int stringI = s.charAt(i) - '0';
				if(!(0 <= stringI && stringI <= 9))
					return false;
			}
			return true;
		}
		
		return false;
	}

}
