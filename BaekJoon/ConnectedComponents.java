import java.io.*;
import java.util.*;

public class ConnectedComponents {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        
        boolean[] isVisit = new boolean[n];
        boolean[][] adj = new boolean[n][];
        for(int i = 0; i < n; i++)
            adj[i] = new boolean[n];
        // 인접한 노드 중 방문하지 않은 노드
        int[] adjNotVisit = new int[n];
        
        for(int i = 0; i < m; i++){
            arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]) - 1;
            int b = Integer.parseInt(arr[1]) - 1;
            
            adj[a][b] = true;
            adj[b][a] = true;
            
            adjNotVisit[a]++;
            adjNotVisit[b]++;
        }
        
        int cc = 0;
        Stack<Integer> stack = new Stack<>();
        for(int node = 0; node < n; node++){
            if(isVisit[node])
                continue;
            
            cc++;
            stack.push(node);
            isVisit[node] = true;
            while(!stack.isEmpty()){
                int tmp = stack.pop();
            
                for(int i = 0; i < n; i++){
                    if(adj[tmp][i]){
                        // 방문하지 않은 노드이면 스택에 삽입
                        if(!isVisit[i]){
                            adjNotVisit[tmp]--;
                            stack.push(i);
                            isVisit[i] = true;
                        }
                    }
                    if(adjNotVisit[tmp] == 0)
                        break;
                }
            }
        }
        System.out.println(cc);
    }
}
