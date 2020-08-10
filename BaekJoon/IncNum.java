import java.io.*;

public class IncNum{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] d = new int[n + 1][];
        d[1] = new int[10];
        for(int i = 0; i < 10; i++)
            d[1][i] = 1;
        for(int i = 2; i <= n; i++){
            d[i] = new int[10];
            d[i][9] = 1;
            for(int j = 8; j >= 0; j--){
                d[i][j] = (d[i][j + 1] + d[i - 1][j]) % 10007;
            }
        }
        
        int answer = 0;
        for(int i = 0; i < 10; i++)
            answer = (answer + d[n][i]) % 10007;
        System.out.println(answer);
    }
}