package level1;

public class DiscriminationIntegerSquareRoot {
	
	public static long solution(long n) {
		if(n == 1)
			return 4;
		
		for(long i = 1; i < n/2; i++) {
			if(i * i == n)
				return (i + 1) * (i + 1);
		}
		
		return -1;
	}

}
