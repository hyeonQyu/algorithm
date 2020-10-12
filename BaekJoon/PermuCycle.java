import java.io.*;
import java.util.*;

public class PermuCycle {
	static boolean[] isVisit;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr = new int[n];
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			isVisit = new boolean[n];
			int count = 0;
			for(int i = 0; i < n; i++) {
				if(!isVisit[i]) {
					count++;
					dfs(i);
				}
			}
			
			System.out.println(count);
		}
	}
	
	static void dfs(int index) {
		isVisit[index] = true;
		int next = arr[index] - 1;
		if(isVisit[next])
			return;
		dfs(next);
	}
}
