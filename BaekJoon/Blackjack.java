import java.io.*;
import java.util.*;

public class Blackjack {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        
        Integer[] cards = new Integer[n];
        arr = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            cards[i] = Integer.parseInt(arr[i]);
        }
        // 내림차순 정렬
        Arrays.sort(cards, Comparator.reverseOrder());
        
        int max = 0;
        for(int i = 0; i < n - 2; i++){
            int first = cards[i];
            
            for(int j = i + 1; j < n - 1; j++){
                if(first + cards[j] > m)
                    continue;
                
                int sum = first + cards[j];
                
                for(int k = j + 1; k < n; k++){
                    int tmp = sum + cards[k];
                    if(tmp > m)
                        continue;
                    if(max < tmp)
                        max = tmp;
                    break;
                }
            }
        }
        
        System.out.println(max);
    }

}
