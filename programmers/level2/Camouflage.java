package level2;

import java.util.ArrayList;
import java.util.Iterator;

class Clothes {
	String kind;
	ArrayList<String> names;
	
	Clothes(String kind) {
		this.kind = kind;
		names = new ArrayList<>();
	}
}

public class Camouflage {
	
	public static int solution(String[][] clothes) {
		ArrayList<Clothes> clothesList = new ArrayList<>();
		int answer;
		
		// 옷 정리
		for(int i = 0; i < clothes.length; i++) {
			boolean hasKind = false;
			Iterator<Clothes> itr = clothesList.iterator();
			while(itr.hasNext()) {
				Clothes curClothes = itr.next();
				if(clothes[i][1].equals(curClothes.kind)) {
					// 현재 옷의 종류가 이미 있는 종류라면 그 종류에 옷 추가
					curClothes.names.add(clothes[i][0]);
					hasKind = true;
					break;
				}
			}
			
			if(!hasKind) {
				// 새로운 종류의 옷이라면
				Clothes newClothes = new Clothes(clothes[i][1]);
				newClothes.names.add(clothes[i][0]);
				clothesList.add(newClothes);
			}
		}
		
		// 경우(옷의 조합)의 수 계산
		answer = clothesList.get(0).names.size() + 1;	// 해당 종류의 옷을 입지 않았을 때의 경우도 추가하기 위해 +1
		for(int i = 1; i < clothesList.size(); i++) {
			answer *= clothesList.get(i).names.size() + 1;
		}
		
		return answer - 1;		// 모든 종류의 옷을 다 입지 않은 경우는 제외해야 하므로 -1
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		int a = solution(clothes);
	}

}
