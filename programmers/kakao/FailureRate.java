package kakao;

import java.util.Arrays;

class Rate implements Comparable<Rate> {
	int stage;
	float failureRate;
	
	Rate(int stage) {
		this.stage = stage;
	}
	
	@Override
	public int compareTo(Rate rate) {
		// 실패율이 같다면 스테이지 번호의 오름차순
		if(failureRate == rate.failureRate) {
			return Integer.compare(stage, rate.stage);
		}
		// 실패율의 내림차순
		return -Float.compare(failureRate, rate.failureRate);
	}
}

class Stage {
	float users;
	float failUsers;
	
	float getFailureRate() {
		// 해당 스테이지까지 도달한 사용자가 없으면 실패율은 0
		if(users == 0)
			return users;
		return failUsers / users;
	}
}

public class FailureRate {
	
	public int[] solution(int N, int[] stages) {
		// 각 스테이지의 실패율
		Rate[] rates = new Rate[N];
		Stage[] stageInfo = new Stage[N];
		
		for(int i = 0; i < N; i++) {
			rates[i] = new Rate(i + 1);
			stageInfo[i] = new Stage();
		}
		
		for(int i = 0; i < stages.length; i++) {
			int tmpStage = stages[i] - 1;
			try {		
				// 해당 스테이지에 머물러 있는 사용자 수
				stageInfo[tmpStage].failUsers++;			
			} catch(IndexOutOfBoundsException e) {
				// stage가 N+1인 경우: 모든 스테이지를 클리어 한 경우
				tmpStage--;
			}
			
			// 해당 스테이지를 거친 사용자 수
			for(int j = 0; j <= tmpStage; j++) {
				stageInfo[j].users++;
			}
		}
		
		// 실패율 계산
		for(int i = 0; i < N; i++)
			rates[i].failureRate = stageInfo[i].getFailureRate();
		
		// 실패율의 내림차순, 스테이지의 오름차순으로 정렬
		Arrays.sort(rates);
		int[] answer = new int[N];
		for(int i = 0; i < N; i++)
			answer[i] = rates[i].stage;
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stages = {3, 3, 3, 3};
		new FailureRate().solution(5, stages);
	}

}
