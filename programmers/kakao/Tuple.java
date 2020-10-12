package kakao;

import java.util.*;

public class Tuple {

	public static void main(String[] args) {
		new Tuple().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
	}
	
	 public int[] solution(String s) {
		 s = s.substring(2, s.length() - 2);
	        String[] arr = s.split("\\}\\,\\{");
	        // 길이순으로 정렬
	        Arrays.sort(arr, new Comparator<String>(){
	            public int compare(String a, String b){
	                return Integer.compare(a.length(), b.length());
	            }
	        });
	        
	        int length = arr.length;
	        String[][] tuples = new String[length][];
	        int[] answer = new int[length];
	        boolean[] check = new boolean[100001];
	        for(int i = 0; i < length; i++){
	            tuples[i] = arr[i].split(",");
	            int tLength = tuples[i].length;
	            
	            HashSet<Integer> set = new HashSet<>();
	            for(int j = 0; j < tLength; j++){
	                int num = Integer.parseInt(tuples[i][j]);
	                if(!check[num]){
	                    answer[i] = num;
	                    check[num] = true;
	                    break;
	                }
	                else{
	                    if(set.contains(num)){
	                        answer[i] = num;
	                        break;
	                    }
	                    set.add(num);
	                }
	            }
	        }
	        
	        return answer;
	    }
}
