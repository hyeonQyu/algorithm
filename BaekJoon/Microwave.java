import java.io.*;

public class Microwave {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        if(t % 10 > 0){
            System.out.println(-1);
            return;
        }
        
        int[] btn = {300, 60, 10};
        int[] ans = new int[3];
        while(t > 0){
            for(int i = 0; i < 3; i++){
                if(t >= btn[i]){
                    int m = t / btn[i];
                    int r = t % btn[i];
                    t = r;
                    ans[i] += m;
                    break;
                }
            }
        }
        for(int i = 0; i < 3; i++)
            System.out.print(ans[i] + " ");
        System.out.println();
    }
}
