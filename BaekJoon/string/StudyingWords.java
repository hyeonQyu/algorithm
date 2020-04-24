package string;

import java.io.*;

public class StudyingWords {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s = s.toUpperCase();
		
		int[] alphabet = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'A']++;
		}
		
		int max = 0;
		int k = 0;
		int p = -1;
		for(int i = 0; i < 26; i++) {
			if(max < alphabet[i]) {
				max = alphabet[i];
				k = i;
			}
			else if(max == alphabet[i])
				p = i;
		}
		
		if(p > -1 && alphabet[p] == max)
			System.out.println('?');
		else
			System.out.println((char)(k + 'A'));
		
	}

}
