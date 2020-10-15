import java.io.*;
import java.util.*;

public class Coin2 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i = 0; i < n; i++)
            coins[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(coins);
        
        int[] d = new int[k + 1];
        for(int i = 1; i <= k; i++)
        	d[i] = 10001;
        
        for(int i = 0; i < n; i++) {
        	int coin = coins[i];
        	for(int j = coin; j <= k; j++)
        		d[j] = Math.min(d[j], d[j - coin] + 1);
        }
        
        System.out.println(d[k] == 10001 ? -1 : d[k]);
    }
}
