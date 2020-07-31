import java.io.*;
import java.util.*;

public class NumberCard {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");       
        int[] cards = new int[n];
        for(int i = 0; i < n; i++)
            cards[i] = Integer.parseInt(arr[i]);
        
        int m = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");
        int[][] checks = new int[m][];
        for(int i = 0; i < m; i++){
            checks[i] = new int[2];
            checks[i][0] = Integer.parseInt(arr[i]);
            checks[i][1] = i;
        }
        
        Arrays.sort(cards);
        Arrays.sort(checks, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);   
            }
        });
        
        int i = 0;
        int j = 0;
        boolean[] hasCard = new boolean[m];
        while(i < n && j < m){
            if(cards[i] == checks[j][0]){
                hasCard[checks[j][1]] = true;
                i++;
                j++;
            } else{
                if(cards[i] > checks[j][0])
                    j++;
                else
                    i++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(i = 0; i < m; i++)
            sb.append((hasCard[i] ? 1 : 0) + " ");
        System.out.println(sb);
	}
}
