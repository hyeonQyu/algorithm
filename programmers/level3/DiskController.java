package level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {
	
	public int solution(int[][] jobs) {
		int numOfJobs = jobs.length;
		
		// 작업이 요청되는 시점의 오름차순으로 정렬, 시점이 같다면 작업시간의 오름차순으로 정렬
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] < o2[0])
					return -1;
				else if(o1[0] == o2[0])
					return Integer.compare(o1[1], o2[1]);
				else
					return 1;
				//return Integer.compare(o1[0], o2[0]);
			}		
		});
		
		// 작업 시간이 짧은 것이 우선인 우선순위 큐(요청 목록)
		PriorityQueue<int[]> requestList = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int time = jobs[0][0];			// 첫 시점은 가장 먼저 요청되는 작업이 시작하는 시점
		int jobIndex = 0;
		int jobStartTime = time;		// 특정 작업이 시작되는 시점
		int[] runJob = jobs[0];
		int totalRequireTime = 0;		// 총 작업들의 요청으로부터 종료까지 소요되는 시간
		
		while(true) {
			// 현재 작업이 종료
			if(time == jobStartTime + runJob[1]) {
				totalRequireTime += (time - runJob[0]);
				
				// 요청된 목록이 없음
				if(requestList.isEmpty()) {
					// 모든 작업을 완료함
					if(jobIndex == numOfJobs - 1)
						break;
					else {
						// 시간을 스킵
						jobIndex++;
						runJob = jobs[jobIndex];
						time = runJob[0];
					}
				}
				// 요청 목록 중 가장 앞에 있는 작업을 현재 작업으로 설정
				else
					runJob = requestList.poll();
				
				jobStartTime = time;
			}
			
			// 새로운 요청 작업을 요청 목록에 추가
			try {
				while(time == jobs[jobIndex + 1][0]) {
					jobIndex++;
					requestList.add(jobs[jobIndex]);
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {				
			}
			
			time++;
		}
		
		System.out.println("answer: " + totalRequireTime / numOfJobs);
		return totalRequireTime / numOfJobs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] jobs = {{0,9}, {0,4}, {0,5}, {0,7}, {0,3}};
		new DiskController().solution(jobs);
	}

}
