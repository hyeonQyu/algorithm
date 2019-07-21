package level1;

public class RemoveSmallestNum {
	
	public static int[] solution(int[] arr) {
		int[] answer;
		if(arr.length == 1) {
			answer = new int[1];
			answer[0] = -1;
			return answer;
		}
		
		int size = arr.length - 1;
		answer = new int[size];
		int min = 999999999;
		int point = 0;
		for(int i = 0 ; i < arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
				point = i;
			}
		}
		
		int j = 0;
		for(int i = 0; i < arr.length; i++) {
			if(i != point)
				answer[j++] = arr[i];
		}
		
		return answer;
	}

}