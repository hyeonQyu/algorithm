package level3;

public class Budget {

	public int solution(int[] budgets, int M) {
		if(budgets.length == M)
			return 1;
		long total = 0;
		int max = 0;
		int min = 100000;
		int limit;
		for(int i = 0; i < budgets.length; i++) {
			total += budgets[i];
			if(max < budgets[i])
				max = budgets[i];
			if(min > budgets[i])
				min = budgets[i];
		}
		
		// 처음에 모든 요청이 배정될 수 있는 경우
		if(total <= M)
			return max;
		// 처음에 모든 요청이 배정될 수 없는 경우
		else {
			if(min >= M / budgets.length)
				return M / budgets.length;
			
			long lack = 1000000000;
			// 초기 limit 값
			limit = (max + min) / 2;
			while(true) {
				total = 0;
				for(int i = 0; i < budgets.length; i++) {
					if(budgets[i] > limit)
						total += limit;
					else
						total += budgets[i];
				}
				
				// 예산안 초과
				if(total > M) {
					max = limit;
					// limit 값 감소
					limit = (limit + min) / 2;
				}
				// 예산안 미만
				else if(total < M) {
					// 모든 요청의 합이 최대 예산안에 가장 근접하다면
					if(M - total < lack) {
						lack = (long)M - total;
						min = limit;
						// limit 값 증가
						limit = (limit + max) / 2;
					}
					else if(M - total == lack)
						break;
				}
				// 예산안과 일치
				else
					break;
			}
		}
		
		return limit;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] budgets = {9, 8, 10, 11, 6};
		new Budget().solution(budgets, 6);
	}

}
