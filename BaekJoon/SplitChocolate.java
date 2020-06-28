import java.io.*;
import java.util.*;

public class SplitChocolate {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int[] piece = new int[2];
        for(int i = 0; i < 2; i++)
            piece[i] = Integer.parseInt(arr[i]);
        
        if(piece[0] == 1 && piece[1] == 1){
            System.out.println(0);
            return;
        }    
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                Arrays.sort(a);
                Arrays.sort(b);
                if(a[1] != b[1])
                    return Integer.compare(b[1], a[1]);
                return Integer.compare(b[0], a[0]);
            }
        });
        
        int count = 0;
        pq.add(piece);
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            Arrays.sort(tmp);
            int[][] pieces = new int[2][];
            for(int i = 0; i < 2; i++){
                pieces[i] = new int[2];
                pieces[i][0] = tmp[0];
            }
            
            pieces[0][1] = tmp[1] / 2;
            if(tmp[1] % 2 == 0)
                pieces[1][1] = pieces[0][1];
            else
                pieces[1][1] = pieces[0][1] + 1;
            
            for(int i = 0; i < 2; i++){
                if(pieces[i][0] == 1 && pieces[i][1] == 1)
                    continue;
                pq.add(pieces[i]);
            }
            
            count++;
        }
        
        System.out.println(count);
    }

}
