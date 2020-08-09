import java.io.*;
import java.util.*;

public class BinaryGraph {

	static int v, e;
    static char[] colors;
    static LinkedList<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            v = Integer.parseInt(st.nextToken());
            if(v == 1){
                System.out.println("NO");
                continue;
            }
            e = Integer.parseInt(st.nextToken());
            colors = new char[v + 1];
            list = new LinkedList[v + 1];
            for(int i = 1; i <= v; i++)
                list[i] = new LinkedList<Integer>();
            
            for(int i = 0; i < e; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            
            for(int i = 1; i <= v; i++){
                if(colors[i] == 0)
                    dfs(i, (char)1);
            }
            
            boolean isBinary = true;
            for(int i = 1; i <= v; i++){
                Iterator<Integer> itr = list[i].iterator();
                while(itr.hasNext()){
                    // 인접한 정점끼리 같은 색
                    if(colors[i] == colors[itr.next()]){
                        isBinary = false;
                        i = v;
                        break;
                    }
                }
            }
            if(isBinary)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    
    static void dfs(int index, char color){
        colors[index] = color;
        Iterator<Integer> itr = list[index].iterator();
        while(itr.hasNext()){
            int i = itr.next();
            // 아직 색칠되지 않았다면
            if(colors[i] == 0){
                dfs(i, (char)(3 - color));
            }
        }
    }

}
