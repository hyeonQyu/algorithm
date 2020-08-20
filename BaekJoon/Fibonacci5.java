import java.io.*;

public class Fibonacci5 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        try{
            fibo[1] = 1;
            for(int i = 2; i <= n; i++)
                fibo[i] = fibo[i - 1] + fibo[i - 2];
        } catch(Exception e){
        } finally{
            System.out.println(fibo[n]);
        }
    }
}
