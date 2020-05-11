import java.io.*;
import java.util.*;

public class HideAndSeek {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String[] arr = s.split(" ");
		
		int n = Integer.parseInt(arr[0]);
		int k = Integer.parseInt(arr[1]);
		
		int[] isVisit = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(n);
		isVisit[n] = 1;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			if(tmp == k)
				break;

			try {
				int tmp2 = tmp * 2;
				if(isVisit[tmp2] == 0) {
					q.add(tmp2);
					isVisit[tmp2] = isVisit[tmp] + 1;
				}
			} catch(Exception e) {}
			try {
				int tmp2 = tmp + 1;
				if(isVisit[tmp2] == 0) {
					q.add(tmp2);
					isVisit[tmp2] = isVisit[tmp] + 1;
				}
			} catch(Exception e) {}
			try {
				int tmp2 = tmp - 1;
				if(isVisit[tmp2] == 0) {
					q.add(tmp2);
					isVisit[tmp2] = isVisit[tmp] + 1;
				}
			} catch(Exception e) {}
		}
		
		System.out.println(isVisit[k] - 1);
	}

}
