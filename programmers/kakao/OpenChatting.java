package kakao;

import java.util.HashMap;

public class OpenChatting {
	
	public String[] solution(String[] record) {
		// 유저 정보를 담을 해쉬맵
		HashMap<String, String> users = new HashMap<>();
		
		int change = 0;
		// 유저 정보를 넣음(최신 정보 반영)
		for(int i = 0; i < record.length; i++) {
			String[] elements = record[i].split(" ");
			try {
				users.put(elements[1], elements[2]);
			} catch(IndexOutOfBoundsException e) {}
			if(elements[0].equals("Change"))
				change++;
		}
		
		String[] answer = new String[record.length - change];
		int j = 0;
		// 관리자에게 출력될 메시지
		for(int i = 0; i < record.length; i++) {
			String[] elements = record[i].split(" ");
			String id = elements[1];
			try {
				String nickname = users.get(id);
				
				switch(elements[0]) {
				case "Enter":
					answer[j++] = nickname + "님이 들어왔습니다.";
					break;
				case "Leave":
					answer[j++] = nickname + "님이 나갔습니다.";
					break;
				}
			} catch(IndexOutOfBoundsException e) {}			
		}
		return answer;
	}

}
