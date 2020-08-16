import java.io.*;
import java.util.*;

public class Bis{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] d = new int[n];
        
        arr[0] = Integer.parseInt(st.nextToken());
        d[0] = arr[0];
        int max = arr[0];
        for(int i = 1; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            d[i] = arr[i];
            for(int j = 0; j < i; j++){
                // 증가
                if(arr[i] > arr[j]){
                    // 합이 더 큼
                    int tmp = arr[i] + d[j];
                    d[i] = Math.max(tmp, d[i]);
                    max = Math.max(max, d[i]);
                }
            }
        }
        System.out.println(max);
    }
}