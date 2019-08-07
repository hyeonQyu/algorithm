package level2;

import java.util.PriorityQueue;

public class Spicy {
	
	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> newScoville = new PriorityQueue<>(); 
		int count = 0;
		
		for(int i = 0; i < scoville.length; i++)
			newScoville.offer(scoville[i]);
		
		while(newScoville.size() > 1) {
			if(newScoville.peek() >= K)
				break;
			newScoville.offer(newScoville.poll() + 2 * newScoville.poll());
			count++;
		}
		
		if(newScoville.size() == 1) {
			if(newScoville.peek() < K)
				count = -1;
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sc = {1, 1, 1};
		int a = solution(sc, 8);
		System.out.println(a);
	}

}
