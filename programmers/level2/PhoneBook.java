package level2;

import java.util.Arrays;
import java.util.Comparator;

class CompAscLen implements Comparator<String> {

	@Override
	public int compare(String a, String b) {
		// TODO Auto-generated method stub
		int loop = a.length() > b.length() ? b.length() : a.length();
		
		int i;
		for(i = 0; i < loop; i++) {
			int an = a.charAt(i) - '0';
			int bn = b.charAt(i) - '0';
			if(an > bn)
				return 1;
			else if(an < bn)
				return -1;
		}
		if(a.length() == b.length())
			return 0;	
		else if(loop == b.length())
			// a가 더 긺
			return 1;
		else 
			// b가 더 긺
			return -1;
	}
	
}

public class PhoneBook {
	
	public static boolean solution(String[] phone_book) {
		CompAscLen comp = new CompAscLen();
		Arrays.sort(phone_book, comp);
		
		for(int i = 0; i < phone_book.length - 1; i++) {
			for(int j = i + 1; j < phone_book.length; j++) {
				if(phone_book[j].contains(phone_book[i]))
					return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = {"123", "456", "789"};
		System.out.println(solution(test));
	}

}
