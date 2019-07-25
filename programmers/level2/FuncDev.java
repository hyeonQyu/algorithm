package level2;

import java.util.ArrayList;

public class FuncDev {
	
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] complete = new int[progresses.length];
		ArrayList<Integer> list = new ArrayList<>();
		
		boolean isCompleted = false;
		int loop = 1;
		while(!isCompleted) {
			for(int i = 0; i < progresses.length; i++) {
				if(progresses[i] < 100) {
					progresses[i] += speeds[i];
				}
				if(progresses[i] >= 100 && complete[i] == 0)
					complete[i] = loop;
				System.out.println("작업" + i + ": " + progresses[i]);
			}
			
			isCompleted = true;
			for(int i = 0; i < complete.length; i++) {
				if(complete[i] == 0) {
					isCompleted = false;
					break;
				}
			}
			loop++;
		}
		
		int preWorkDay = complete[0];
		int count = 1;
		for(int i = 1; i < complete.length; i++) {
			if(preWorkDay >= complete[i]) {
				count++;
			}
			else {
				list.add(count);
				count = 1;
				preWorkDay = complete[i];
			}
			
			if(i == complete.length - 1)
				list.add(count);
		}
		
		int[] answer = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
			System.out.println(answer[i]);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = {90, 25, 80, 75};
		int[] speeds = {6, 25, 15, 10};
		int a[] = solution(progresses, speeds);
	}

}
