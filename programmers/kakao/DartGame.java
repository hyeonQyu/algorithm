package kakao;

import java.util.Iterator;
import java.util.LinkedList;

public class DartGame {
	
	public int solution(String dartResult) {
		LinkedList<String> turn = new LinkedList<>();
		
		// 문자열을 각 turn으로 나눔
		String tmp = Character.toString(dartResult.charAt(0));
		for(int i = 1; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);
			// 숫자라면 tmp 문자열의 시작
			if(Character.isDigit(c)) {
				// 10 처리
				if(Character.isDigit(dartResult.charAt(i - 1))) {
					tmp += c;
					continue;
				}
				turn.add(tmp);
				tmp = Character.toString(c);
			}
			// 그 외 다른 문자라면 tmp 문자열에 추가
			else {
				tmp += c;
			}
		}
		turn.add(tmp);
		
		int[] scores = new int[turn.size()];
		int index = 0;
		Iterator<String> itr = turn.iterator();
		while(itr.hasNext()) {
			tmp = itr.next();
			// 원점수
			int score = tmp.charAt(0) - '0';
			for(int j = 1; j < tmp.length(); j++) {
				switch(tmp.charAt(j)) {
				case '0':
					if(tmp.charAt(j - 1) == '1') {
						score = 10;
					}
					break;
				case 'D':
					score = score * score;
					break;
				case 'T':
					score = score * score * score;
					break;
				case '*':
					score *= 2;
					try {
						scores[index - 1] *= 2;
					} catch(ArrayIndexOutOfBoundsException e) {}
					break;
				case '#':
					score *= -1;
					break;
				}
			}
			scores[index++] = score; 
		}
		
		int total = 0;
		for(int i = 0; i < scores.length; i++) {
			total += scores[i];
		}
		
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "1D2S#10S";
		new DartGame().solution(a);
	}

}
