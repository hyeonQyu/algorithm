import java.io.*;
import java.util.*;

public class StandingInLine {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] pp = new int[n];
        for(int i = 0; i < n; i++)
            pp[i] = Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = n - 1; i >= 0; i--)
            list.add(pp[i], i + 1);
        
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext())
            System.out.print(itr.next() + " ");
        System.out.println();
    }
}
