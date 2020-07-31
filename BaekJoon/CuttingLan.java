import java.io.*;

public class CuttingLan {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int k = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);
        
        int[] lan = new int[k];
        int max = 0;
        for(int i = 0; i < k; i++){
            lan[i] = Integer.parseInt(br.readLine());
            if(max < lan[i])
                max = lan[i];
        }
        
        int start = 1;
        int end = max;
        int maxLength = 0;
        while(start <= end){
            long sum = 0;
            int length = (start + end) / 2;
            for(int i = 0; i < k; i++)
                sum += (lan[i] / length);
            
            // 조건을 만족하지 못했으므로 길이를 줄임
            if(sum < n)
                end = length - 1;
            // 조건을 만족하므로 길이의 최댓값을 찾음
            else {
            	maxLength = length;
                start = length + 1;
            }
        }
        
        System.out.println(maxLength);
    }
}
