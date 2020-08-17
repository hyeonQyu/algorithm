import java.io.*;
import java.util.*;

public class Laboratory{
    static int n, m, max;
    static int[][] lab;
    static LinkedList<int[]> q = new LinkedList<>();
    static int[] row = {0, 0, 1, -1};
    static int[] col = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lab = new int[n][];
        
        for(int i = 0; i < n; i++){
            lab[i] = new int[m];           
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());
                if(lab[i][j] == 2){
                    int[] tmp = {i, j};
                    q.add(tmp);
                }
            }
        }
        
        selectWall(0, 0, 0);
        System.out.println(max);
    }
    
    // 벽을 세움
    static void selectWall(int r, int c, int wall){
        if(wall == 3){
            LinkedList<int[]> q2 = (LinkedList<int[]>) q.clone();
            int[][] lab2 = cloneLab();
            bfs(q2, lab2);
            max = Math.max(max, findSafety(lab2));
            return;
        }
        
        for(int i = r; i < n; i++){
            for(int j = i == r ? c : 0; j < m; j++){
                if(lab[i][j] == 0){
                    lab[i][j] = 1;
                    selectWall(i, j, wall + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }
    
    static int[][] cloneLab(){
        int[][] lab2 = new int[n][];
        for(int i = 0; i < n; i++){
            lab2[i] = new int[m];
            for(int j = 0; j < m; j++)
                lab2[i][j] = lab[i][j];
        }
        return lab2;
    }
    
    static void bfs(LinkedList<int[]> q2, int[][] lab2){
        while(!q2.isEmpty()){
            int[] cur = q2.poll();
                
            for(int k = 0; k < 4; k++){
                int i = cur[0] + row[k];
                int j = cur[1] + col[k];
                    
                try{
                    if(lab2[i][j] > 0)
                        continue;
                    // 전염
                    lab2[i][j] = 2;
                    int[] next = {i, j};
                    q2.add(next);
                } catch(Exception e){}
            }
        }
    }
    
    static int findSafety(int[][] lab2){
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(lab2[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
}