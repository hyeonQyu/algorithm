import java.io.*;

public class StartAndLink{
    static int n;
    static int team;
    static boolean[] isPick;
    static int[][] stat;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stat = new int[n][];
        for(int i = 0; i < n; i++){
            String[] arr = br.readLine().split(" ");
            
            stat[i] = new int[n];
            for(int j = 0; j < n; j++)
                stat[i][j] = Integer.parseInt(arr[j]);
        }
        isPick = new boolean[n];
        
        team = n / 2;
        isPick[0] = true;
        for(int i = 1; i < n; i++){
            isPick[i] = true;
            dfs(0, i, 2);
            isPick[i] = false;
        }
        
        System.out.println(min);
    }
    
    static void dfs(int mem1, int mem2, int picked){
        // 팀 완성
        if(picked == team){
            int team1 = 0;
            int team2 = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(isPick[i] && isPick[j])
                        team1 += stat[i][j];
                    else if(!isPick[i] && !isPick[j])
                        team2 += stat[i][j];
                }
            }
            
            int sub = Math.abs(team1 - team2);
            min = min > sub ? sub : min;
            return;
        }
        
        // 조합은 순서가 바뀌어도 같기 때문에 현재 번호의 다음 번호부터 뽑음
        for(int i = mem2 + 1; i < n; i++){
            if(isPick[i])
                continue;
            isPick[i] = true;
            dfs(mem2, i, picked + 1);
            isPick[i] = false;
        }
    }
}