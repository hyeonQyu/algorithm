import java.io.*;

public class SquareSum{
    static int[] d;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            if(isSquare(i))
                d[i] = 1;
            else
                d[i] = findMin(i);
        }
        for(int i = 1; i <= n; i++) {
        	System.out.println(d[i]);
        }
        System.out.println(d[n]);
    }
    
    static boolean isSquare(int i){
        double sqrt = Math.sqrt(i);
        sqrt -= (int)sqrt;
        if(sqrt == 0)
            return true;
        return false;
    }
    
    static int findMin(int m){
        int limit = m / 2;
        int min = Integer.MAX_VALUE;
        for(int i = m - 1; i >= limit; i--){
            int tmp = d[i] + d[m - i];
            min = min > tmp ? tmp : min;
        }
        return min;
    }
}