import java.io.*;
import java.util.*;

public class LostBracket {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        
        int point = 0;
        int left = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < length; i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
                continue;
            
            list.add(left + Integer.parseInt(s.substring(point, i)));
            point = i + 1;
            left = 0;
            
            if(c == '+') 
                left += list.removeLast();
        }
        list.add(left + Integer.parseInt(s.substring(point, length)));
        int sum = list.remove();
        while(!list.isEmpty())
        	sum -= list.remove();
        
        System.out.println(sum);
    }
}
