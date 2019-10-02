package kakao;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

class Food {
	int index;
	int time;
	
	Food(int index, int time) {
		this.index = index;
		this.time = time;
	}
}

public class MukbangLive {
	
	public int solution(int[] food_times, long k) {
		int foodCount = food_times.length;
		LinkedList<Food> list = new LinkedList<>();
		
		for(int i = 0; i < foodCount; i++) {
			list.add(new Food(i, food_times[i]));
		}
		// 시간이 적게 걸리는 음식부터 오래 걸리는 음식 순으로 정렬
		Collections.sort(list, new Comparator<Food>() {
			@Override
			public int compare(Food o1, Food o2) {
				return Integer.compare(o1.time, o2.time);
			}
		});
		
		Iterator<Food> itr = list.iterator();
		int index = 0;
		int before = 0;
		int current = 0;
		int width = foodCount;
		Food food = null;
		
		while(itr.hasNext()) {
			// 현재 음식이 걸리는 시간
			food = itr.next();
			current = food.time;
			// 세로
			long height = current - before;
			if(height != 0) {
				long tmp = width * height;
				// 가로 * 세로 만큼의 음식을 한번에 먹음
				if(tmp <= k) {
					k -= tmp;
					before = current;
				}
				
				// 남은 음식을 다 먹을 수 없음(가로*세로가 남은 k보다 큼)
				else {			
					k %= width;
					list.subList(index, foodCount).sort(new Comparator<Food>() {
						// 원래 인덱스대로 정렬
						@Override
						public int compare(Food o1, Food o2) {
							return Integer.compare(o1.index, o2.index);
						}
					});
					return list.get(index + (int)k).index + 1;
				}
			}
					
			index++;
			width--;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] food_times = {4,1,1,5};
		System.out.println(new MukbangLive().solution(food_times, 7));
	}

}
