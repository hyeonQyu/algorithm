import java.util.Scanner;

public class DisjointSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int naturalNum = scanner.nextInt();
		int digit = (int)(Math.log10(naturalNum)) + 1;
		int maxSumOfDigit = 0;
		
		for(int i = 0; i <= digit; i++) {
			maxSumOfDigit += 9;
		}
		
		int constructor = 0;
		while(true) {
			constructor = naturalNum - maxSumOfDigit;
			int digitForConstructor = (int)(Math.log10(constructor)) + 1;
			int sumOfEach = 0;
			
			for(int i = 0; i < digitForConstructor; i++) {
				sumOfEach += Integer.toString(constructor).charAt(i) - '0';
			}
			
			if(maxSumOfDigit == sumOfEach)
				break;
			maxSumOfDigit--;
			if(maxSumOfDigit == 0) {
				constructor = 0;
				break;
			}
		}
		
		System.out.println(constructor);
		scanner.close();
	}

}
