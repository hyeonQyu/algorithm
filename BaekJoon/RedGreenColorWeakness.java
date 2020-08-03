import java.io.*;

public class RedGreenColorWeakness {
	static int[] rowArr = {0, 0, 1, -1};
    static int[] colArr = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][][] map = new char[2][][];
        boolean[][][] isVisit = new boolean[2][][];
        for(int i = 0; i < 2; i++) {
        	map[i] = new char[n][];
        	isVisit[i] = new boolean[n][];
        }
        for(int i = 0; i < n; i++){    		
    		String arr = br.readLine();
    		
    		for(int k = 0; k < 2; k++) {
        		map[k][i] = new char[n];
        		isVisit[k][i] = new boolean[n];
    		}
    		for(int j = 0; j < n; j++){
    			map[0][i][j] = arr.charAt(j);
    			map[1][i][j] = (map[0][i][j] == 'R' ? 'G' : map[0][i][j]);
    		}
        		
    	}     
        
        int[] count = new int[2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
            	for(int k = 0; k < 2; k++) {
            		if(!isVisit[k][i][j]) {
            			count[k]++;
            			dfs(i, j, map[k], isVisit[k]);
            		}
            	}
            }
        }
        
        System.out.println(count[0] + " " + count[1]);
    }
    
    private static void dfs(int i, int j, char[][] map, boolean[][] isVisit){
        isVisit[i][j] = true;
        for(int k = 0; k < 4; k++){
            int r = i + rowArr[k];
            int c = j + colArr[k];
            
            try{
                if(map[i][j] == map[r][c] && !isVisit[r][c])
                    dfs(r, c, map, isVisit);
            } catch(Exception e){}
        }
    }
}
