package math;

import java.io.*;

public class Sorting3 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder("");
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }
        for(int i = 1; i < 10001; i++){
            for(int j = 0; j < arr[i]; j++){
                answer.append(Integer.toString(i) + "\n");
            }
        }
        System.out.println(answer);
    }

}
