import java.io.*;
import java.util.*;

public class Bridging{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int[][] d = new int[n][];
            for(int i = 0; i < n; i++){
                d[i] = new int[m];
                for(int j = i; j < m; j++){
                    try{
                        d[i][j] = d[i][j - 1] + d[i - 1][j - 1];
                    } catch(Exception e){
                        d[i][j] = 1;
                    }
                }
            }
            
            int answer = 0;
            for(int i = n - 1; i < m; i++)
                answer += d[n - 1][i];
            System.out.println(answer);
        }
    }
}