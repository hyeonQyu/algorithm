package level1;

import java.util.Scanner;

public class SumOf2Int {

	public static long solution(int a, int b) {
		if(a == b)
			return a;
		else {
			int start, end;
			
			if(a < b) {
				start = a;
				end = b;
			}
			else {
				start = b;
				end = a;
			}
			long answer = 0;
			
			for(int i = start; i <= end; i++) {
				answer += i;
			}
			
			return answer;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int a, b;
		a = scanner.nextInt();
		b = scanner.nextInt();
		System.out.println(solution(a, b));
	}

}
