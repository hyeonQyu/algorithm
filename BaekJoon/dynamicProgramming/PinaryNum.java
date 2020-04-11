package dynamicProgramming;

import java.util.Scanner;

public class PinaryNum {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if(n == 1){
            System.out.println(1);
            return;
        }
        
        int[] d = new int[n];
        d[0] = 1;
        d[1] = 1;
        for(int i = 2; i < n; i++){
            d[i] = d[i - 1] + d[i - 2];
        }
        
        System.out.println(d[n - 1]);

        sc.close();
    }
}
