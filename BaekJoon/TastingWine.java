import java.io.*;

public class TastingWine {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n];
        int[] d = new int[n];
        
        for(int i = 0; i < n; i++){
            wines[i] = Integer.parseInt(br.readLine());
        }
        
        d[0] = wines[0];
        if(n == 1) {
        	System.out.println(d[0]);
        	return;
        }
        d[1] = d[0] + wines[1];
        if(n == 2) {
        	System.out.println(d[1]);
        	return;
        }
        d[2] = Math.max(wines[0] + wines[2], Math.max(wines[1] + wines[2], wines[0] + wines[1]));
        
        for(int i = 3; i < n; i++){
        	d[i] = Math.max(d[i - 2] + wines[i], Math.max(d[i - 1], d[i - 3] + wines[i - 1] + wines[i]));
        }
        
        System.out.println(d[n - 1]);
    }
	
}
