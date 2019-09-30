package kakao;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class CandidateKey {
	
	// 1인 비트가 적은 수 -> 많은 수 순서로 정렬
	Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			int bits1 = 0;
			int bits2 = 0;
			while(o1 > 0 || o2 > 0) {
				if((o1 & 1) == 1)
					bits1++;
				if((o2 & 1) == 1)
					bits2++;
				
				o1 = o1 >> 1;
				o2 = o2 >> 1;
			}
			
			return Integer.compare(bits1, bits2);
		}
	};
	
	private boolean isSuperKey(String[][] relation, int attribute) {
		String[] setOfAttr = new String[relation.length];
		for(int i = 0; i < setOfAttr.length; i++)
			setOfAttr[i] = "";
		
		for(int k = 0; k < relation[0].length; k++) {
			// attribute의 이진 표현 비트가 1인 열에 대해 속성의 부분집합 생성
			if((attribute & (1 << k)) > 0) {
				for(int i = 0; i < relation.length; i++) {
					setOfAttr[i] += relation[i][k];
				}
			}
		}
		
		// 중복검사
		for(int i = 0; i < setOfAttr.length - 1; i++) {
			for(int j = i + 1; j < setOfAttr.length; j++) {
				if(setOfAttr[i].equals(setOfAttr[j]))
					return false;
			}
		}
		return true;
	}
	
	public int solution(String[][] relation) {
		LinkedList<Integer> supers = new LinkedList<>();
		
		for(int i = 1; i < (1 << relation[0].length); i++) {
			// 유일성을 만족하면 리스트에 추가
			if(isSuperKey(relation, i))
				supers.add(i);
		}
		
		// 1 비트 수대로 정렬
		Collections.sort(supers);
		// 리스트를 옮겨 담을 배열
		int[] candidates = new int[supers.size()];
		
		Iterator<Integer> itr = supers.iterator();
		int index = 0;
		while(itr.hasNext()) {
			candidates[index++] = itr.next();
		}
		
		// 최소성 검사
		for(int i = 0; i < candidates.length - 1; i++) {
			if(candidates[i] > 0) {
				for(int j = i + 1; j < candidates.length; j++) {
					// 두 수가 모두 유효한 숫자이어야 함(최소성 검사에서 탈락하지 않은 수)
					if(candidates[j] > 0) {
						// 뒤에 있는 수가 탈락해야 하는 경우(후보키에서 탈락)
						if((candidates[i] & candidates[j]) > 0 && (candidates[i] | candidates[j]) == candidates[j]) {
							candidates[j] = 0;
						}
					}
				}
			}		
		}
		
		int answer = 0;
		// 탈락되지 않은 수(후보키)만 셈
		for(int i = 0; i < candidates.length; i++) {
			if(candidates[i] != 0)
				answer++;
		}
		
		return answer;
	}

}
