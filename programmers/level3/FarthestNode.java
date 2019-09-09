package level3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int id;
	LinkedList<Node> nextList = new LinkedList<>();
	int distanceFrom1;
	boolean isVisit;
	
	Node(int id) {
		this.id = id;
		distanceFrom1 = 0;
	}
	
	void addNextList(Node node) {
		nextList.add(node);
	}
}

public class FarthestNode {
	
	public int solution(int n, int[][] edge) {
		int count = 0;
		
		// 노드 생성
		Node[] nodes = new Node[n];
		for(int i = 0; i < n; i++)
			nodes[i] = new Node(i);
		
		// 노드 연결
		for(int i = 0; i < edge.length; i++) {
			nodes[edge[i][0]-1].addNextList(nodes[edge[i][1]-1]);
			nodes[edge[i][1]-1].addNextList(nodes[edge[i][0]-1]);
		}
		
		// 너비 우선 탐색
		int maxDistance = visitNode(nodes[0]);
		
		for(int i = 0; i < n; i++) {
			System.out.println(i + ": " + nodes[i].distanceFrom1);
			if(nodes[i].distanceFrom1 == maxDistance)
				count++;
		}
		
		return count;
	}
	
	int visitNode(Node node) {
		int maxDistance = 0;
		Queue<Node> queue = new LinkedList<>();
		node.isVisit = true;
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			
			Iterator<Node> itr = curNode.nextList.iterator();
			while(itr.hasNext()) {
				Node tmp = itr.next();
				if(!tmp.isVisit) {
					tmp.isVisit = true;
					tmp.distanceFrom1 = curNode.distanceFrom1 + 1;
					maxDistance = tmp.distanceFrom1;
					queue.add(tmp);
				}
			}
		}
		
		return maxDistance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		new FarthestNode().solution(6, edge);
	}

}
