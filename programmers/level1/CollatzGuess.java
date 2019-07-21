package level1;

public class CollatzGuess {
	
	public static int solution(int num) {
		int count = 0;
		
		while(num != 1) {
			if(num % 2 == 0)
				num /= 2;
			else
				num = 3 * num + 1;
			
			count++;
			if(count == 450)
				return -1;
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
