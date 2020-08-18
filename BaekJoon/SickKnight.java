import java.io.*;
import java.util.*;

public class SickKnight {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        if(n == 1)
        	answer = 1;
        else if(n == 2)
        	answer = Math.min((m + 1) / 2, 4);
        else if(m < 7)
        	answer = Math.min(m, 4);
        else
        	answer = m - 7 + 5;
        System.out.println(answer);
    }

}
