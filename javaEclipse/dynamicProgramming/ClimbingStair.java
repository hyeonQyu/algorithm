package dynamicProgramming;
import java.util.Scanner;

class Stair {
	int point;
	int sumOfPoints;
	
	Stair(int point) {
		this.point = point;
		sumOfPoints = 0;
	}
}

public class ClimbingStair {
	
	static int getMax(int sum1, int sum2) {
		return sum1 > sum2 ? sum1 : sum2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Stair[] stairs = new Stair[n];
		
		for(int i = 0; i < n; i++)
			stairs[i] = new Stair(scanner.nextInt());
		
		stairs[0].sumOfPoints = stairs[0].point;
		stairs[1].sumOfPoints = stairs[0].sumOfPoints + stairs[1].point;
		stairs[2].sumOfPoints = getMax(stairs[0].point + stairs[2].point, stairs[1].point + stairs[2].point);
		for(int i = 3; i < n; i++)
			// ÀüÀüÄ­À» ¹â°í ÇöÀçÄ­À» ¹â´Â °æ¿ì -> ÀüÀüÄ­±îÁöÀÇ ÃÖ´ë°ª + ÇöÀçÄ­
			// ÀüÄ­À» ¹â°í ÇöÀçÄ­À» ¹â´Â °æ¿ì -> ÀüÀüÀüÄ­±îÁöÀÇ ÃÖ´ë°ª + ÀüÄ­ + ÇöÀçÄ­
			stairs[i].sumOfPoints = getMax(stairs[i-2].sumOfPoints + stairs[i].point, stairs[i-3].sumOfPoints + stairs[i-1].point + stairs[i].point);
		
		System.out.println(stairs[n-1].sumOfPoints);
		
		scanner.close();
	}

}
