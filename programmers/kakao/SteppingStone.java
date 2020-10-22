package kakao;

public class SteppingStone {
	
	public int solution(int[] stones, int k) {
		int length = stones.length;
		int left = 0;
		int right = 200000000;
		int answer = 0;
		while(left <= right) {
			System.out.println("left: " + left);
			System.out.println("right: " + right);
			boolean canJump = true;
			
			int mid = (left + right) / 2;
			int count = 0;
			for(int i = 0; i < length; i++) {
				if(stones[i] - mid <= 0) {
					// 점프할 수 없음
					if(++count == k) {
						canJump = false;
						break;
					}
				}
				else
					count = 0;
			}
			
			if(canJump) {
				answer = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		return answer;
	}

}
