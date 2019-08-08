package level3;

import java.util.Iterator;
import java.util.LinkedList;

class Computer {
	int index;
	LinkedList<Computer> link = new LinkedList<>();
	boolean isVisit;
	
	Computer(int index) {
		this.index = index;
		isVisit = false;
	}
}

public class Network {
	
	static boolean isVisitComputer(Computer com) {
		if(com.isVisit)
			return false;
		
		// 방문하지 않은 노드에 대하여
		com.isVisit = true;
		
		// 현재 컴퓨터와 연결되어 있는 컴퓨터들 방문
		Iterator<Computer> itr = com.link.iterator();
		while(itr.hasNext())
			isVisitComputer(itr.next());
		return true;
	}
	
	public static int solution(int n, int[][] computers) {
		int network = 0;
		
		Computer[] coms = new Computer[n];
		for(int i = 0; i < n; i++)
			coms[i] = new Computer(i + 1);
		
		// 서로 연결되어 있는 컴퓨터 연결
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(computers[i][j] == 1) {
					coms[i].link.add(coms[j]);
					coms[j].link.add(coms[i]);
				}
			}
		}
		
		// 탐색
		for(int i = 0; i < n; i++) {
			// 현재 컴퓨터에 대해 아래 함수가 정상적으로 실행되면 네트워크 수 증가
			if(isVisitComputer(coms[i]))
				network++;
		}
		
		return network;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] com = {{1,0,0,1},{0,1,1,1},{0,1,1,0},{1,1,0,1}};
		System.out.println(solution(4, com));
	}

}
