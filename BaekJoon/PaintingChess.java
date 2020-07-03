import java.io.*;

public class PaintingChess {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        
        char[][] chess = new char[8][];
        for(int i = 0; i < 8; i++){
        	chess[i] = new char[8];
            char first, second;
            if(i % 2 == 0){
                first = 'W';
                second = 'B';
            }
            else{
                first = 'B';
                second = 'W';
            }
            for(int j = 0; j < 8; j++){
                // 기준 체스판 초기화
                chess[i][j] = j % 2 == 0 ? first : second;
            }
        }
        
        // 보드 초기화
        char[][] board = new char[n][];
        for(int i = 0; i < n; i++){
            board[i] = new char[m];
            String line = br.readLine();
            
            for(int j = 0; j < m; j++){
                board[i][j] = line.charAt(j);
            }
        }
        
        int min = 100000000;
        for(int t = 0; t < 2; t++){
            for(int i = 0; i < n - 7; i++){
                for(int j = 0; j < m - 7; j++){
                	// 카운트는 칠해야할 칸의 수
                    int count = 0;
                    for(int k = 0; k < 8; k++){
                        for(int l = 0; l < 8; l++){
                            // 체스판과 다른 것만 카운트
                            if(t == 0){
                                if(board[i + k][j + l] != chess[k][l])
                                    count++;
                            }
                            // 체스판과 같은 것만 카운트
                            else{
                                if(board[i + k][j + l] == chess[k][l])
                                    count++;
                            }
                        }
                    }
                    if(min > count)
                        min = count;
                }
            }
        }
        System.out.println(min);
    }
}
