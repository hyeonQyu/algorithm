package kakao;

import java.util.*;

public class ClawCraneGame {
	
	public int solution(int[][] board, int[] moves) {
        Stack<Integer>[] stack = new Stack[board.length];
        Stack<Integer> basket = new Stack<>();
        
        for(int i = 0; i < board.length; i++)
            stack[i] = new Stack<>();
        
        for(int i = board.length - 1; i >= 0; i--){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != 0)
                    stack[j].push(board[i][j]);
            }
        }
        
        int answer = 0;
        for(int i = 0; i < moves.length; i++){
            int n = moves[i];
            if(stack[n - 1].isEmpty())
                continue;
            
            int doll = stack[n - 1].pop();
            if(!basket.isEmpty()){
                if(basket.peek() == doll){
                    basket.pop();
                    answer += 2;
                    continue;
                }
            }
            
            basket.push(doll);
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		// TODO Auto-generated method stub
		System.out.println(new ClawCraneGame().solution(board, moves));
	}

}
