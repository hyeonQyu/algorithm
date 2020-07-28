import java.io.*;
import java.util.*;

public class SortingCoord {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] coord = new int[n][];
        for(int i = 0; i < n; i++){
            String[] arr = br.readLine().split(" ");
            coord[i] = new int[2];
            coord[i][0] = Integer.parseInt(arr[0]);
            coord[i][1] = Integer.parseInt(arr[1]);
        }
        Arrays.sort(coord, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                int c = Integer.compare(a[0], b[0]);
                if(c == 0)
                    return Integer.compare(a[1], b[1]);
                return c;
            }
        });
        
        for(int i = 0; i < n; i++){
            System.out.println(coord[i][0] + " " + coord[i][1]);
        }
    }

}
