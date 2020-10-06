import java.io.*;
import java.util.*;

public class Moving {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][];
        int[][] d = new int[n][];
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            map[i] = new int[m];
            d[i] = new int[m];
            
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                d[i][j] = map[i][j];
                
                int up, left;
                try{
                    up = d[i - 1][j];
                } catch(Exception e){
                	up = 0;
                }
                try{
                    left = d[i][j - 1];
                } catch(Exception e){
                	left = 0;
                }
                
                d[i][j] += Math.max(up, left);
            }
        }
        
        System.out.println(d[n - 1][m - 1]);
    }
}
