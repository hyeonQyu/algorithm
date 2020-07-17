import java.io.*;

public class Stick {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] arr = {64, 32, 16, 8, 4, 2, 1};
        
        int sum = 0;
        int i = 0;
        int count = 0;
        while(sum < x){
            if(arr[i] + sum <= x){
                sum += arr[i];
                count++;
            }
            else
                i++;
        }
        System.out.println(count);
    }
}
