package level2;

import java.util.LinkedList;

public class ExpressNum {
	
	public static int solution(int n) {
		LinkedList<Integer> list = new LinkedList<>();
		int sum = 0;
		int count = 0;
		
		for(int i = 1; i <= n; i++) {
			sum += i;
			list.add(i);
			
			// n을 만듦
			if(sum == n) {
				count++;
				
				// 리스트를 알맞게 조작
				sum = getSumByHandleList(list, sum, i);
			}
			// n보다 커짐
			else if(sum > n) {
				while(sum > n) {
					sum -= list.pop();
				}
				if(sum == n) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	static int getSumByHandleList(LinkedList<Integer> list, int sum, int i) {
		int next = i + 1;
		int tmp = 0;
		
		while(tmp < next) {
			tmp += list.pop();
		}
		sum -= tmp;

		// 앞의 숫자를 더한 것이 다음 숫자보다 크다면 리스트를 비움
		if(tmp > next) {
			list.clear();
			sum = 0;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(5));;
	}

}
