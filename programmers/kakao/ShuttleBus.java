package kakao;

import java.util.Collections;
import java.util.PriorityQueue;

class Time implements Comparable<Time> {
	int hour;
	int minute;
	
	Time(String time) {
		String[] arr = time.split(":");
		
		hour = Integer.parseInt(arr[0]);
		minute = Integer.parseInt(arr[1]);
	}
	
	Time(Time time) {
		hour = time.hour;
		minute = time.minute;
	}
	
	void addTime(int t) {
		minute += t;
		
		if(minute >= 60) {
			minute -= 60;
			hour++;
		}
	}
	
	// 시간의 오름차순 정렬
	@Override
	public int compareTo(Time t) {
		int c = Integer.compare(hour, t.hour);
		if(c == 0)
			return Integer.compare(minute, t.minute);
		return c;
	}
}

class Bus {
	Time time;
	PriorityQueue<Time> passengers = new PriorityQueue<>(Collections.reverseOrder());
	
	Bus(Time time) {
		this.time = time;
	}
	
	// 승객을 태움
	void addPassenger(Time passenger) {
		passengers.add(passenger);
	}
}

public class ShuttleBus {
	
	public String solution(int n, int t, int m, String[] timetable) {
		// 크루는 먼저 온 순서대로 정렬됨
		PriorityQueue<Time> crews = new PriorityQueue<>();
		for(int i = 0; i < timetable.length; i++) {
			crews.add(new Time(timetable[i]));
		}
		
		Bus[] bus = new Bus[n];
		Time time = new Time("09:00");
		for(int i = 0; i < n; i++) {
			if(i != 0)
				time.addTime(t);
			bus[i] = new Bus(time);
			
			// 한 버스에 m명까지 탑승할 수 있음
			for(int j = 0; j < m; j++) {
				// 승객이 버스보다 먼저 왔다면
				try {
					if(bus[i].time.compareTo(crews.peek()) >= 0) {
						// 버스에 승객 탑승
						if(!crews.isEmpty()) {
							bus[i].addPassenger(crews.poll());
						}
					}
					// 다음 승객부터는 다음에 타야 함(버스가 m명을 채우지 못함)
					else
						break;
				} catch(Exception e) {
					break;
				}
			}		
		}

		int hour, minute;
		// 막차에 승객이 꽉 참
		if(bus[n - 1].passengers.size() == m) {
			Time lastPassenger = bus[n - 1].passengers.poll();
			
			// 가장 마지막에 탄 승객보다 1분 더 빨라야 함
			hour = lastPassenger.hour;
			minute = lastPassenger.minute - 1;
			
			if(minute < 0) {
				minute = 59;
				hour--;
			}
		}
		// 막차가 여유 있음
		else {
			// 막차시간에 맞춤
			hour = bus[n - 1].time.hour;
			minute = bus[n - 1].time.minute;
		}

		String hourStr, minStr;
		if(hour < 10)
			hourStr = "0" + hour;
		else
			hourStr = Integer.toString(hour);
		if(minute < 10)
			minStr = "0" + minute;
		else
			minStr = Integer.toString(minute);

		return hourStr + ":" + minStr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] timetable = {"09:10", "09:09", "08:00"};
		new ShuttleBus().solution(2, 10, 2, timetable);
	}

}
