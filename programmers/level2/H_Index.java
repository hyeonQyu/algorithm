package level2;

import java.util.Arrays;

public class H_Index {
	
	public static int solution(int[] citations) {
		int length = citations.length;
		int[] answers = new int[length];
		Arrays.sort(citations);
		int j = length - 1;
		for(int i = 0; i < length; i++) {
			answers[i] = citations[j--];
			if(i == 0 && answers[i] == 0)
				return 0;
			if(i > answers[i])
				return i;
		}
		
		return length;
//		while(citations[h] > citations.length - h && h > 0) {
//			h--;
//		}
//		if(h == 0 && citations[h] > citations.length)
//			return citations.length;
//		
//		return citations[h];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,0,6,1,5};
		System.out.println(solution(a));
	}

}
