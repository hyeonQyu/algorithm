package kakao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

class GameBlock {
	int[][] squares = new int[4][2];
	int squareIndex = 0;
	boolean isNeverDeletable = false;
	
	boolean isDeletable(int[][] board) {
		int minRow = 9999;
		int minCol = 9999;
		int maxRow = 0;
		int maxCol = 0;
		
		for(int i = 0; i < 4; i++) {
			if(squares[i][0] < minRow)
				minRow = squares[i][0];			
			if(squares[i][1] < minCol)
				minCol = squares[i][1];
			
			if(squares[i][0] > maxRow)
				maxRow = squares[i][0];
			if(squares[i][1] > maxCol)
				maxCol = squares[i][1];
		}
		
		// 3x2 혹은 2x3의 작은 사각형 범위 만들기
		int[][] miniSquare = new int[3][3];
		for(int i = 0; i <= maxRow - minRow; i++) {
			for(int j = 0; j <= maxCol - minCol; j++) {
				miniSquare[i][j] = -1;
			}
		}
		// 작은 사각형 범위 안에 칸 채우기
		for(int i = 0; i < 4; i++) {
			miniSquare[squares[i][0] - minRow][squares[i][1] - minCol] = 1;
		}
		
		int[][] checkCol = new int[2][2];
		int checkIndex = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				// 작은 사각형 안에서 채워져 있는 블록 아래 빈 블록이 있으면 영원히 지울 수 없는 블록임
				if(miniSquare[i][j] == -1) {
					try {
						if(miniSquare[i - 1][j] == 1) {
							isNeverDeletable = true;
							return false;
						}
					} catch(Exception e) {}
					
					// j열 위에 다른 블록이 있는지 검사해야 함
					checkCol[checkIndex][0] = i + minRow;
					checkCol[checkIndex++][1] = j + minCol;
				}
			}
		}
		
		for(int n = 0; n < 2; n++) {
			int j = checkCol[n][1];
			int length = checkCol[n][0];
			for(int i = 0; i <= length; i++) {
				// 위에 다른 블록이 있어서 제거할 수 없는 상황
				if(board[i][j] != 0)
					return false;
			}
		}
		
		return true;
	}
	
	void deleteInBoard(int[][] board) {
		for(int i = 0; i < 4; i++) {
			board[squares[i][0]][squares[i][1]] = 0;
		}
	}
}

public class BlockGame {
	
	public int solution(int[][] board) {
		HashMap<Integer, GameBlock> map = new HashMap<>();
		int n = board.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				GameBlock block;
				
				if(board[i][j] == 0)
					continue;
				
				// 블록을 생성
				if(map.get(board[i][j]) == null) {
					block = new GameBlock();
					map.put(board[i][j], block);
				}
				
				// 블록을 이루는 칸의 정보를 넣음
				block = map.get(board[i][j]);
				block.squares[block.squareIndex][0] = i;
				block.squares[block.squareIndex++][1] = j;
			}
		}
		
		LinkedList<GameBlock> blocks = new LinkedList<>();
		Iterator<Integer> keySelector = map.keySet().iterator();
		while(keySelector.hasNext()) {
			int key = keySelector.next();
			blocks.add(map.get(key));
		}
		
		int count = 0;
		int delete = 1;
		while(delete != 0) {
			delete = 0;
			
			Iterator<GameBlock> itr = blocks.iterator();
			while(itr.hasNext()) {
				GameBlock block = itr.next();
				// 블록을 지울 수 있으면 삭제
				if(block.isNeverDeletable)
					continue;
				if(block.isDeletable(board)) {
					itr.remove();
					block.deleteInBoard(board);
					count++;
					delete++;
				}
			}
		}		
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}};
		System.out.println(new BlockGame().solution(board));
	}

}
