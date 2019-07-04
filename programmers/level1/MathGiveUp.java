package level1;

import java.util.Scanner;

public class MathGiveUp {

	public static int[] solution(int[] answers) {
		int[][] pattern = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
		int[] count = {0, 0, 0};
		
		for(int i = 0; i < answers.length; i++) {
			for(int j = 0; j < pattern.length; j++) {
				if(answers[i] == pattern[j][i % pattern[j].length])
					count[j]++;
			}
		}
		
		int max = -1;
		int[] person = {0, 0, 0};
		int index = 0;
		for(int i = 0; i < 3; i++) {
			if(max < count[i]) {
				max = count[i];
			}
		}
		for(int i = 0; i < 3; i++) {
			if(max == count[i])
				person[index++] = i + 1;
		}
		
		int k;
		for(k = 0; k < 3; k++) {
			if(person[k] == 0) {
				break;
			}
		}
		
		int[] answer = new int[k];
		for(int i = 0; i < k; i++) {
			answer[i] = person[i];
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] answers = new int[num];
		
		int[] answer = solution(answers);
		for(int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
	}

}
