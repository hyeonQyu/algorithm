package kakao;

import java.util.HashMap;
import java.util.Iterator;

class TrieNode {
	
	char value;
	int includeWords;
	HashMap<Character, TrieNode> childs = new HashMap<>();
	TrieNode parent;
	int level;
	boolean isEnd = false;
	
	TrieNode(char value, int level) {
		this.value = value;
		this.level = level;
		includeWords = 0;
	}
	
	// 한 단어의 끝임을 표시
	public void setLastValue() {
		includeWords++;
		isEnd = true;
		
		TrieNode tmpParent = parent;
		// 루트까지 올라가면서 includeWords 값 갱신
		while(tmpParent.value != ' ') {
			tmpParent.includeWords++;
			tmpParent = tmpParent.parent;
		}
	}
	
	public boolean setChild(TrieNode child) {
		if(!childs.containsKey(child.value)) {
			// 자식으로 추가
			childs.put(child.value, child);
			child.parent = this;
			return true;
		}
		// 자식으로 추가하지 않음
		return false;
	}
	
	public void traverse() {
		Iterator<Character> itr = childs.keySet().iterator();
		while(itr.hasNext()) {
			char key = itr.next();
			TrieNode node = childs.get(key);
			
			// 트라이가 갈라지는 지점(서로 다른 단어로 나뉘는 지점) 혹은 단어 하나가 끝나는 지점
			if((includeWords > node.includeWords && node.includeWords == 1) || (node.isEnd && !node.childs.isEmpty())) {
				Autocomplete.total += node.level;
			}		
			
			node.traverse();
		}
	}
	
}

class Trie {
	
	private TrieNode root = new TrieNode(' ', 0);
	private TrieNode currentNode;
	
	Trie() {
		root.includeWords = 30;
	}
	
	public void add(char value, boolean isLastValue) {		
		TrieNode newNode = new TrieNode(value, currentNode.level + 1);
		
		// 새로운 노드가 현재 노드의 자식이 됨
		if(currentNode.setChild(newNode))
			currentNode = newNode;
		else
			currentNode = currentNode.childs.get(value);
		
		// 한 단어의 끝임을 표시
		if(isLastValue)
			currentNode.setLastValue();
	}
	
	public void setFirst() {
		currentNode = root;
	}
	
	public void traverse() {
		root.traverse();
	}
	
}

public class Autocomplete {
	
	public static int total = 0; 
	
	public int solution(String[] words) {
		Trie trie = new Trie();
		int number = words.length;
		for(int i = 0; i < number; i++) {
			// 트라이를 처음(시작)으로 되돌려놓음
			trie.setFirst();
			
			int length = words[i].length();
			for(int j = 0; j < length; j++) {
				trie.add(words[i].charAt(j), j == length - 1);
			}
		}
		trie.traverse();
		
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"aac", "aad", "aae", "aacd"};
		System.out.println(new Autocomplete().solution(words));
	}

}