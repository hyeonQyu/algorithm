package level2;

public class QuadCompression {
	
	boolean[][] check;
	int[][] board;
	int[] answer = new int[2];
	
	public int[] solution(int[][] arr) {
		board = arr;
		int length = arr.length;
		check = new boolean[length][length];
		
        compress(0, 0, length);
        
        return answer;
    }
	
	void compress(int ly, int lx, int size) {	
		int start = board[ly][lx];
		if(size == 1) {
			answer[start]++;
			return;
		}
		
		int nextSize = size >> 1;
		
		int ry = ly + size;
		int rx = lx + size;
		
		boolean isAllSame = true;
		
		for(int i = ly; i < ry; i++) {
			for(int j = lx; j < rx; j++) {
				if(start == board[i][j])
					continue;
				
				isAllSame = false;
				break;
			}
		}
		
        if(!isAllSame){
            compress(ly, lx, nextSize);
            compress(ly, lx + nextSize, nextSize);
            compress(ly + nextSize, lx, nextSize);
            compress(ly + nextSize, lx + nextSize, nextSize);
            return;
        }
		
		if(!check[ly][lx]) {
			check[ly][lx] = true;
			answer[start]++;
		}
	}

}

