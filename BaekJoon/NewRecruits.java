import java.io.*;
import java.util.*;

public class NewRecruits{
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] men = new int[n][];
            for(int i = 0; i < n; i++){
                men[i] = new int[2];
                String[] arr = br.readLine().split(" ");
                for(int j = 0; j < 2; j++)
                    men[i][j] = Integer.parseInt(arr[j]);
            }
            
            Arrays.sort(men, new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    return Integer.compare(a[0], b[0]);
                }
            });
            
            int min = men[0][1];
            int count = 1;
            for(int i = 1; i < n; i++){
                if(min > men[i][1]){
                    count++;
                    min = men[i][1];
                }
            }
            sb.append(count);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}