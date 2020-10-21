package level2;

import java.util.*;

public class FindingPrimeNum {
	static int answer = 0;
    static int[] nums;
    static boolean[] isVisit;
    static int length;
    static boolean[] isNotPrime;
    static boolean[] isPrimeCheck;
    
    public int solution(String numbers) {
        length = numbers.length();
        nums = new int[length];
        isVisit = new boolean[length];
        for(int i = 0; i < length; i++)
            nums[i] = numbers.charAt(i) - '0';
        Arrays.sort(nums);
        int ten = 10;
        int max = nums[0];
        for(int i = 1; i < length; i++){
            max += (nums[i] * ten);
            ten *= 10;
        }
        
        isNotPrime = new boolean[max + 1];
        isPrimeCheck = new boolean[max + 1];
        isNotPrime[0] = true;
        try{
            isNotPrime[1] = true;    
        } catch(Exception e){}
        
        for(int i = 2; i * i <= max; i++){
            if(isNotPrime[i])
                continue;
            for(int j = i + i; j <= max; j += i){
                isNotPrime[j] = true;
            }
        }
        
        for(int i = 0; i < length; i++){
            isVisit[i] = true;
            dfs(nums[i]);
            isVisit[i] = false;
        }
        
        return answer;
    }
    
    static void dfs(int n){
        if(!isNotPrime[n] && !isPrimeCheck[n]){
            answer++;
            isPrimeCheck[n] = true;
        }
        for(int i = 0; i < length; i++){
            if(!isVisit[i]){
                isVisit[i] = true;
                dfs(n * 10 + nums[i]);
                isVisit[i] = false;
            }
        }
    }
}
