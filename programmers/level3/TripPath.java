package level3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

// 공항 클래스
class Airport {	
	String name;
	// 해당 공항에서 이동 할 수 있는 공항들의 리스트(도착 공항의 알파벳 내림차순 정렬, 티켓 번호도 함께 저장함)
	PriorityQueue<Ticket> next = new PriorityQueue<>(new Comparator<Ticket>() {
		@Override
		public int compare(Ticket o1, Ticket o2) {
			return -o1.arrival.name.compareTo(o2.arrival.name);
		}
	});
	
	Airport(String name) {
		this.name = name;
	}
	
	void addNext(Ticket ticket) {
		next.add(ticket);
	}
}

class Ticket {
	Airport arrival;
	int ticketNo;
	
	Ticket(Airport arrival, int ticketNo) {
		this.arrival = arrival;
		this.ticketNo = ticketNo;
	}
}

public class TripPath {
	
	public String[] solution(String[][] tickets) {
		// 공항 이름을 중복하여 Airport 객체를 생성하지 않도록 하기 위한 HashMap
		HashMap<String, Airport> airportMap = new HashMap<>();
		
		// 공항 객체들 생성: key값이 공항 이름이므로 공항 이름이 tickets에서 겹쳐도 하나의 공항만 존재함
		for(int i = 0; i < tickets.length; i++) {
			airportMap.put(tickets[i][0], new Airport(tickets[i][0]));
			airportMap.put(tickets[i][1], new Airport(tickets[i][1]));
		}
		
		// 각 공항에서 갈 수 있는 공항들의 리스트 정보를 넣음(각 공항에서 갈 수 있는 경로)
		for(int i = 0; i < tickets.length; i++) {
			// 공항 이름으로 공항을 찾음(해쉬맵)
			Airport departure = airportMap.get(tickets[i][0]);
			Airport arrival = airportMap.get(tickets[i][1]);
			
			// 각 공항에 도착지 추가
			Ticket ticket = new Ticket(arrival, i);
			departure.addNext(ticket);
		}
		
		/* 경로 정보 초기화 완료 */
		
		// 깊이우선탐색
		// 깊이우선탐색을 하는 도중 티켓번호가 겹치면 되돌아옴(사실 되돌아오는 개념x 순환)
		// 깊이우선탐색을 위한 스택
		Stack<Ticket> stack = new Stack<>();
		// 모든 티켓을 사용하였는지 검사하기 위함
		boolean[] isTicketContain = new boolean[tickets.length];
		// 티켓이 모두 사용되었는지 여부
		boolean isAllUsed = false;
		// 경로
		String[] path = new String[tickets.length + 1];
		int index = 0;
		
		// ICN 공항으로부터 시작, 티켓번호는 -1(없는 티켓)
		stack.add(new Ticket(airportMap.get("ICN"), -1));
		while(!isAllUsed) {
			// 현재 공항
			Ticket parent = stack.pop();
			path[index++] = parent.arrival.name;
			// 현재 공항에서 갈 다음 공항이 없다면 스택에서 빼기만 함
			if(parent.arrival.next.isEmpty()) {
				// 그러나 스택이 비었다면 탐색 종료
				if(stack.isEmpty())
					break;
				// 경로에서도 삭제함
				path[--index] = null;
				continue;
			}	
			
			// 현재 공항으로 오는 티켓을 사용함
			try {
				isTicketContain[parent.ticketNo] = true;
			}
			catch(IndexOutOfBoundsException e) {
			}
			
			Iterator<Ticket> itr = parent.arrival.next.iterator();
			while(itr.hasNext()) {
				// 현재 공항의 다음 도착지가 중복된 티켓이 아니면 스택에 넣음
				Ticket ticket = itr.next();
				if(!isTicketContain[ticket.ticketNo])
					stack.push(ticket);
			}
			
			// 모든 티켓이 사용되었으면 탐색을 종료함
			isAllUsed = true;
			for(int i = 0; i < isTicketContain.length; i++) {
				if(!isTicketContain[i]) {
					isAllUsed = false;
					break;
				}
			}
		}
		
		for(int i = 0; i < path.length; i++)
			System.out.println(path[i]);
		return path;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		String[][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}};
		
		new TripPath().solution(tickets);
	}

}
