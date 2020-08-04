import java.io.*;

public class Padovan{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++){
            int n = Integer.parseInt(br.readLine());
            long[] init = {1, 1, 1, 2, 2, 3};
            long[] padovan = new long[n > 6 ? n : 6];
            for(int i = 0; i < 6; i++)
                padovan[i] = init[i];
            for(int i = 6; i < n; i++)
                padovan[i] = padovan[i - 1] + padovan[i - 5];
            System.out.println(padovan[n - 1]);
        }
    }
}