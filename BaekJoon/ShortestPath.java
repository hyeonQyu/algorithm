import java.io.*;
import java.util.*;

class Adj implements Comparable<Adj>{
    int index;
    int distance;
    
    public Adj(int index, int distance){
        this.index = index;
        this.distance = distance;
    }
    
    // 거리의 오름차순
    @Override
    public int compareTo(Adj adj){
        return Integer.compare(distance, adj.distance);
    }
}

public class ShortestPath {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int vertex = Integer.parseInt(arr[0]);
        int edge = Integer.parseInt(arr[1]);
        int k = Integer.parseInt(br.readLine());
        
        int[] distances = new int[vertex];
        for(int i = 0; i < vertex; i++)
            distances[i] = 100000000;
        distances[k - 1] = 0;
        LinkedList<Adj>[] lists = new LinkedList[vertex];
        PriorityQueue<Adj> pq = new PriorityQueue<>();
        
        for(int i = 0; i < edge; i++){
            arr = br.readLine().split(" ");
            int u = Integer.parseInt(arr[0]);
            int v = Integer.parseInt(arr[1]);
            int w = Integer.parseInt(arr[2]);
            
            // u가 시작점이라면 우선순위큐에 집어넣음
            if(u == k){
                if(distances[v - 1] > w){
                    distances[v - 1] = w;
                    pq.add(new Adj(v - 1, w));
                }
            }
            else{
               if(lists[u - 1] == null)
                    lists[u - 1] = new LinkedList<>();
                lists[u - 1].add(new Adj(v - 1, w));
            }  
        }
        
        int check = 1;
        boolean[] isVisit = new boolean[vertex];
        isVisit[k - 1] = true;
        while(check < vertex){
        	if(pq.isEmpty())
        		break;
        	
            int next = pq.poll().index;
            if(!isVisit[next]){
                isVisit[next] = true;   
                check++;
            } else{
                continue;
            }
            
            if(lists[next] == null)
            	continue;
            while(!lists[next].isEmpty()){
                Adj tmp = lists[next].remove();
                int index = tmp.index;
                int distance = distances[next] + tmp.distance;
                
                // distances 배열 갱신
                if(distances[index] > distance){
                    distances[index] = distance;
                    pq.add(new Adj(index, distance));
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < vertex; i++){
            if(distances[i] == 100000000)
                sb.append("INF\n");
            else
                sb.append(distances[i] + "\n");
        }
        System.out.print(sb);
	}
}
