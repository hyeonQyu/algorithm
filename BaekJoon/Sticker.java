import java.io.*;

public class Sticker{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][];
            int[][] d = new int[2][];
            for(int i = 0; i < 2; i++){
                sticker[i] = new int[n];
                d[i] = new int[n];
                String[] arr = br.readLine().split(" ");
                for(int j = 0; j < n; j++)
                    sticker[i][j] = Integer.parseInt(arr[j]);
            }
            
            d[0][0] = sticker[0][0];
            d[1][0] = sticker[1][0];
            for(int i = 1; i < n; i++){
                d[0][i] = Math.max(d[1][i - 1] + sticker[0][i], d[0][i - 1]);
                d[1][i] = Math.max(d[0][i - 1] + sticker[1][i], d[1][i - 1]);
            }
            System.out.println(Math.max(d[0][n - 1], d[1][n - 1]));
        }
    }
}