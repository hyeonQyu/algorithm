import java.io.*;
import java.util.*;

public class EasyStairNum {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[][] d = new long[n + 1][];
        d[1] = new long[11];
        for(int i = 1; i < 10; i++)
            d[1][i] = 1;
        
        for(int t = 2; t <= n; t++){
            d[t] = new long[11];
            d[t][0] = d[t - 1][1];
            for(int i = 1; i < 10; i++){
                d[t][i] = (d[t - 1][i - 1] + d[t - 1][i + 1]) % 1000000000;
            }
        }
        
        long sum = 0;
        for(int i = 0; i < 10; i++){
            sum += (d[n][i] % 1000000000);
        }
        
        System.out.println(sum % 1000000000);
    }
}
