import java.io.*;

public class Floyd {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[][] adj = new int[n][];
        for(int i = 0; i < n; i++) {
            adj[i] = new int[n];
            for(int j = 0; j < n; j++) {
            	if(i != j)
            		adj[i][j] = 9900001;
            }
        }
        
        for(int i = 0; i < m; i++){
            String[] arr = br.readLine().split(" ");
            int start = Integer.parseInt(arr[0]) - 1;
            int end = Integer.parseInt(arr[1]) - 1;
            int cost = Integer.parseInt(arr[2]);
            
            if(adj[start][end] > cost)
            	adj[start][end] = cost;           	
        }
        
        for(int mid = 0; mid < n; mid++){
            for(int i = 0; i < n; i++){           
                for(int j = 0; j < n; j++){
                    int tmp = adj[i][mid] + adj[mid][j];
                    if(adj[i][j] > tmp)
                        adj[i][j] = tmp;
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
            	if(adj[i][j] == 9900001)
            		adj[i][j] = 0;
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}
