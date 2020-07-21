import java.io.*;

public class Lis {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String arr[] = br.readLine().split(" ");
        int[][] d = new int[n][];
        
        for(int i = 0; i < n; i++){
            d[i] = new int[2];
            d[i][0] = Integer.parseInt(arr[i]);
            d[i][1] = 1;
            
            for(int j = i; j >= 0; j--){
                if(d[i][0] > d[j][0]){
                    if(d[i][1] <= d[j][1])
                        d[i][1] = d[j][1] + 1;
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < n; i++){
            if(max < d[i][1])
                max = d[i][1];
        }
        System.out.println(max);
    }
}
