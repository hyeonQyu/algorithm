package level2;

public class MakeBigNum {
	
	public static String solution(String number, int k) {
		int i = 0;
		StringBuilder sb = new StringBuilder(number);
		
		while(k > 0) {
			
			if(i < sb.length() - 1) {
				if(sb.charAt(i) - '0' < sb.charAt(i + 1) - '0') {
					// 뒤의 숫자가 더 큰 경우 앞의 숫자 삭제
					sb.deleteCharAt(i);
					i = 0;
					k--;
				}
				else {
					i++;
				}
			}
			
			else {
				// 삭제해야 할 수가 남았는데 맨 뒤까지 도달한 경우 뒤에서부터 k개만큼 제거
				sb.delete(sb.length() - k, sb.length());
				break;
			}
			
		}
		
		number = sb.toString();
		return number;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("4177252841", 4));
	}

}
