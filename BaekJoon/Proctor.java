import java.io.*;
import java.util.*;

public class Proctor {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] rooms = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			rooms[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		long count = n;
		for(int i = 0; i < n; i++) {
			rooms[i] -= b;
			if(rooms[i] > 0) {
				int tmp = rooms[i] / c;
				if(rooms[i] % c != 0)
					tmp++;
				count += tmp;
			}
		}
		
		System.out.println(count);
	}

}
