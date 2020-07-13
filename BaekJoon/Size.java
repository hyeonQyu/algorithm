import java.io.*;
import java.util.*;

public class Size {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] sizes = new int[n][];
        for(int i = 0; i < n; i++){
            sizes[i] = new int[2];
            String[] arr = br.readLine().split(" ");
            
            for(int j = 0; j < 2; j++)
                sizes[i][j] = Integer.parseInt(arr[j]);
        }
        
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < n; i++){
            int place = 1;
            for(int j = 0; j < n; j++){
                if(i == j)
                    continue;
                
                if(sizes[i][0] < sizes[j][0] && sizes[i][1] < sizes[j][1])
                    place++;
            }
            sb.append(place + " ");
        }
        
        System.out.print(sb);
    }
}
