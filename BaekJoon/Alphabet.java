import java.io.*;

public class Alphabet{
	static int max = 0;
    static char[][] board;
    static boolean[] isVisit = new boolean[26];
    static int[] rowArr = {0, 0, 1, -1};
    static int[] colArr = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int r = Integer.parseInt(arr[0]);
        int c = Integer.parseInt(arr[1]);
        board = new char[r][];
        for(int i = 0; i < r; i++){
            board[i] = new char[c];
            String s = br.readLine();
            for(int j = 0; j < c; j++)
                board[i][j] = s.charAt(j);
        }
        
        isVisit[board[0][0] - 'A'] = true;
        int count = 1;
        dfs(0, 0, count);
        System.out.println(max);
    }
    
    private static void dfs(int i, int j, int count){
    	// count는 깊이
    	max = max < count ? count : max;
    	
    	// 상하좌우 탐색
        for(int k = 0; k < 4; k++){
            int r = rowArr[k];
            int c = colArr[k];
            try {
            	char ch = board[i + r][j + c];
            	// 이전에 방문한 알파벳과 같다면 방문하지 않음
            	if(isVisit[ch - 'A'])
            		continue;
            	isVisit[ch - 'A'] = true;
            	dfs(i + r, j + c, count + 1);
            	// 백트래킹 이후 다음 탐색을 위해 방문하지 않았다고 표시
            	isVisit[ch - 'A'] = false;
            } catch (Exception e) {}
        }
    }
}