package bruteForce;

import java.util.Scanner;

public class Hansu {

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if(n < 99){
            System.out.println(n);
            sc.close();
            return;
        }
        if(n < 111){
            System.out.println(99);
            sc.close();
            return;
        }
        
        int answer = 99;
        
        int[] digits = new int[3];
        for(int i = 111; i <= n; i++){
            digits[2] = i % 10;
            digits[1] = ((i - digits[2]) % 100) / 10;
            digits[0] = ((i - digits[2] - digits[1]) % 1000) / 100;
            
            if(digits[1] - digits[0] == digits[2] - digits[1])
                answer++;
        }
        
        if(n == 1000)
        	answer--;
        System.out.println(answer);

        sc.close();
    }
	
}
