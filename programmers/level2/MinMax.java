package level2;

public class MinMax {

	public String solution(String s) {
		String[] arr = s.split(" ");
		int min = Integer.parseInt(arr[0]);
		int max = min;
		
		for(int i = 1; i < arr.length; i++) {
			int n = Integer.parseInt(arr[i]);
			if(min > n)
				min = n;
			if(max < n)
				max = n;
		}
		
		return min + " " + max;
	}

}
