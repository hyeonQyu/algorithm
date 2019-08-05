package level2;

import java.util.Arrays;

public class Phoneketmon {
	
	public static int solution(int[] nums) {
		int n = nums.length / 2;
		int count = 1;
		Arrays.sort(nums);
		
		int tmp = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(tmp != nums[i]) {
				n--;
				if(n == 0)
					break;
				
				count++;
				tmp = nums[i];
			}
		}
		
		return count;
	}

}
