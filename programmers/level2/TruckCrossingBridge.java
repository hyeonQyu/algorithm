package level2;

import java.util.LinkedList;

class Truck {
	int weight;
	int time;
	
	Truck(int weight) {
		this.weight = weight;
		this.time = 1;
	}
	
	Truck(int weight, int time){
		this.weight = weight;
		this.time = time;
	}
}

public class TruckCrossingBridge {
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int crossedCount = 0;
		LinkedList<Truck> crossing = new LinkedList<>();
		LinkedList<Integer> waiting = new LinkedList<>();
		
		for(int i = 0; i < truck_weights.length; i++) {
			waiting.add(truck_weights[i]);
		}
		
		int curWeight = 0;
		int totalTime = 0;
		while(crossedCount < truck_weights.length) {
			// 시간 경과
			totalTime++;
			for(int i = 0; i < crossing.size(); i++) {
				Truck tmp = crossing.get(i);
				crossing.set(i, new Truck(tmp.weight, tmp.time + 1));
			}
			
			if(crossing.size() > 0) {
				if(crossing.peek().time > bridge_length) {
					// 다리를 다 건넘
					Truck tmp = crossing.poll();
					curWeight -= tmp.weight;
					crossedCount++;
				}
			}
			
			if(waiting.size() > 0) {
				if(curWeight + waiting.peek() <= weight) {
					// 트럭이 올라갈 수 있음
					int addWeight = waiting.poll();
					crossing.add(new Truck(addWeight));
					curWeight += addWeight;
				}
			}	
			
			System.out.println("경과 시간: " + totalTime);
			System.out.println("다리를 지난 트럭 수: " + crossedCount);
			System.out.print("다리를 건너는 트럭: ");
			for(int i = 0; i < crossing.size(); i++)
				System.out.print(crossing.get(i).weight + " ");
			System.out.println();
			System.out.print("대기중인 트럭: ");
			for(int i = 0; i < waiting.size(); i++)
				System.out.print(waiting.get(i) + " ");
			System.out.println();
		}
		
		return totalTime;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] truck = {7, 4, 5, 6};
		System.out.println(solution(2, 10, truck));
	}

}
