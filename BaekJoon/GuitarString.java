import java.io.*;

public class GuitarString {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        
        int p = 10001;
        int s = 10001;
        for(int i = 0; i < m; i++){
            arr = br.readLine().split(" ");
            int tmp = Integer.parseInt(arr[0]);
            p = p > tmp ? tmp : p;
            tmp = Integer.parseInt(arr[1]);
            s = s > tmp ? tmp : s;
        }
        
        int cost = 0;
        while(n > 0){
            if(n >= 6){
                // 낱개 6개가 더 저렴
                if(p > s * 6){
                    cost = n * s;
                    break;
                } else{
                    // 패키지 구입
                    n -= 6;
                    cost += p;
                }
                continue;
            }
            // 6개보다 적게 남음
            // 낱개가 더 비싸면 패키지로 구입
            if(p < s * n)
                cost += p;
            else
                cost += n * s;
            break;
        }
        System.out.println(cost);
    }
}
