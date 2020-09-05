import java.io.*;
import java.util.*;

public class NumTie {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pos = new PriorityQueue<>();
        PriorityQueue<Integer> neg = new PriorityQueue<>();
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 1)
            	sum++;
            else if(tmp > 1)
            	pos.add(tmp);
            else
            	neg.add(tmp);
        }
        
        if(pos.size() % 2 != 0)
        	pos.add(1);
        if(neg.size() % 2 != 0)
        	neg.add(1);
        
        while(!pos.isEmpty())
        	sum += (pos.poll() * pos.poll());
        while(!neg.isEmpty())
        	sum += (neg.poll() * neg.poll());
        
        System.out.println(sum);
    }
}
