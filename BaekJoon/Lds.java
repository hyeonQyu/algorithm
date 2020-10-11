import java.io.*;
import java.util.*;

public class Lds{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        
        int[] d = new int[n];
        d[0] = 1;
        int max = 1;
        for(int i = 1; i < n; i++) {
        	int tmp = 0;
        	for(int j = 0; j < i; j++) {
        		if(a[j] > a[i]) {
        			tmp = Math.max(tmp, d[j]);
        		}
        	}
        	d[i] = tmp + 1;
        	max = Math.max(max, d[i]);
        }
        
        System.out.println(max);
    }
}