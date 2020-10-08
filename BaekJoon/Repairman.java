import java.io.*;
import java.util.*;

public class Repairman {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		int count = 1;
		int start = arr[0];
		for(int i = 0; i < n; i++) {
			// 새 테이프 필요
			if(arr[i] - start + 1 > l) {
				count++;
				start = arr[i];
			}
		}
		System.out.println(count);
	}
}
