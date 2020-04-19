package search;

import java.io.*;

public class OrganicCabbage {
	
	private static int label;
	private static int[][] ground;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
        int[] answers = new int[t];
        
        for(int test = 0; test < t; test++){
        	label = 2;
        	
        	String[] arr = br.readLine().split(" ");
            int m = Integer.parseInt(arr[0]);
            int n = Integer.parseInt(arr[1]);
            int k = Integer.parseInt(arr[2]);
            
            ground = new int[n][m];
            
            for(int i = 0; i < k; i++){
                String[] arr2 = br.readLine().split(" ");
                int x = Integer.parseInt(arr2[0]);
                int y = Integer.parseInt(arr2[1]);
                
                ground[y][x] = 1;
            }
            
            for(int i = 0; i < n; i++) {
            	for(int j = 0; j < m; j++) {
            		if(ground[i][j] == 1) {
            			dfs(i, j);
            			label++;
            		}
            	}
            }
            
            answers[test] = label - 2;
        }
        
        for(int i = 0; i < t; i++){
            System.out.println(answers[i]);
        }
    }
	
	private static void dfs(int i, int j) {
		ground[i][j] = label;
		
		// 우
		try {
			if(ground[i][j + 1] == 1)
				dfs(i, j + 1);
		} catch(Exception e) {}
		// 좌
		try {
			if(ground[i][j - 1] == 1)
				dfs(i, j - 1);
		} catch(Exception e) {}
		// 상
		try {
			if(ground[i - 1][j] == 1)
				dfs(i - 1, j);
		} catch(Exception e) {}
		// 하
		try {
			if(ground[i + 1][j] == 1)
				dfs(i + 1, j);
		} catch(Exception e) {}
	}
	
}
