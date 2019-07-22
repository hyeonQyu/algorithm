package level1;

public class StrangeWord {
	
	public static String solution(String s) {
		String[] strs = s.split(" ", -1);
		String answer = "";
		
		for(int i = 0; i < strs.length; i++) {	
			if(i != 0)
				answer += " ";
			
			char[] chars = new char[strs[i].length()];
			for(int j = 0; j < strs[i].length(); j++) {
				chars[j] = strs[i].charAt(j);
				if(j % 2 == 0)
					chars[j] = Character.toUpperCase(chars[j]);
				else
					chars[j] = Character.toLowerCase(chars[j]);
				answer += chars[j];
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		String s = "try ";
		s = solution(s);
		System.out.println(s);
	}

}
