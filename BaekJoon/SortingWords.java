import java.io.*;
import java.util.*;

public class SortingWords {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++)
            set.add(br.readLine());
        ArrayList<String> words = new ArrayList<>(set);
        
        Collections.sort(words, new Comparator<String>(){
            // 길이의 오름차순, 길이가 같으면 사전순
           @Override
            public int compare(String s1, String s2){
                int c = Integer.compare(s1.length(), s2.length());
                if(c != 0)
                    return c;
                return s1.compareTo(s2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        int length = words.size();
        for(int i = 0; i < length; i++)
            sb.append(words.get(i) + "\n");
        System.out.print(sb);
    }
}
