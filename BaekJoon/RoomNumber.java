import java.io.*;

public class RoomNumber {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        
        int[] arr = new int[10];
        for(int i = 0; i < length; i++){
            int digit = s.charAt(i) - '0';
            arr[digit]++;
        }
        
        while(Math.abs(arr[6] - arr[9]) > 1){
            if(arr[6] > arr[9]){
                arr[6]--;
                arr[9]++;
            }
            else if(arr[6] < arr[9]){
                arr[6]++;
                arr[9]--;
            }
        }
        
        int max = 0;
        for(int i = 0; i < 10; i++){
            if(arr[i] > max)
                max = arr[i];
        }
        System.out.println(max);
    }
}
