import java.io.*;
import java.util.*;

class RB{
    int[] r;
    int[] b;
    int time;
    
    public RB(int[] r, int[] b, int time){
        this.r = r;
        this.b = b;
        this.time = time;
    }
}

public class MarbleEscape{
    static int n, m;
    static char[][] board;
    static int[] rowArr = {0, 0, 1, -1};
    static int[] colArr = {1, -1, 0, 0};
    static boolean[][][][] isVisit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        
        board = new char[n][];
        isVisit = new boolean[n][][][];
        for(int i = 0; i < n; i++) {
        	isVisit[i] = new boolean[m][][];
        	for(int j = 0; j < m; j++) {
        		isVisit[i][j] = new boolean[n][];
        		for(int k = 0; k < n; k++) {
        			isVisit[i][j][k] = new boolean[m];
        		}
        	}
        }
        int[] b = new int[2];
        int[] r = new int[2];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            board[i] = new char[m];
            for(int j = 0; j < m; j++){
                board[i][j] = s.charAt(j);
                if(board[i][j] == 'B'){
                    b[0] = i;
                    b[1] = j;
                } else if(board[i][j] == 'R'){
                    r[0] = i;
                    r[1] = j;
                }
            }
        }
        
        Queue<RB> q = new LinkedList<>();
        q.add(new RB(r, b, 1));
        isVisit[r[0]][r[1]][b[0]][b[1]] = true;
        while(!q.isEmpty()){
            RB cur = q.poll();
            
            if(cur.time == 11)
                break;
                
            int[] cr = cur.r;
            int[] cb = cur.b;
            for(int i = 0; i < 4; i++){
                // 상하좌우로 구슬을 움직임
                int[] tr = move(cr, i);
                int[] tb = move(cb, i);
                
                // 파란 구슬이 구멍에 빠지면 무시
                if(board[tb[0]][tb[1]] == 'O')
                    continue;
                // 빨간 구슬이 구멍에 빠짐
                else if(board[tr[0]][tr[1]] == 'O'){
                    System.out.println(cur.time);
                    return;
                }
                // 구슬이 겹침
                else if(tr[0] == tb[0] && tr[1] == tb[1]){
                    switch(i){
                        // 우
                        case 0:
                            if(cr[1] > cb[1])
                            	tb[1]--;
                            else
                            	tr[1]--;
                            break;
                        // 좌
                        case 1:
                            if(cr[1] < cb[1])
                            	tb[1]++;
                            else
                            	tr[1]++;
                            break;
                        // 상    
                        case 2:
                            if(cr[0] > cb[0])
                            	tb[0]--;
                            else
                            	tr[0]--;
                            break;
                        // 하
                        case 3:
                            if(cr[0] < cb[0])
                            	tb[0]++;
                            else
                            	tr[0]++;
                            break;
                    }
                }
                
                // 두 구슬이 동시에 새로 방문하는 지점이라면
                if(!isVisit[tr[0]][tr[1]][tb[0]][tb[1]]){
                    isVisit[tr[0]][tr[1]][tb[0]][tb[1]] = true;
                    q.add(new RB(tr, tb, cur.time + 1));
                }
            }
        }
        System.out.println(-1);
    }
    
    private static int[] move(int[] coord, int vector){
        int i = coord[0];
        int j = coord[1];
        while(true){
            i += rowArr[vector];
            j += colArr[vector];
            
            if(board[i][j] == '#'){
                i -= rowArr[vector];
                j -= colArr[vector];
                break;
            }
            else if(board[i][j] == 'O'){
                break;
            }
        }
        
        int[] arr = {i, j};
        return arr;
    }
}