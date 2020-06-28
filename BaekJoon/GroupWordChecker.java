import java.io.*;

public class GroupWordChecker {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            if(isGroupWord(s))
                count++;
        }
        
        System.out.println(count);
    }
    
    private static boolean isGroupWord(String s){
        int length = s.length();
        boolean[] arr = new boolean[26];
        
        char prev = s.charAt(0);
        arr[prev - 'a'] = true;
        for(int i = 1; i < length; i++){
            char cur = s.charAt(i);
            if(arr[cur - 'a'] && prev != cur)
                return false;
            arr[cur - 'a'] = true;
            prev = cur;
        }
        return true;
    }
}
