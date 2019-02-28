package javaEclipse;
import java.util.Arrays;
import java.util.Scanner;

public class SevenPigmy {
	
	static final int SUM_OF_HEIGHT = 100;
	static final int NUM_OF_PIGMY = 7;
	static int[] height = new int[9];
	static boolean[] isPigmy = new boolean[9];
	
	public static void addToSumOfHeight(int index, int sum, int total, int count) {
		if(isPrommising(index, sum, total, count)) {
			if(sum == SUM_OF_HEIGHT && count == NUM_OF_PIGMY) {
				for(int i = 0; i < height.length; i++) {
					if(isPigmy[i]) {
						System.out.println(height[i]);
					}
				}
			}
			else {
				try {
					isPigmy[index + 1] = true;
					addToSumOfHeight(index + 1, sum + height[index+1], total - height[index+1], count + 1);
					isPigmy[index + 1] = false;
					addToSumOfHeight(index + 1, sum, total - height[index+1], count);
				}
				catch(ArrayIndexOutOfBoundsException e) {
					System.exit(0);
				}
			}
		}
	}
	
	public static boolean isPrommising(int index, int sum, int total, int count) {
		return (sum + total >= SUM_OF_HEIGHT) && (sum == SUM_OF_HEIGHT || sum + height[index+1] <= SUM_OF_HEIGHT) && (count <= NUM_OF_PIGMY);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int total = 0;
		for(int i = 0; i < height.length; i++) {
			height[i] = scanner.nextInt();
			total += height[i];
		}
		Arrays.sort(height);
		
		addToSumOfHeight(-1, 0, total, 0);
	
		scanner.close();
	}

}
