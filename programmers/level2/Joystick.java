package level2;

public class Joystick {
	
	// 상하 세기
	static int getUpDownCount(char letter, int count) {
		int n = letter;
		
		if(n > 78)
			count += 'Z' + 1 - n;
		else
			count += n - 'A';
		
		return count;
	}
	
	// +1, -1
	static int plusOne(int forPlus, boolean isPlus, int length) {
		int value;
		if(isPlus) {
			value = forPlus + 1;
			if(value == length)
				value = 0;
		}
		else {
			value = forPlus - 1;
			if(value == -1)
				value = length - 1;
		}
		
		return value;
	}
	
	public static int solution(String name) {
		int count = 0;
		int doneCount = 0;
		int length = name.length();
		boolean[] isDone = new boolean[name.length()];
		
		if(name.length() == 1) {
			count = getUpDownCount(name.charAt(0), count);
			return count;
		}
		
		for(int i = 0; i < name.length(); i++) {
			if(name.charAt(i) == 'A') {
				isDone[i] = true;
				doneCount++;
			}
			else
				isDone[i] = false;
		}
		
		int curPos = 0;
		int next = -1;
		int prev = -1;
		int tmpPos, nextPos, prevPos;
		while(doneCount < length) {
			count = getUpDownCount(name.charAt(curPos), count);
			if(!isDone[curPos]) {
				isDone[curPos] = true;
				doneCount++;
			}
			
			next = 0;	// 정방향 카운트
			prev = 0;	// 역방향 카운트
			
			tmpPos = curPos;
			while(isDone[tmpPos]) {
				// 완료된 알파벳 찾기(정방향)
				tmpPos = plusOne(tmpPos, true, length);
				next++;
				if(next == length)
					break;
			}
			nextPos = tmpPos;
			
			tmpPos = curPos;
			while(isDone[tmpPos]) {
				// 완료된 알파벳 찾기(역방향)
				tmpPos = plusOne(tmpPos, false, length);
				prev++;
				if(next == length)
					break;
			}
			prevPos = tmpPos;
			
			if(next > prev) {
				// 역방향으로 진행
				count += prev;
				curPos = prevPos;
			}
			else {
				// 정방향으로 진행
				count += next; 
				curPos = nextPos;
			}
		}
		
		return count - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("JEROEN"));
	}

}
