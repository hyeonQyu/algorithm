import java.io.*;

public class Tile01 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1) {
        	System.out.println(1);
        	return;
        }
        
        int d[] = new int[n];
        d[0] = 1;
        d[1] = 2;
        for(int i = 2; i < n; i++) {
        	d[i] = (d[i - 1] + d[i - 2]) % 15746;
        }
        System.out.println(d[n - 1]);
    }
}
