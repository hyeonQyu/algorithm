package dynamicProgramming;
import java.util.Scanner;

public class FibonacciPrint {

	static int[] count0; 
	static int[] count1;
	
	public static void fibonacci(int n) {	
		for(int i = 0; i <= n; i++) {
			if(i == 0) 
				count0[i]++;
			else if(i == 1) 
				count1[i]++;
			else {
				count0[i] = count0[i-1] + count0[i-2];
				count1[i] = count1[i-1] + count1[i-2];
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int time = scanner.nextInt();
		int[] testNum = new int[time];
		
		for(int i = 0; i < time; i++) {
			testNum[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < time; i++) {
			count0 = new int[testNum[i]+1];
			count1 = new int[testNum[i]+1];
			fibonacci(testNum[i]);
			System.out.print(count0[testNum[i]] + " " + count1[testNum[i]] + "\n");
		}
		
		scanner.close();
	}

}
