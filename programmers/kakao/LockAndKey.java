package kakao;

public class LockAndKey {
	
	public boolean solution(int[][] key, int[][] lock) {
		int n = lock.length;
		int m = key.length;
		int countLock = 0;
		int countKey = 0;
		
		// 자물쇠 홈과 키의 돌기의 수를 셈
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(lock[i][j] == 0) {
					countLock++;
					lock[i][j] = 1;
				}
				else if(lock[i][j] == 1)
					lock[i][j] = 0;
				
				try {
					if(key[i][j] == 1)
						countKey++;
				} catch(Exception e) {}
			}
		}
		
		if(countLock > countKey)
			return false;
		if(countLock == 0)
			return true;
		
		// 회전된 키 만들기
		int[][][] keys = new int[4][m][m];
		keys[0] = key;
		for(int k = 1; k < 4; k++) {
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < m; j++) {
					keys[k][i][j] = keys[k - 1][j][m - i - 1];
				}
			}
		}
		
		for(int k = 0; k < 4; k++) {
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < m; j++) {
					System.out.print(keys[k][i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		int start = 1 - m;
		// 키 이동
		for(int k = start; k < n; k++) {
			for(int l = start; l < n; l++) {
				// 키 회전
				for(int t = 0; t < 4; t++) {
					int and = 0;
					boolean isCrush = true;
					// i,j는 key의 좌표, k+i,l+j는 자물쇠의 좌표
					for(int i = 0; i < m; i++) {
						for(int j = 0; j < m; j++) {
							try {
								int tmp = keys[t][i][j] & lock[k + i][l + j];
								// 돌기끼리 만남
								if(tmp == 0 && keys[t][i][j] == 1)
									isCrush = false;;
								and += tmp;
							} catch(Exception e) {}
						}
					}
					
					if(and == countLock && isCrush)
						return true;					
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key = {{0,0},{1,0}};
		int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
		new LockAndKey().solution(key, lock);
	}

}
