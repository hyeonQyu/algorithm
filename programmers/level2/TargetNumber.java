package level2;

public class TargetNumber {
	
	int[] nums;
	int goal;
	int count = 0;
	
	public int solution(int[] numbers, int target) {
		nums = numbers;
		goal = target;
		
		calculate(true, 0, 0);
		calculate(false, 0, 0);
		return count;
	}
	
	void calculate(boolean isPlus, int accum, int index) {
		if(isPlus) 
			accum += nums[index];			
		else
			accum -= nums[index];
		
		if(index == nums.length - 1) {
			// 마지막 깊이라면
			if(accum == goal)
				count++;
		}
		else {
			// 마지막 깊이가 아님
			calculate(true, accum, index + 1);
			calculate(false, accum, index + 1);
		}
	}

}
