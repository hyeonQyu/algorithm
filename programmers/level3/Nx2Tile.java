package level3;

public class Nx2Tile {

	public int solution(int n) {
		int case1 = 1;
		int case2 = 2;
		int case3 = n == 1 ? case1 : case2;
		for(int i = 3; i <= n; i++) {
			case3 = (case1 + case2) % 1000000007;
			case1 = case2;
			case2 = case3;
		}
		
		return case3 % 1000000007;
	}

}
