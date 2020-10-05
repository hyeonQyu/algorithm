import java.io.*;
import java.util.*;

public class Escape {
	static int r, c;
    static int[] rows = {0, 0, 1, -1};
    static int[] cols = {1, -1, 0, 0};
    static char[][] map;
    static Queue<int[]> waterQ = new LinkedList<>();
    static Queue<int[]> hedQ = new LinkedList<>();
    static boolean isOver = false;
    
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map = new char[r][];
        for(int i = 0; i < r; i++){
            map[i] = new char[c];
            
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = s.charAt(j);
                
                int[] tmp = {i, j, 0};
                if(map[i][j] == '*')
                    waterQ.add(tmp);
                else if(map[i][j] == 'S')
                    hedQ.add(tmp);
            }
        }
        
        while(!waterQ.isEmpty() || !hedQ.isEmpty()){
        	if(hedQ.isEmpty()) {
        		System.out.println("KAKTUS");
        		return;
        	}
        	
            bfs(waterQ, 'D', 'X', '*');
            bfs(hedQ, 'X', '*', 'S');

            if(isOver)
            	return;
        }
        
    }
    
    static void bfs(Queue<int[]> q, char disable1, char disable2, char self){
        if(q.isEmpty())
            return;

        int[][] curs = new int[q.size()][];
        int index = 0;
        while(!q.isEmpty())
        	curs[index++] = q.poll();
        
        for(int t = 0; t < curs.length; t++) {
        	for(int i = 0; i < 4; i++){
        		int row = curs[t][0] + rows[i];
        		int col = curs[t][1] + cols[i];
        		
        		try{
        			// 갈 수 없는 곳
        			if(map[row][col] != disable1 && map[row][col] != disable2){
        				// 자기자신엔 다시 갈 필요 없음
        				if(map[row][col] != self){
        					// 고슴도치가 목적지에 도착
        					if(self == 'S' && map[row][col] == 'D') {
        						System.out.println(curs[t][2] + 1);
        						isOver = true;
        						return;
        					}
        					
        					int[] tmp = {row, col, curs[t][2] + 1};
        					q.add(tmp);
        					map[row][col] = self;
        				}
        			}
        		} catch(Exception e){}
        	}
        }
    }
}
