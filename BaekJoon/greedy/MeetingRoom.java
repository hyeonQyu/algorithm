package greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] meeting = new int[n][2];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            String[] arr = s.split(" ");
            meeting[i][0] = Integer.parseInt(arr[0]);
            meeting[i][1] = Integer.parseInt(arr[1]);
        }
        // 회의 시작 순서대로, 회의 시작 순서가 같다면 끝나는 시간 오름차순
        Arrays.sort(meeting, new Comparator<int[]>(){
           @Override 
            public int compare(int[] o1, int[] o2){
                int c = Integer.compare(o1[0], o2[0]);
                if(c == 0){
                    return Integer.compare(o1[1], o2[1]);
                }
                return c;
            }
        });
        
        int count = 1;
        int[] cur = new int[2];
        cur[0] = meeting[0][0];
        cur[1] = meeting[0][1];
        for(int i = 1; i < n; i++){
            // 회의 시간이 겹치는 경우
            if(cur[1] > meeting[i][0]){
                // 더 빨리 끝나는 회의가 있는 경우 현재 회의 교체
                if(cur[1] > meeting[i][1]){
                    cur[0] = meeting[i][0];
                    cur[1] = meeting[i][1];
                }
            }
            // 다음 회의를 시작할 수 있음
            else{
                cur[0] = meeting[i][0];
                cur[1] = meeting[i][1];
                count++;
            }
        }
        
        System.out.print(count);
	}

}
