package kakao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class NewsClustering {
	
	void splitStringBinary(String str, LinkedList<String> set) {
		for(int i = 0; i < str.length() - 1; i++) {
			char first = Character.toLowerCase(str.charAt(i));
			char second = Character.toLowerCase(str.charAt(i + 1));
			
			// 만들어진 두글자짜리 문자열
			if(Character.isAlphabetic(first) && Character.isAlphabetic(second)) {
				String tmp = Character.toString(first) + Character.toString(second);	
				set.add(tmp);
			}		
		}
	}
	
	void copyToArray(String[] set, LinkedList<String> list) {
		Iterator<String> itr = list.iterator();
		int i = 0;
		
		while(itr.hasNext()) {
			set[i++] = itr.next();
		}
	}
	
	double intersect(String[] set1, String[] set2) {
		double count = 0;

		int i = 0;
		int j = 0;
		
		while(i < set1.length && j < set2.length) {
			if(set1[i].equals(set2[j])) {
				count++;
				i++;
				j++;
			}
			// set2의 단어가 뒤로 가야 함
			else if(set1[i].compareTo(set2[j]) > 0) {
				j++;
			}
			// set1의 단어가 뒤로 가야 함
			else if(set1[i].compareTo(set2[j]) < 0) {
				i++;
			}
		}
		
		return count;
	}
	
	double union(String[] set1, String[] set2) {
		double count = 0;
		
		int i = 0;
		int j = 0;
		
		while(i < set1.length && j < set2.length) {
			if(set1[i].equals(set2[j])) {
				i++;
				j++;
			}
			// set2의 단어가 뒤로 가야 함
			else if(set1[i].compareTo(set2[j]) > 0) {
				j++;
			}
			// set1의 단어가 뒤로 가야 함
			else if(set1[i].compareTo(set2[j]) < 0) {
				i++;
			}
			count++;
		}
		
		// set2의 뒷부분을 합집합에 추가
		if(i == set1.length) {
			count += set2.length - j;
		}
		// set1의 뒷부분을 합집합에 추가
		else if(j == set2.length) {
			count += set1.length - i;
		}
		
		return count;
	}
	
	public int solution(String str1, String str2) {
		LinkedList<String> list1 = new LinkedList<>();
		LinkedList<String> list2 = new LinkedList<>();
		
		// 단어를 두글자씩 쪼개서 set에 넣음
		splitStringBinary(str1, list1);
		splitStringBinary(str2, list2);
		
		if(list1.size() == 0 && list2.size() == 0)
			return 65536;
		
		String[] set1 = new String[list1.size()];
		String[] set2 = new String[list2.size()];		
		copyToArray(set1, list1);
		copyToArray(set2, list2);
		
		Arrays.sort(set1);
		Arrays.sort(set2);
		
		double intersectSize = intersect(set1, set2);
		double unionSize = union(set1, set2);
		
		return (int)Math.floor((intersectSize / unionSize) * 65536);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NewsClustering().solution("handshake", "shake hands");
	}

}
