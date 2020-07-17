import java.io.*;
import java.util.*;

public class Lotto {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = br.readLine();
            if(s.equals("0"))
                break;
            
            String[] arr = s.split(" ");
            int length = arr.length;
            int[] nums = new int[length];
            int[] child = new int[length];
            // 현재 로또 숫자에 따른 인덱스를 저장하는 맵
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 1; i < length; i++){
                nums[i] = Integer.parseInt(arr[i]);
                child[i] = length - 1 - i;
                map.put(nums[i], i);
            }
            
            for(int i = 1; i < length; i++){
                // 6자리 숫자를 만들 수 없음
                if(1 + child[i] < 6)
                    break;
                
                int[] set = new int[6];
                
                Stack<Integer> stack = new Stack<>();
                Stack<Integer> stack2 = new Stack<>();
                stack.push(nums[i]);
                stack2.push(1);
                while(!stack.isEmpty()){
                    int num = stack.pop();
                    int level = stack2.pop();
                    
                    set[level - 1] = num;
                    // 6자리 숫자가 모두 모이면 출력
                    if(level == 6){
                        for(int j = 0; j < 6; j++){
                            System.out.print(set[j] + " ");
                        }
                        System.out.println();
                        continue;
                    }
                    
                    int index = map.get(num);
                    for(int j = length - 1; j > index; j--){
                        // 유망한 조건
                        if(child[j] + level + 1 >= 6){
                            stack.push(nums[j]);
                            stack2.push(level + 1);
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
