package level2;

public class JumpAndTeleport {

	public int solution(int n) {
		int cost = 0;
		
		while(n > 0) {
			if(n % 2 == 0)
				n /= 2;
			else {
				n--;
				cost++;
			}
		}
		
		return cost;
	}

}
