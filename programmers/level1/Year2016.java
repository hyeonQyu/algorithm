package level1;

public class Year2016 {
	
	// 2016년 1월 1일 : 금요일
	// 2016년 3월 15일 : 화요일
	public static String solution(int a, int b) {
		int[] dayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
		
		int sum = 0;
		for(int i = 0; i < a - 1; i++) {
			sum += dayOfMonth[i];
		}
		sum += (b - 1);
		
		return day[sum % 7];
	}

}
