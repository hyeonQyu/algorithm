package greedy;

import java.io.*;

public class Coin0 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        String[] arr = s.split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        int count = 0;
        for(int i = n - 1; i >= 0; i--){
            if(k >= coins[i]) {
            	int d = k / coins[i];
            	k -= (coins[i] * d);
            	count += d;
            }
            
            if(k == 0)
                break;
        }
        System.out.print(count);
	}

}
