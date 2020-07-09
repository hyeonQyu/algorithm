import java.io.*;
import java.util.*;

public class FindingNum {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        String[] arr = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            set.add(Integer.parseInt(arr[i]));
        }
        n = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            System.out.println(set.contains(Integer.parseInt(arr[i])) ? 1 : 0);
        }
    }
}
