package level2;

public class StockPrice {
	
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		for(int i = 0; i < prices.length - 1; i++) {
			for(int j = i + 1; j < prices.length; j++) {
				answer[i]++;
				if(prices[i] > prices[j]) {
					// 가격이 떨어진 순간
					break;
				}
			}
		}
		
		return answer;
	}

}
