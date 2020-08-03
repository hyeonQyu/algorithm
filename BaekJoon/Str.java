import java.io.*;

public class Str {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int aLen = arr[0].length();
        int time = arr[1].length() - aLen + 1;
        
        int min = 100;
        for(int k = 0; k < time; k++){
            int count = 0;
            for(int i = 0; i < aLen; i++){
                if(arr[0].charAt(i) != arr[1].charAt(i + k))
                    count++;
            }
            if(min > count)
                min = count;
        }
        System.out.println(min);
    }
}
