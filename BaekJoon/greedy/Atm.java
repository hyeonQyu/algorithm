package greedy;

import java.io.*;
import java.util.Arrays;

public class Atm {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] arr = s.split(" ");
        int[] p = new int[n];
        for(int i = 0; i < n; i++){
            p[i] = Integer.parseInt(arr[i]);
        }
        
        Arrays.sort(p);
        for(int i = 1; i < n; i++){
            p[i] += p[i - 1];
        }
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += p[i];
        }
        
        System.out.println(sum);
	}

}
