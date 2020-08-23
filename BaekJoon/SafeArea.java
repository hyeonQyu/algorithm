import java.io.*;
import java.util.*;

public class SafeArea{
    static int n;
    static int[][] area;
    static int min = 101;
    static int max = 0;
    static boolean[][] isOk;
    static boolean[][] isVisit;
    static int[] row = {0, 0, 1, -1};
    static int[] col = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        area = new int[n][];
        for(int i = 0; i < n; i++){
            area[i] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, area[i][j]);
                max = Math.max(max, area[i][j]);
            }
        }
        
        int areaMax = 0;
        for(int t = min - 1; t <= max; t++) {
            areaMax = Math.max(areaMax, getArea(t));
        }
        System.out.println(areaMax);
    }
    
    static int getArea(int rain){
        isOk = new boolean[n][];
        isVisit = new boolean[n][];
        for(int i = 0; i < n; i++){
            isOk[i] = new boolean[n];
            isVisit[i] = new boolean[n];
            for(int j = 0; j < n; j++){
                isOk[i][j] = rain < area[i][j] ? true : false;
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isOk[i][j] && !isVisit[i][j]){
                    isVisit[i][j] = true;
                    dfs(i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    static void dfs(int r, int c){
        for(int k = 0; k < 4; k++){
            int i = r + row[k];
            int j = c + col[k];
            
            try{
                if(isOk[i][j] && !isVisit[i][j]){
                    isVisit[i][j] = true;
                    dfs(i, j);
                }
            } catch(Exception e){}
        }
    }
}