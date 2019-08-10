package level3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/* 음악의 고유번호와 재생 수를 담는 클래스 */
class Music implements Comparable<Music> {
	int index;
	int play;
	
	Music(int index, int play) {
		this.index = index;
		this.play = play;
	}

	@Override
	// play에 대하여 내림차순, index에 대하여 오름차순
	public int compareTo(Music o) {
		if(play > o.play)
			return -1;
		else if(play < o.play)
			return 1;
		else {
			if(index < o.index)
				return -1;
			else
				return 1;
		}
	}
}

/* 장르 별 재생 수와 각 장르에 속한 음악들을 담는 클래스 */
class Genre implements Comparable<Genre> {
	String genre;
	PriorityQueue<Music> musics = new PriorityQueue<>();
	int play;
	
	Genre(String genre) {
		this.genre = genre;
		play = 0;
	}
	
	void addMusic(Music music) {
		musics.add(music);
		play += music.play;
	}

	// 스트리밍 수의 내림차순으로 정렬
	@Override
	public int compareTo(Genre o) {
		return play > o.play ? -1 : 1; 
	}
}

public class BestAlbum {
	
	public static int[] solution(String[] genres, int[] plays) {
		ArrayList<Genre> genreList = new ArrayList<>();
		
		genreList.add(new Genre(genres[0]));
		genreList.get(0).addMusic(new Music(0, plays[0]));
		
		for(int i = 1; i < genres.length; i++) {
			Music music = new Music(i, plays[i]);
			boolean isExist = false;
			
			for(int j = 0; j < genreList.size(); j++) {
				Genre curGenre = genreList.get(j);				

				// 현재 노래의 장르가 장르 리스트에 존재
				if(genres[i].equals(curGenre.genre)) {
					curGenre.addMusic(music);
					isExist = true;
					break;
				}
			}
			// 현재 노래의 장르가 장르 리스트에 없으므로 추가
			if(!isExist) {
				genreList.add(new Genre(genres[i]));
				genreList.get(genreList.size() - 1).addMusic(music);
			}
		}

		// 가장 많이 재생된 장르 순으로 정렬
		genreList.sort(null);
		// 정답을 저장할 리스트
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0; i < genreList.size(); i++) {
			Genre curGenre = genreList.get(i);
			for(int j = 0; j < 2; j++) {
				// 장르에 노래가 두 곡 이상이라면 상위 두 곡을 추가, 한 곡이라면 한 곡만 추가
				try {
					list.add(curGenre.musics.poll().index);
				}
				catch(Exception e) {
				}
			}
		}
		
		// 리스트에 있는 정답을 배열로 옮김
		int[] answer = new int[list.size()];
		int index = 0;
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			answer[index++] = itr.next();
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = {"classic", "pop", "classic", "rock", "classic", "pop", "pop"};
		int[] plays = {10, 800, 30, 200, 70, 500, 500};
		int[] answer = solution(genres, plays);
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}
