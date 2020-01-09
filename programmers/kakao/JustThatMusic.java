package kakao;

import java.util.PriorityQueue;

class MusicInfo implements Comparable<MusicInfo> {
	String startTime;
	String endTime;
	String title;
	String tone;
	int playTime;
	StringBuilder playTone = new StringBuilder();
	int startHour, startMinute, endHour, endMinute;
	
	MusicInfo(String knownTone) {
		String[] arr = knownTone.split(",");
		
		startTime = arr[0];
		endTime = arr[1];
		title = arr[2];
		tone = arr[3];
		
		getPlayTime();
		getPlayTone();
	}
	
	// 음악이 재생된 시간
	private void getPlayTime() {		
		String[] start = startTime.split(":");
		String[] end = endTime.split(":");
		
		startHour = Integer.parseInt(start[0]);
		startMinute = Integer.parseInt(start[1]);
		endHour = Integer.parseInt(end[0]);
		endMinute = Integer.parseInt(end[1]);
		
		if(endMinute >= startMinute) {
			playTime = 60 * (endHour - startHour) + endMinute - startMinute;
			return;
		}
		endHour--;
		endMinute += 60;
		playTime = 60 * (endHour - startHour) + endMinute - startMinute;
	}
	
	// 재생된 시간동안의 음
	private void getPlayTone() {
		int i = 0;
		int play = playTime;
		int last = tone.length();
		
		while(play >= 0) {
			if(i == last) {
				i = 0;
				continue;
			}
			
			playTone.append(tone.charAt(i));
			
			try {				
				if(tone.charAt(i + 1) == '#') {
					playTone.append(tone.charAt(++i));
				}
			} catch(Exception e) {}
			
			i++;
			play--;
		}
	}

	// 재생시간 내림차순, 입력된 시간 오름차순
	@Override
	public int compareTo(MusicInfo info) {
		int compare = -Integer.compare(playTime, info.playTime);
		if(compare == 0) {
			compare = Integer.compare(startHour, info.startHour);
			if(compare == 0) {
				return Integer.compare(startMinute, info.startMinute);
			}
		}
		return compare;
	}
}

public class JustThatMusic {
	
	public String solution(String m, String[] musicinfos) {
		PriorityQueue<MusicInfo> musics = new PriorityQueue<>();

		for(int i = 0; i < musicinfos.length; i++) {
			musics.add(new MusicInfo(musicinfos[i]));
		}
		
		while(!musics.isEmpty()) {
			MusicInfo music = musics.poll();
			
			if(isInclude(music.playTone.toString(), m))
				return music.title;
		}	
		
		return "(None)";
	}
	
	// ABC는 ABC#에 포함되었다고 판단하면 안되기 때문에 String.contains를 사용하지 않음
	boolean isInclude(String playTone, String knownTone) {
		int length = knownTone.length();
		
		for(int i = 0; i < playTone.length(); i++) {
			if(playTone.charAt(i) == knownTone.charAt(0)) {
				try {
					// knownTone이 playTone에 포함됨
					if(knownTone.equals(playTone.substring(i, i + length))) {
						// knownTone과 같은 playTone의 부분문자열에서 마지막 글자 다음이 #이면 포함하지 않는 것임
						if(playTone.charAt(i + length) != '#') {
							return true;
						}
					}
				} catch(Exception e) {}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		new JustThatMusic().solution("ABCDEFG", musicinfos);
	}
}
