package level2;

public class Lcm {
	
	static int getLcm(int a, int b) {
		int divisor = Math.min(a, b);
		
		while(divisor > 0) {
			if(a % divisor == 0 && b % divisor == 0) {
				a /= divisor;
				b /= divisor;
				return divisor * a * b;
			}
			divisor--;
		}
		
		return a * b;
	}
	
	public static int solution(int[] arr) {
		// 두 수의 최소공배수를 구한 후 그 구해진 최소공배수와 다음 수의 최소공배수를 구함
		for(int i = 1; i < arr.length; i++) {
			arr[i] = getLcm(arr[i - 1], arr[i]);  
		}
		
		return arr[arr.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 4, 8, 16};
		System.out.println("answer: " + solution(a));
	}

}
