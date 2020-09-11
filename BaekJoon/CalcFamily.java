import java.io.*;
import java.util.*;

class Fam {
	int parent;
	List<Integer> childs = new LinkedList<Integer>();
}

public class CalcFamily {
	
	static int n;
	static Fam[] family;
	static boolean[] isVisit;
	static int end;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		family = new Fam[n + 1];
		isVisit = new boolean[n + 1];
		for(int i = 1; i <= n; i++)
			family[i] = new Fam();
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			family[parent].childs.add(child);
			family[child].parent = parent;
		}
		
		isVisit[start] = true;
		dfs(start, 0);
		System.out.println(-1);
	}
	
	static void dfs(int cur, int relation) {
		if(cur == end) {
			System.out.println(relation);
			System.exit(0);
			return;
		}
		
		Iterator<Integer> itr = family[cur].childs.iterator();
		while(itr.hasNext()) {
			int child = itr.next();
			if(!isVisit[child]) {
				isVisit[child] = true;
				dfs(child, relation + 1);
			}
		}
		
		int parent = family[cur].parent;
		if(parent == 0)
			return;
		if(!isVisit[parent]) {
			isVisit[parent] = true;
			dfs(parent, relation + 1);
		}
	}

}
