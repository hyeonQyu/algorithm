package bruteForce;

import java.io.*;

public class LeavingCompany {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] consulting = new int[n][2];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            String[] arr = s.split(" ");
            
            consulting[i][0] = Integer.parseInt(arr[0]);
            consulting[i][1] = Integer.parseInt(arr[1]);
        }
        
        int[] maxPay = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            // 퇴사날까지 상담을 완료해야 함
            if(consulting[i][0] + i <= n){
                maxPay[i] = consulting[i][1];
                
                int cur = maxPay[i];
                    for(int j = 0; j < i; j++){
                    // 현재 상담 전까지 전의 상담을 완료할 수 있고 그것이 최대 금액일 때
                    if(consulting[j][0] + j <= i && cur + maxPay[j] > maxPay[i]){
                        maxPay[i] = cur + maxPay[j];
                    }
                }
            }
                     
            if(max < maxPay[i])
                max = maxPay[i];
        }
        
        System.out.println(max);
    }
}
