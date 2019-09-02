package level3;

import java.util.PriorityQueue;

class Word implements Comparable<Word>, Cloneable {
	String word;
	int diffFromTarget;		// 타겟으로부터 다른 자리의 수
	PriorityQueue<Word> nextWords = new PriorityQueue<>();
	int level;
	
	Word(String word, String target) {
		this.word = word;
		diffFromTarget = getDiffFromTarget(target);
		level = 0;
	}
	
	public void addNextWords(Word otherWord) {
		// 다른 자리가 1개라면 nextWord 우선순위 큐에 추가
		if(getDiffFromTarget(otherWord.word) == 1)
			nextWords.add(otherWord);
	}
	
	private int getDiffFromTarget(String target) {
		int value = 0;
		
		for(int i = 0; i < target.length(); i++) {
			if(target.charAt(i) != this.word.charAt(i))
				value++;
		}
		
		return value;
	}
	
	// diffFromTarget(타켓으로부터 다른 자리의 수)의 오름차순으로 정렬
	@Override
	public int compareTo(Word w) {
		if(diffFromTarget > w.diffFromTarget)
			return 1;
		else
			return -1;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class WordConversion {
	
	public static int solution(String begin, String target, String[] words) throws CloneNotSupportedException {
		int cost = 0;
		
		boolean isExist = false;
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(target)) {
				isExist = true;
				break;
			}
		}
		// target이 words배열에 존재하지 않으므로 0을 반환 
		if(!isExist)
			return 0;
		
		// Word 클래스에 초기화
		Word beginWord = new Word(begin, target);
		Word[] theWords = new Word[words.length];
		for(int i = 0; i < words.length; i++) {
			theWords[i] = new Word(words[i], target);
		}
		for(int i = 0; i < theWords.length; i++) {
			beginWord.addNextWords(theWords[i]);
			for(int j = 0; j < theWords.length; j++) {
				if(i != j) {
					theWords[i].addNextWords(theWords[j]);
				}
			}
		}
		
		// 최고우선탐색(인공지능 과제2 참고)		
		PriorityQueue<Word> pq = new PriorityQueue<>();
		boolean isFinish = false;
		// 시작 단어를 우선순위 큐에 넣음
		pq.add(beginWord);
		while(!pq.isEmpty() && !isFinish) {
			Word tmp = pq.poll();
			int level = tmp.level;

			while(!tmp.nextWords.isEmpty()) {
				// level 저장을 위한 객체 복사
				Word tmp2 = (Word) tmp.nextWords.poll().clone();
				tmp2.level = level + 1;
				
				// target 단어라면
				if(tmp2.diffFromTarget == 0) {
					isFinish = true;
					cost = tmp2.level;
					break;
				}
				
				// 확장한 노드의 자식들을 우선순위 큐에 넣음
				pq.add(tmp2);
			}
		}

		return cost;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		String[] words = {"hot", "dot", "lot", "dog", "log", "cog"};
		System.out.println(solution("hit", "cog", words));
	}

}
