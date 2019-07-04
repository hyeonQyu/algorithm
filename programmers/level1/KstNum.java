package level1;

import java.util.Arrays;
import java.util.Scanner;

public class KstNum {
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int turn = 0; turn < commands.length; turn++) {
			int[] temp = new int[commands[turn][1] - commands[turn][0] + 1];
			
			for(int i = commands[turn][0] - 1; i < commands[turn][1]; i++) {
				temp[i - commands[turn][0] + 1] = array[i];
			}
			
			Arrays.sort(temp);
			answer[turn] = temp[commands[turn][2] - 1];
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arr, i, j;
		int[] array;
		int[][] commands;
		
		arr = scanner.nextInt();
		i = scanner.nextInt();
		j = scanner.nextInt();
		
		array = new int[arr];
		commands = new int[i][j];
		
		for(int n = 0; n < array.length; n++) {
			array[n] = scanner.nextInt();
		}
		
		for(int n = 0; n < commands.length; n++) {
			for(int m = 0; m < commands[n].length; m++) {
				commands[n][m] = scanner.nextInt();
			}
		}
		
		int[] answer = solution(array, commands);
		for(int n = 0; n < answer.length; n++) {
			System.out.print(answer[n] + " ");
		}
	}
	
}
