import java.io.*;

public class FindingAlphabet {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int[] alphabet = new int[26];
        for(int i = 0; i < 26; i++){
            alphabet[i]--;
        }
        
        for(int i = 0; i < s.length(); i++){
        	int n = s.charAt(i) - 'a';
        	if(alphabet[n] == -1)
        		alphabet[n] = i;
        }
        
        for(int i = 0; i < 26; i++){
            System.out.print(alphabet[i] + " ");
        }
    }

}
