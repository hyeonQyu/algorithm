package kakao;

public class ColoringBook {
	int[] rows = {0, 0, 1, -1};
    int[] cols = {1, -1, 0, 0};
    
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] isVisit = new boolean[m][n];
        int max = 0;
        int area = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 0 || isVisit[i][j])
                    continue;
                
                isVisit[i][j] = true;
                int count = dfs(picture, isVisit, i, j);
                max = Math.max(max, count);
                area++;
            }
        }
        
        int[] answer = {area, max};
        return answer;
    }
    
    int dfs(int[][] picture, boolean[][] isVisit, int y, int x){
        int color = picture[y][x];
        int count = 1;
        
        for(int i = 0; i < 4; i++){
            int r = y + rows[i];
            int c = x + cols[i];
            
            try{
                if(picture[r][c] != color || isVisit[r][c])
                    continue;
                
                isVisit[r][c] = true;
                count += dfs(picture, isVisit, r, c);
            } catch(Exception e){}
        }
        
        return count;
    }
}
