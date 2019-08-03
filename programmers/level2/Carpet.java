package level2;

public class Carpet {

	public static int[] solution(int brown, int red) {
		int[] answer = new int[2];
		
		int widthHeightSum = brown / 2 + 2;
		answer[0] = widthHeightSum - 3;
		answer[1] = 3;
		while(answer[0] >= answer[1]) {
			if(answer[0] * answer[1] == brown + red)
				return answer;
			answer[0]--;
			answer[1]++;
		}
		
		return answer;
	}

}
