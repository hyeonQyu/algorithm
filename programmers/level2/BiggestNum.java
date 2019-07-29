package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class CompDesc implements Comparator<String> {

	@Override
	public int compare(String a, String b) {
		int ab = Integer.parseInt(a + b);
		int ba = Integer.parseInt(b + a);
		
		if(ab > ba)
			return -1;
		else if(ba > ab)
			return 1;
		else
			return 0;
	}
	
}

public class BiggestNum {

	public static String solution(int[] numbers) {
		ArrayList<String> list = new ArrayList<>();
		String answer = "";
		
		for(int i = 0; i < numbers.length; i++)
			list.add(Integer.toString(numbers[i]));
		
		CompDesc comp = new CompDesc();
		Collections.sort(list, comp);
		
		for(int i = 0; i < list.size(); i++) 
			answer += list.get(i);
		
		while(answer.charAt(0) == '0') 
			return "0";
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,0,70};
		System.out.println(solution(arr));
	}

}
