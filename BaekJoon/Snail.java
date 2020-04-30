import java.io.*;

public class Snail {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int[] nums = new int[3];
        for(int i = 0; i < 3; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        
        if((nums[2] - nums[1]) % (nums[0] - nums[1]) == 0){
            System.out.println((nums[2] - nums[1]) / (nums[0] - nums[1]));
            return;
        }
        System.out.println((nums[2] - nums[1]) / (nums[0] - nums[1]) + 1);
    }

}
