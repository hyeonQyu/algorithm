import java.io.*;
import java.util.*;

public class Tomato {
	
	static byte[][] box;
    static int ripe = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = s.split(" ");
        int width, height;
        width = Integer.parseInt(arr[0]);
        height = Integer.parseInt(arr[1]);
        
        int empty = 0;
        int total = width * height;
        box = new byte[height][width];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < height; i++){
            s = br.readLine();
            arr = s.split(" ");
            for(int j = 0; j < width; j++){
                box[i][j] = Byte.parseByte(arr[j]);
                if(box[i][j] == -1)
                    empty++;
                else if(box[i][j] == 1){
                    ripe++;
                    
                    int[] coord = new int[2];
                    coord[0] = i;
                    coord[1] = j;
                    q.add(coord);
                }
            }
        }
        total -= empty;
        
        int day = 0;
        while(ripe < total) {
        	// 더 이상 익을 수 있는 토마토가 없으면 종료
        	if(q.isEmpty())
        		break;
        	
        	Queue<int[]> tmpQ = new LinkedList<>();
        	
        	while(!q.isEmpty()) {
        		tmpQ.add(q.poll());
        	}
        	
        	// 하루동안 전이
        	while(!tmpQ.isEmpty()) {
        		int[] coord = tmpQ.poll();
        		
        		for(int i = 0; i < 4; i++) {
        			int[] adj = new int[2];
        			
        			try{
        				if(isNotRipe(coord, i, adj)){
        					q.add(adj);
        				}
        			} catch(Exception e){}        			
        		}
        	}
        	
        	day++;
        }
        
        if(ripe < total){
            System.out.println(-1);
            return;
        }
        System.out.println(day);
    }
    
    // 현재 좌표에 익지 않은(0) 토마토가 있으면 true
    static boolean isNotRipe(int[] coord, int vector, int[] adj) throws Exception{
        int i = coord[0];
        int j = coord[1];
        // 우, 좌, 상, 하
        switch(vector){
            case 0:
                j++;
                break;
            case 1:
                j--;
                break;
            case 2:
                i--;
                break;
            case 3:
                i++;
                break;
        }
        
        if(box[i][j] == 0){
            adj[0] = i;
            adj[1] = j;
            
            // 익음
            box[i][j] = 1;
            ripe++;
            
            return true;
        }
        return false;
    }

}
