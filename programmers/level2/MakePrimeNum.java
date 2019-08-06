package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class MakePrimeNum {
	
	public static int solution(int[] nums) {
		Arrays.sort(nums);
		LinkedList<Integer> combinationSum = new LinkedList<>();
		
		// 조합의 합의 값을 리스트에 추가
		for(int i = 0; i < nums.length; i++) {
			int first = nums[i];
			for(int j = i + 1; j < nums.length; j++) {
				int second = nums[j];
				for(int k = j + 1; k < nums.length; k++) {
					combinationSum.add(first + second + nums[k]);
				}
			}
		}
		Collections.sort(combinationSum);
		Iterator<Integer> itr = combinationSum.iterator();
		
		ArrayList<Integer> primeList = new ArrayList<>();
		int max = 0;
		
		// 3가지 수의 조합으로 만들 수 있는 가장 큰 수
		for(int i = nums.length - 1; i >= nums.length - 3; i--) {
			max += nums[i];
		}
		
		// 가장 큰 수 이전까지의 모든 소수들
		primeList.add(2);
		for(int i = 3; i <= max; i++) {
			for(int j = 0; j < primeList.size(); j++) {
				// 소수가 아님
				if(i % primeList.get(j) == 0)
					break;
				// 소수
				if(j == primeList.size() - 1)
					primeList.add(i);
			}
		}
		
		int index = 0;
		int count = 0;
		int primeSize = primeList.size() - 1;
		while(itr.hasNext()) {
			int com = itr.next();
			// 조합된 수가 소수라면
			if(com == primeList.get(index))
				count++;
			// 조합된 수가 더 큼
			else if(com > primeList.get(index)) {
				// 소수 리스트의 인덱스를 증가
				while(com > primeList.get(index)) {
					if(index < primeSize)
						index++;
					else
						break;
				}
				// 조합된 수가 소수가 맞다면 count를 증가하고 소수가 아니라면 다음으로 넘어감
				if(com == primeList.get(index))
					count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 7, 6, 4};
		System.out.println("answer: " + solution(nums));
	}

}
