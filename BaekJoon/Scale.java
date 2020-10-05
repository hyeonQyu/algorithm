import java.io.*;
import java.util.*;

public class Scale {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
            
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        
        // d에 누적
        int[] d = new int[n];
        d[0] = arr[0];
        for(int i = 1; i < n; i++)
            d[i] = arr[i] + d[i - 1];
        
        int i = 1;
        int j = 0;
        while(true){
        	try {
        		if(i < arr[j]){
        			try{
        				if(i > d[j - 1]){
        					// i보다 작은 수들로 i를 만들 수 없음
        					System.out.println(i);
        					return;
        				} else{
        					i++;
        				}
        			} catch(Exception e){
        				// i보다 작거나 같은 수가 없음
        				System.out.println(i);
        				return;
        			}
        		} else{
        			j++;
        		}        		
        	} catch (Exception e) {
        		// 모든 수로 i를 만들 수 없음
				System.out.println(d[j - 1] + 1);
				return;
			}
        }
    }
}
