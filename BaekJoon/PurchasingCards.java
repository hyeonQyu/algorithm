import java.io.*;

public class PurchasingCards{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n + 1];
        String[] arr = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            p[i + 1] = Integer.parseInt(arr[i]);
        if(n == 1){
            System.out.println(p[1]);
            return;
        }
        
        int[] d = new int[n + 1];
        d[1] = p[1];
        d[2] = Math.max(d[1] + d[1], p[2]);
        if(n == 2){
            System.out.println(d[2]);
            return;
        }
        d[3] = Math.max(d[2] + d[1], p[3]);
        if(n == 3){
            System.out.println(d[3]);
            return;
        }
        
        for(int i = 4; i <= n; i++){
        	d[i] = p[i];
        	for(int j = 1; j <= i / 2; j++) {
        		int tmp = d[i - j] + d[j];
        		d[i] = tmp > d[i] ? tmp : d[i];
        	}
        }
        System.out.println(d[n]);
    }
}