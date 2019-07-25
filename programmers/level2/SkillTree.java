package level2;

public class SkillTree {
	
	public static int solution(String skill, String[] skill_trees) {
		int count = 0;
		int skillLength = skill.length();
		int[] matchCount = new int[skill_trees.length];
		
		String[] tmp_trees = new String[skill_trees.length];
		for(int i = 0; i < tmp_trees.length; i++) {
			tmp_trees[i] = "";
		}
		
		for(int i = 0; i < skill_trees.length; i++) {
			int k = 0;
			for(int j = 0; j < skill_trees[i].length(); j++) {
				if(skill.charAt(k) == skill_trees[i].charAt(j)) {
					// tmp_tree에는 skill순서와 skill_tree가 맞는 경우의 skill만 저장
					tmp_trees[i] += skill_trees[i].charAt(j);
					if(k < skillLength - 1)
						k++;
				}
				
				for(int l = 0; l < skillLength; l++) {
					if(skill_trees[i].charAt(j) == skill.charAt(l))
						// skill_tree에 순서가 정해져 있는 skill의 개수를 저장
						matchCount[i]++;
				}
			}
		}
		
		for(int i = 0; i < tmp_trees.length; i++) {
			if(tmp_trees[i].length() == matchCount[i])
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill = "CBD";
		String[] trees = {"BACDE", "CBADF", "AECB", "BDA"};
		int a = solution(skill, trees);
	}

}
