import java.io.*;
import java.util.*;

public class Thirty {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        int[] arr = new int[length];
        
        int sum = 0;
        for(int i = 0; i < length; i++){
            arr[i] = s.charAt(i) - '0';
            sum += arr[i];
        }
        Arrays.sort(arr);
        
        if(arr[0] != 0 || sum % 3 != 0){
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = length - 1; i >= 0; i--)
            sb.append(arr[i]);
        System.out.println(sb);
    }
}
