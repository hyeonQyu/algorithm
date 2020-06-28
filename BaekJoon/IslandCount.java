import java.io.*;

public class IslandCount {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            String[] arr = br.readLine().split(" ");
            int w = Integer.parseInt(arr[0]);
            int h = Integer.parseInt(arr[1]);
            
            if(w == 0 && h == 0)
                break;
            
            int[][] map = new int[h + 2][];
            int[][] labelMap = new int[h + 2][];
            for(int i = 0; i < h + 2; i++){
                map[i] = new int[w + 2];
                labelMap[i] = new int[w + 2];
                if(i == 0 || i == h + 1)
                    continue;
                
                String[] line = br.readLine().split(" ");
                for(int j = 1; j < w + 1; j++){
                    map[i][j] = Integer.parseInt(line[j - 1]);
                }
            }
            
            int label = 1;
            for(int i = 1; i < h + 1; i++){
                for(int j = 1; j < w + 1; j++){
                    if(map[i][j] == 0 || labelMap[i][j] != 0)
                        continue;
                    
                    labeling(label, map, labelMap, i, j);
                    label++;
                }
            }
            System.out.println(--label);
        }
    }
    
    private static void labeling(int label, int[][] map, int[][] labelMap, int i, int j){
        if(labelMap[i][j] != 0)
            return;
        labelMap[i][j] = label;
        
        int[] dir = {-1, 0, 1};
        for(int k = 0; k < 3; k++){
            for(int l = 0; l < 3; l++){
                if(map[i + dir[k]][j + dir[l]] != 0)
                    labeling(label, map, labelMap, i + dir[k], j + dir[l]);
            }
        }
    }
}
