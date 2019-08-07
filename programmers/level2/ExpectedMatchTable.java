package level2;

public class ExpectedMatchTable {
	
	public int solution(int n, int a, int b) {
		int i = 0;
		while(a != b) {
			a = nextRound(a);
			b = nextRound(b);
			i++;
		}
		return i;
	}
	
	int nextRound(int i) {
		if(i % 2 == 0)
			i /= 2;
		else
			i = i / 2 + 1;
		return i;
	}

}
