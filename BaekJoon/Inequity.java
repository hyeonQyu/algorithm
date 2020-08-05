import java.io.*;

public class Inequity {
	static int k;
    static String[] arr;
    static boolean[] isCheck;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");
        isCheck = new boolean[10];
        StringBuilder sb = new StringBuilder();
        // 최대 찾기
        for(int i = 9; i >= 0; i--){
            isCheck[i] = true;
            sb.append(i);
            if(dfs(i, 0, sb, true))
                break;
            sb.deleteCharAt(sb.length() - 1);
            isCheck[i] = false;
        }
        sb = new StringBuilder();
        isCheck = new boolean[10];
        // 최소 찾기
        for(int i = 0; i < 10; i++){
            isCheck[i] = true;
            sb.append(i);
            if(dfs(i, 0, sb, false))
                break;
            sb.deleteCharAt(sb.length() - 1);
            isCheck[i] = false;
        }
    }
    
    static boolean dfs(int n, int index, StringBuilder sb, boolean isMax){       
        // 탐색 종료
        if(index == k){
            System.out.println(sb);
            return true;
        }
        
        // 최대
        if(isMax){
            if(arr[index].equals("<")){
                int end = n + 1;
                if(end == 10)
                    return false;
                for(int i = 9; i >= end; i--){
                    if(isCheck[i])
                        continue;
                    isCheck[i] = true;
                    sb.append(i);
                    if(dfs(i, index + 1, sb, isMax))
                    	return true;
                    sb.deleteCharAt(sb.length() - 1);
                    isCheck[i] = false;
                }
            } else{
                int start = n - 1;
                if(start == -1)
                    return false;
                for(int i = start; i >= 0; i--){
                    if(isCheck[i])
                        continue;
                    isCheck[i] = true;
                    sb.append(i);
                    if(dfs(i, index + 1, sb, isMax))
                    	return true;
                    sb.deleteCharAt(sb.length() - 1);
                    isCheck[i] = false;
                }
            }
        }
        // 최소
        else{
            if(arr[index].equals("<")){
                int start = n + 1;
                if(start == 10)
                    return false;
                for(int i = start; i < 10; i++){
                	if(isCheck[i])
                        continue;
                	isCheck[i] = true;
                    sb.append(i);
                    if(dfs(i, index + 1, sb, isMax))
                    	return true;
                    sb.deleteCharAt(sb.length() - 1);
                    isCheck[i] = false;
                }
            } else{
                int end = n - 1;
                if(end == -1)
                    return false;
                for(int i = 0; i <= end; i++){
                	if(isCheck[i])
                        continue;
                    sb.append(i);
                    isCheck[i] = true;
                    if(dfs(i, index + 1, sb, isMax)) 
                    	return true;
                    sb.deleteCharAt(sb.length() - 1);
                    isCheck[i] = false;
                }
            }
        }
        
        return false;
    }
}
