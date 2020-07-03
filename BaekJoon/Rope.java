import java.io.*;
import java.util.*;

public class Rope {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];
        for(int i = 0; i < n; i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);
        
        int weight = 0;
        int count = 1;
        for(int i = 0; i < n - 1; i++){
            if(ropes[i] == ropes[i + 1])
                count++;
            else if(ropes[i] < ropes[i + 1]){
                int tmp = (n - 1 - i + count) * ropes[i];
                if(weight < tmp)
                    weight = tmp;
                count = 1;
            }
        }
        System.out.println(weight);
    }
}
