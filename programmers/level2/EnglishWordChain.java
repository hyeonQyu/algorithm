package level2;

import java.util.ArrayList;

public class EnglishWordChain {
	
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		ArrayList<String>[] list = new ArrayList[26];
		for(int i = 0; i < 26; i++)
			list[i] = new ArrayList<>();
		
		list[words[0].charAt(0) - 97].add(words[0]);
		char last = words[0].charAt(words[0].length() - 1);
		for(int i = 1; i < words.length; i++) {
			boolean isOver = false;
			
			char first = words[i].charAt(0);
			// 끝말잇기 실패
			if(first != last) {
				answer[0] = i % n + 1;
				answer[1] = i / n + 1;
				break;
			}
			
			// 중복 검사
			int alphabet = first - 97;
			for(int j = 0; j < list[alphabet].size(); j++) {
				if(list[alphabet].get(j).equals(words[i])) {
					isOver = true;
					break;
				}
			}
			// 중복 발생
			if(isOver) {
				answer[0] = i % n + 1;
				answer[1] = i / n + 1;
				break;
			}
			list[alphabet].add(words[i]);
			
			last = words[i].charAt(words[i].length() - 1);
		}
		
		return answer;
	}

}
