package search;

import java.util.*;
import java.io.*;

public class ComplexNumbering {

	static int[][] map;
    static boolean[][] check;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        
        check = new boolean[n][n];
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int house = checkComplex(i, j);
                if(house > 0)
                    list.add(house);
            }
        }
        
        System.out.println(list.size());
        Collections.sort(list);
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
    
    private static int checkComplex(int i, int j){
        if(check[i][j] || map[i][j] == 0) 
        	return 0;
        check[i][j] = true;
        
        int l, r, u, d;
        l = r = u = d = 0;
                    
        try{
            l = checkComplex(i, j - 1);
        }catch(Exception e){}
        try{
            r = checkComplex(i, j + 1);
        }catch(Exception e){}
        try{
            u = checkComplex(i - 1, j);
        }catch(Exception e){}
        try{
            d = checkComplex(i + 1, j);
        }catch(Exception e){}
                    
        int count = l + r + u + d + 1;
        return count;
    }

}
