package level3;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectIsland {
	
	public static int solution(int n, int[][] costs) {
		// 2차원배열에서 3번째 요소의 값으로 정렬
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		// 섬 연결 정보와 다리 건설 정보
		boolean[] isConnect = new boolean[n];
		boolean[] isBuild = new boolean[costs.length];
		
		// 첫 다리(가장 짧은 다리) 연결
		int countConnect = 2;
		int totalCost = costs[0][2];
		isConnect[costs[0][0]] = true;
		isConnect[costs[0][1]] = true;
		
		for(int i = 0; i < costs.length; i++) {
			int is1 = costs[i][0];
			int is2 = costs[i][1];
			
			// 둘 중 하나만 연결된 섬인 경우 그 다리를 연결
			// 둘 다 연결되어 있으면 연결할 필요가 없고, 둘 다 연결되어있지 않은 섬이면 연결할 수 없음(크루스칼)
			// 다리도 건설되지 않은 다리이면 연결
			if(!isBuild[i] && (isConnect[is1] ^ isConnect[is2])) {
				isConnect[is1] = true;
				isConnect[is2] = true;
				isBuild[i] = true;
				totalCost += costs[i][2];
				countConnect++;
				// 연결정보 최신화 후 처음으로 돌아감(연결될 수 있는 다리가 바뀔 수 있음)
				i = 0;
			}
			
			if(countConnect == n)
				break;			
		}
		
		return totalCost;
	}

}
