package level2;

public class BiggestSquare {
	
	public static int solution(int[][] board) {
		int max = -1;
		
		for(int i = 1; i < board.length; i++) {
			for(int j = 1; j < board[i].length; j++) {
				if(board[i][j] > max)
					max = board[i][j];
				if(board[i][j] == 0)
					continue;
				
				board[i][j] = Math.min(Math.min(board[i][j-1], board[i-1][j]), board[i-1][j-1]) + 1;
				if(board[i][j] > max)
					max = board[i][j];
			}
		}
		
		return max * max;
		
		
		/* 시간 초과된 코드
		int max = -1;		

		for(int i = 1; i < board.length; i++) {
			for(int j = 1; j < board[i].length; j++) {
				int tmp = board[i][j];
				
                if(max < tmp)
                    max = tmp;
				if(tmp == 0)
					continue;
				
				int k = i - 1;
				int l = j - 1;
				
				while(k >= 0 && l >= 0) {
					if(board[k][l] == 0)
						break;
						// 왼쪽 위가 0이 아닌 경우(왼쪽 위가 정사각형의 오른쪽 아래 꼭짓점인 경우)
						boolean isUpdatable = true;
						
						// 왼쪽과 위가 1 이상의 숫자로 채워져 있는지 검사
						for(int r = i; r >= k; r--) {
							if(board[r][l] == 0) {
								isUpdatable = false;
								break;
							}
						}
						if(isUpdatable) {
							for(int c = j; c >= l; c--) {
								if(board[k][c] == 0) {
									isUpdatable = false;
									break;
								}
							}
						}
						
						if(!isUpdatable)
							break;
						tmp++;
						k--;
						l--;
					}
				
				board[i][j] = tmp;
				
				if(tmp > max)
					max = tmp;
			}
		}
		
		return max * max; */
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0, 0, 0, 0}, {0, 0, 0, 0}, {1, 1, 0, 0}, {1, 1, 0, 0}};
		solution(board);
	}

}