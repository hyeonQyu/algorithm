import java.io.*;

public class ContinuousSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] arr = s.split(" ");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        
        int[] sums = new int[n];
        int max = sums[0] = nums[0];
        for(int i = 1; i < n; i++){
            sums[i] = nums[i] + sums[i - 1] >= nums[i] ? nums[i] + sums[i - 1] : nums[i];
            if(max < sums[i])
                max = sums[i];
        }
        
        System.out.println(max);
	}
	
}
