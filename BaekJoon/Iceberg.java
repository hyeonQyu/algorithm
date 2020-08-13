import java.io.*;
import java.util.*;

public class Iceberg {
    static int[][] map;
    static int[][] info;
    static int[] row = {0, 0, 1, -1};
    static int[] col = {1, -1, 0, 0};
    static boolean[][] isVist;

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][];
        info = new int[n][];
        int count = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            map[i] = new int[m];
            info[i] = new int[m];
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < m - 1; j++){
                if(map[i][j] == 0)
                    continue;
                
                // 빙산 부분이면 인접한 바다 면 개수 확인
                int tmp = 0;
                for(int k = 0; k < 4; k++){
                    if(map[i + row[k]][j + col[k]] == 0)
                        tmp++;
                }
                info[i][j] = tmp;
                
                count++;
            }
        }
        
        int year = 0;
        boolean isFirst = true;
        LinkedList<int[]> list;
        while(count > 0){    
            isFirst = true;
            list = new LinkedList<>();
            isVist = new boolean[n][m];
            for(int i = 1; i < n - 1; i++){
                for(int j = 1; j < m - 1; j++){
                    if(map[i][j] == 0)
                        continue;

                    if(isFirst){
                        isFirst = false;
                        // 빙산이 분리됨
                        if(count != dfs(i, j)){
                            System.out.println(year);
                            return;
                        }
                    }
                    
                    int tmp = map[i][j] - info[i][j];
                    // 빙산이 완전히 녹음
                    if(tmp <= 0){
                        count--;
                        map[i][j] = 0;
                        int[] tmpArr = {i, j};
                        list.add(tmpArr);
                        continue;
                    }
                    map[i][j] = tmp;
                    
                }
            }
            
            // 다 녹은 빙산 영역 주위의 인접 바다 면 개수 수정
            Iterator<int[]> itr = list.iterator();
            while(itr.hasNext()){
                int[] tmpArr = itr.next();
                int i = tmpArr[0];
                int j = tmpArr[1];
                
                for(int k = 0; k < 4; k++)
                    info[i + row[k]][j + col[k]]++;
            }
            year++;
        }
        System.out.println(0);
    }
    
    static int dfs(int i, int j){
        if(isVist[i][j] || map[i][j] == 0)
            return 0;
        isVist[i][j] = true;

        int tmp = 1;
        for(int k = 0; k < 4; k++)
            tmp += dfs(i + row[k], j + col[k]);
        return tmp;
    }
}