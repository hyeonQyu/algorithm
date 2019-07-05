package level1;

import java.util.ArrayList;
import java.util.Collections;

class MyString implements Comparable<MyString> {

	int index;
	String string;
	
	MyString(int n, String string) {
		index = n;
		this.string = string;
	}
	
	@Override
	public int compareTo(MyString myString) {
		if(this.string.charAt(index) > myString.string.charAt(index))
			return 1;
		
		else if(this.string.charAt(index) == myString.string.charAt(index)) {
			int size = this.string.length() > myString.string.length() ? this.string.length() : myString.string.length();
			
			for(int i = 0; i < size; i++) {
				if(this.string.charAt(i) > myString.string.charAt(i))
					return 1;
				else if(this.string.charAt(i) < myString.string.charAt(i))
					return -1;
			}
		}
		
		return -1;
	}
	
}

public class StringIndexSort {
	
	public static String[] solution(String[] strings, int n) {
		ArrayList<MyString> list = new ArrayList<>();
		for(int i = 0; i < strings.length; i++) {
			list.add(new MyString(n, strings[i]));
		}
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			strings[i] = list.get(i).string;
		}
		
		return strings;
	}

}
