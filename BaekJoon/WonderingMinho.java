import java.io.*;

public class WonderingMinho {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] sp = new int[n][];
        boolean[][] adj = new boolean[n][];
        for(int i = 0; i < n; i++){
            sp[i] = new int[n];
            adj[i] = new boolean[n];
            String[] arr = br.readLine().split(" ");
            
            for(int j = 0; j < n; j++){
                sp[i][j] = Integer.parseInt(arr[j]);
                if(i != j)
                    adj[i][j] = true;
            }
        }
        
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    int tmp = sp[i][k] + sp[k][j];
                    // 현재 sp가 최단경로가 아님 : 불가능한 경우
                    if(tmp < sp[i][j]){
                        System.out.println(-1);
                        return;
                    }
                    // i->j는 인접하지 않아도 됨
                    else if(tmp == sp[i][j] && i != k && k != j){
                        adj[i][j] = false;
                        adj[j][i] = false;
                    }
                }
            }
        }
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(adj[i][j])
                    sum += sp[i][j];
            }
        }
        System.out.println(sum / 2);
    }
}
