import java.util.Arrays;
import java.util.Scanner;

class Triangle implements Comparable<Triangle>{
	int value;
	int sum;
	
	@Override
	public int compareTo(Triangle triangle) {	// sum�� ������������ ����
		if(sum > triangle.sum)
			return -1;
		else if(sum < triangle.sum)
			return 1;
		else
			return 0;
	}
}

public class IntegerTriangle {
	
	static int getMaxSum(int sum1, int sum2) {
		return sum1 > sum2 ? sum1 : sum2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		Triangle[][] triangle = new Triangle[n][];
		for(int i = 0; i < n; i++) {
			triangle[i] = new Triangle[i+1];
			
			for(int j = 0; j <= i; j++) {
				triangle[i][j] = new Triangle();
				triangle[i][j].value = scanner.nextInt();
			}
		}
		
		triangle[0][0].sum = triangle[0][0].value;
		for(int i = 1; i < n; i++) {
			triangle[i][0].sum = triangle[i-1][0].sum + triangle[i][0].value;
			triangle[i][i].sum = triangle[i-1][i-1].sum + triangle[i][i].value;
			
			for(int j = 1; j < i; j++)
				triangle[i][j].sum = getMaxSum(triangle[i-1][j-1].sum, triangle[i-1][j].sum) + triangle[i][j].value;
		}
		
		Arrays.sort(triangle[n-1]);
		System.out.println(triangle[n-1][0].sum);
		
		scanner.close();
	}

}
