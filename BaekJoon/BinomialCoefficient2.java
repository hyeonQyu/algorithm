import java.io.*;
import java.util.*;

public class BinomialCoefficient2 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        if(n == k || k == 0){
            System.out.println(1);
            return;
        }
        
        int[][] d = new int[1001][1001];
        for(int i = 1; i <= n; i++){
            d[i][0] = 1;
            d[i][i] = 1;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < n; j++){
                d[i][j] = (d[i - 1][j - 1] + d[i - 1][j]) % 10007;
            }
        }
        
        System.out.println(d[n][k]);
    }
}
