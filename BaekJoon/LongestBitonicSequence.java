import java.io.*;
import java.util.*;

public class LongestBitonicSequence {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] s = new int[n][];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            s[i] = new int[3];
            s[i][0] = Integer.parseInt(st.nextToken());
        }
        s[0][1] = 1;
        s[n - 1][2] = 1;
        
        // 증가하는 부분수열
        for(int i = 1; i < n; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(s[i][0] > s[j][0])
                    max = Math.max(max, s[j][1]);
            }
            s[i][1] = max + 1;
        }
        // 감소하는 부분수열
        for(int i = n - 2; i >= 0; i--){
            int max = 0;
            for(int j = n - 1; j > i; j--){
                if(s[i][0] > s[j][0])
                    max = Math.max(max, s[j][2]);
            }
            s[i][2] = max + 1;
        }
        
        int max = 0;
        for(int i = 0; i < n; i++)
            max = Math.max(max, s[i][1] + s[i][2]);
        
        System.out.println(max - 1);
	}
}
