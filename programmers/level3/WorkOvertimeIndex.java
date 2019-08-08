package level3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class WorkOvertimeIndex {
	
	public long solution(int n, int[] works) {
		long sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for(int i = 0; i < works.length; i++)
			pq.offer(works[i]);
		
		for(int i = 0; i < n; i++) {
			if(pq.peek() > 0) {
				int work = pq.poll() - 1;
				pq.offer(work);
			}
			else
				break;
		}
		
		while(!pq.isEmpty()) {
			int work = pq.poll();
			sum += (work * work);
		}
		return sum;
	}

}
