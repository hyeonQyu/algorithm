import java.io.*;
import java.util.*;

public class TreeCut {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        
        arr = br.readLine().split(" ");
        int[] trees = new int[n];
        for(int i = 0; i < n; i++){
            trees[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(trees);
        
        int u = trees[n - 1];
        int d = 0;
        int length = 0;
        int answer = 0;
        while(u >= d){
        	length = (u + d) / 2;
        	long total = 0;
            for(int i = n - 1; i >= 0; i--){
                    // 잘리고 남은 만큼 더함
                    int tmp = trees[i] - length;
                    // 나무를 더 얻을 수 없으므로 탈출
                    if(tmp <= 0)
                        break;
                    total += tmp;
            }      
            
            // 더 크게 잘라야 함(조건은 만족)
            if(m < total){
            	// 답은 최대한 커야함
            	if(answer < length)
            		answer = length;
                d = length + 1;
            }
            // 더 작게 잘라야 함
            else if(m > total){
                u = length - 1;
            }
            else{
                break;
            }
        }
        
        System.out.println(length);
    }
}
