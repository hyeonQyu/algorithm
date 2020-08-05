import java.io.*;

public class OperatorInserting{
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    static int[] operators;
    static long[] nums;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new long[n];
        String[] arr = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            nums[i] = Long.parseLong(arr[i]);
        operators = new int[4];
        arr = br.readLine().split(" ");
        for(int i = 0; i < 4; i++)
            operators[i] = Integer.parseInt(arr[i]);
        
        for(int i = 0; i < 4; i++){
            if(operators[i] == 0)
                continue;
            
            int nIndex = 0;
            // result에 가장 첫번째 수 대입
            long result = nums[nIndex];
            // i번째 연산자를 사용
            operators[i]--;
            dfs(result, nIndex + 1, i);
            // i번째 연산자를 사용하지 않은 것으로 돌려놓음
            operators[i]++;
        }
        System.out.println(max + "\n" + min);
    }
    
    private static void dfs(long result, int nIndex, int oIndex){
        switch(oIndex){
            case 0:
                result += nums[nIndex];
                break;
            case 1:
                result -= nums[nIndex];
                break;
            case 2:
                result *= nums[nIndex];
                break;
            case 3:
                result /= nums[nIndex];
                break;
        }
        
        // 연산 완료
        if(nIndex == n - 1){
            if(max < result)
                max = result;
            if(min > result)
                min = result;
            return;
        }
        
        for(int i = 0; i < 4; i++){
            if(operators[i] == 0)
                continue;
            
            operators[i]--;
            dfs(result, nIndex + 1, i);
            operators[i]++;
        }
    }
}