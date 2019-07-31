package level2;

import java.util.Arrays;

public class Lifeboat {

	public static int solution(int[] people, int limit) {
		int boat = 0;
		
		Arrays.sort(people);
		
		int start = 0;
		int end = people.length - 1;
		while(start < end) {
			if(people[end] + people[start] <= limit)
				start++;
			
			boat++;
			end--;
		}
		if(start == end)
			boat++;
		
		return boat;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] people = {70, 50, 80};
		int a = solution(people, 100);
		System.out.println(a);
	}

}
