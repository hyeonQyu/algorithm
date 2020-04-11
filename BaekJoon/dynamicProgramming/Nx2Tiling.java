package dynamicProgramming;

import java.util.Scanner;

public class Nx2Tiling {

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] d = new int[n];
        d[0] = 1;
        if(n < 2){
            System.out.println(d[0]);
            return;
        }
        d[1] = 2;
        
        for(int i = 2; i < n; i++){
        	d[i] = (d[i - 1] + d[i - 2]) % 10007;
        }
        
        System.out.println(d[n - 1]);
    }
	
}
