package level2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class OrderPrior {
	int priority;
	int order;
	
	OrderPrior(int priority, int order){
		this.priority = priority;
		this.order = order;
	}
}

public class Printer {
	
	public static int solution(int[] priorities, int location) {
		LinkedList<OrderPrior> printed = new LinkedList<>();
		LinkedList<OrderPrior> queue = new LinkedList<>();
		
		for(int i = 0; i < priorities.length; i++) {
			queue.add(new OrderPrior(priorities[i], i));
		}
		
		while(!queue.isEmpty()) {
			System.out.println("큐");
			for(int i = 0; i < queue.size(); i++) {
				System.out.print(queue.get(i).priority + " ");
			}
			System.out.println();
			
			System.out.println("프린트됨");
			for(int i = 0; i < printed.size(); i++) {
				System.out.print(printed.get(i).priority + " ");
			}
			System.out.println();
			
			OrderPrior tmp = queue.poll();
			boolean isHigher = false;
			
			for(int i = 0; i < queue.size(); i++) {
				if(tmp.priority < queue.get(i).priority) {
					isHigher = true;
					break;
				}
			}
			
			// 큐 맨 뒤에 넣음
			if(isHigher) {
				queue.add(tmp);
			}
			// 프린트함
			else {
				printed.add(tmp);
			}
			
		}
		
		int index = 1;
		Iterator<OrderPrior> itr2 = printed.iterator();
		while(itr2.next().order != location) {
			index++;
		}
		
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prior = {1, 1, 9, 1, 1, 1};
		int location = 0;
		System.out.print(solution(prior, location));
	}

}
