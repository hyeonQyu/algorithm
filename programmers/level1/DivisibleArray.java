package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class DivisibleArray {
	
	public static int[] solution(int[] arr, int divisor) {
		ArrayList list = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % divisor == 0) {
				list.add(arr[i]);
			}
		}
		
		if(list.size() > 0) {
			int[] answer = new int[list.size()];
			for(int i = 0; i < answer.length; i++)
				answer[i] = (int)list.get(i);
			
			Arrays.sort(answer);
			return answer;
		}
		else {
			int[] answer = new int[1];
			answer[0] = -1;
			return answer;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
