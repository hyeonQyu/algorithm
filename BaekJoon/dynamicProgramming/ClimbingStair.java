package dynamicProgramming;

import java.util.Scanner;

public class ClimbingStair {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stairs = new int[n];
        
        for(int i = 0; i < n; i++){
            stairs[i] = sc.nextInt();
        }
        
        if(n == 1){
            System.out.print(stairs[0]);
            return;
        }
        
        int[][] d = new int[n][2];
        d[0][0] = d[0][1] = stairs[0];
        d[1][0] = stairs[1];
        d[1][1] = stairs[0] + stairs[1];
        for(int i = 2; i < n; i++){
            d[i][0] = Math.max(d[i - 2][0], d[i - 2][1]) + stairs[i];
            d[i][1] = d[i - 1][0] + stairs[i];
        }
        
        System.out.println(Math.max(d[n - 1][0], d[n - 1][1]));
	}

}
