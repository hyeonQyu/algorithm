package level1;

public class HidePhoneNum {
	
	public String solution(String phone_number) {
		String phoneNum = "";
		
		for(int i = 0; i < phone_number.length(); i++) {
			if(i > phone_number.length() - 5)
				phoneNum += phone_number.charAt(i);
			else
				phoneNum += '*';
		}
		
		return phoneNum;
	}

}
