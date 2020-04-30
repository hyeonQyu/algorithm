import java.util.Scanner;

public class MakeOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] count = new int[num+1];
		
		count[0] = count[1] = 0;
		for(int i = 2; i <= num; i++) {
			count[i] = count[i-1] + 1;
			if(i % 2 == 0)
				count[i] = Math.min(count[i], count[i/2] + 1);
			if(i % 3 == 0)
				count[i] = Math.min(count[i], count[i/3] + 1);
		}
		
		System.out.println(count[num]);
		
		scanner.close();
	}

}
