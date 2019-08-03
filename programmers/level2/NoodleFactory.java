package level2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NoodleFactory {
	
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		int count = 0;
		int index = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		for(int i = 0; i < k; i++) {
			if(index < dates.length && i == dates[index])
				pq.add(supplies[index++]);
			if(stock == 0) {
				stock += pq.poll();
				count++;
			}
			stock--;
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dates[] = {4, 10, 15};
		int supplies[] = {20, 5, 10};
		System.out.println("answer: " + solution(4, dates, supplies, 30));
	}

}
