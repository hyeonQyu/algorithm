package level1;

public class SumOfDigits {
	
	public static int solution(int n) {
		String number = Integer.toString(n);
		int sum = 0;
		
		for(int i = 0; i < number.length(); i++) {
			sum += number.charAt(i) - '0';
		}
		
		return sum;
	}

}
