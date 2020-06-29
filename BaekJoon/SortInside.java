import java.io.*;
import java.util.*;

public class SortInside {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        Integer[] digit = new Integer[n.length()];
        for(int i = 0; i < digit.length; i++){
            digit[i] = n.charAt(i) - '0';
        }
        Arrays.sort(digit, Collections.reverseOrder());
        for(int i = 0; i < digit.length; i++){
            System.out.print(digit[i]);
        }
    }
}
