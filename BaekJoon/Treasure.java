import java.io.*;
import java.util.*;

public class Treasure {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[][] ab = new Integer[2][];
        for(int i = 0; i < 2; i++){
            String[] arr = br.readLine().split(" ");
            ab[i] = new Integer[n];
            for(int j = 0; j < n; j++){
                ab[i][j] = Integer.parseInt(arr[j]);
            }
        }
        
        Arrays.sort(ab[0]);
        Arrays.sort(ab[1], Collections.reverseOrder());
        int answer = 0;
        for(int i = 0; i < n; i++){
            answer += (ab[0][i] * ab[1][i]);
        }
        System.out.println(answer);
    }
}
