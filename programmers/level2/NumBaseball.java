package level2;

public class NumBaseball {
	
	public static int solution(int[][] baseball) {
		int count = 0;
		
		String[] answers = new String[1000];
		for(int i = 111; i < answers.length; i++) {
			answers[i] = Integer.toString(i);
		}
		
		for(int i = 0; i < baseball.length; i++) {
			String digit = Integer.toString(baseball[i][0]);
			
			// 스트라이크, 볼, 자릿수 비교
			for(int j = 111; j < answers.length; j++) {
				if(answers[j].equals(""))
					continue;
				if(answers[j].contains("0")) {
					answers[j] = "";
					continue;
				}
				char first = answers[j].charAt(0);
				char second = answers[j].charAt(1);
				char third = answers[j].charAt(2);
				if(first == second || second == third || first == third) {
					answers[j] = "";
					continue;
				}
				
				int strike = 0;
				int ball = 0;
				
				for(int k = 0; k < 3; k++) {
					for(int l = 0; l < 3; l++) {
						if(answers[j].charAt(k) == digit.charAt(l)) {
							// 숫자 하나가 같으면
							if(k == l)
								strike++;
							else
								ball++;
						}
					}
				}
				if(strike != baseball[i][1] || ball != baseball[i][2]) {
					// 카운트가 다르면 후보에서 제외
					answers[j] = "";
				}
			}
		}
		
		// 가능한 정답의 수
		for(int i = 111; i < answers.length; i++) {
			if(!answers[i].equals(""))
				count++;
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		int a = solution(baseball);
	}

}
