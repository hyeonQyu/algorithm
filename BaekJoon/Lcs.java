import java.io.*;

public class Lcs {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        
        int length1 = s1.length();
        int length2 = s2.length();
        
        int[][] d = new int[length1 + 1][];
        d[0] = new int[length2 + 1];
        for(int i = 1; i <= length1; i++){
            d[i] = new int[length2 + 1];
            for(int j = 1; j <= length2; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    d[i][j] = d[i - 1][j - 1] + 1;
                else
                    d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
            }
        }
        
        System.out.println(d[length1][length2]);
    }
}
