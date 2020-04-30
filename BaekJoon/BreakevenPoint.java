import java.io.*;

public class BreakevenPoint {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int[] cost = new int[3];
        for(int i = 0; i < 3; i++) {
        	cost[i] = Integer.parseInt(arr[i]);
        }
        
        if(cost[1] >= cost[2]) {
        	System.out.println(-1);
        	return;
        }
        	   
        int n = cost[2] - cost[1];     
        System.out.println(cost[0] / n + 1);
    }
	
}
