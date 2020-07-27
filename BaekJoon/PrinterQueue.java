import java.io.*;
import java.util.*;

public class PrinterQueue {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < t; k++){
            String[] arr = br.readLine().split(" ");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            arr = br.readLine().split(" ");
            
            int[] priority = new int[n];
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i = 0; i < n; i++){
                priority[i] = Integer.parseInt(arr[i]);
                pq.add(priority[i]);
            }
            int[] order = new int[n];
            
            int i = 0;
            int count = 1;
            while(!pq.isEmpty()){
                // 이미 출력함
                if(order[i] > 0){
                    if(i < n - 1)
                        i++;
                    else
                        i = 0;
                    continue;
                }
                
                int max = pq.peek();
                if(priority[i] == max){
                    // 출력
                    pq.poll();
                    order[i] = count++;
                    
                    if(i == m)
                        break;
                }
                
                if(i < n - 1)
                    i++;
                else
                    i = 0;
            }
            sb.append(order[m] + "\n");
        }
        System.out.print(sb);
    }
}
