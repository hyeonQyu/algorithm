import java.io.*;
import java.util.*;

public class Camping {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 0;
		while(true) {
			t++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(l == 0)
				return;
			
			int m = v / p;
			int n = v % p;
			int answer = m * l + Math.min(n, l);
			
			System.out.println("Case " + t + ": " + answer);
		}
	}

}
