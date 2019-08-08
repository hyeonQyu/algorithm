package level3;

public class TileDecorations {
	
	public long solution(int N) {
		long[] rectangles = new long[N + 1];
		
		rectangles[1] = 1;
		rectangles[2] = 1;
		for(int i = 3; i <= N; i++)
			rectangles[i] = rectangles[i - 2] + rectangles[i - 1];
		
		return 2 * rectangles[N] + 2 * (rectangles[N - 1] + rectangles[N]);
	}

}
