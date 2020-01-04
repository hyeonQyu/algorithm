package kakao;

import java.util.Arrays;

class File implements Comparable<File> {
	String fileName;
	String head;
	int number;
	int order;
	
	File(String fileName, int order){
		this.fileName = fileName;
		this.order = order;
		int i = 0;
		
		StringBuilder headBuilder = new StringBuilder();
		for(i = 0; i < fileName.length(); i++) {
			char c = fileName.charAt(i);
			if(!Character.isDigit(c)) {
				headBuilder.append(c);
			}
			else {
				break;
			}
		}
		head = headBuilder.toString().toLowerCase();
		
		StringBuilder numBuilder = new StringBuilder();
		for(int j = i; j < fileName.length(); j++) {
			char c = fileName.charAt(j);
			if(Character.isDigit(c)) {
				numBuilder.append(c);
			}
			else {
				break;
			}
		}
		number = Integer.parseInt(numBuilder.toString());
	}

	@Override
	public int compareTo(File o) {
		int compare = head.compareTo(o.head);
		if(compare == 0) {
			compare = Integer.compare(number, o.number);
			if(compare == 0) {
				return Integer.compare(order, o.order);
			}
		}
		return compare;
	}
}

public class FileSorting {
	
	public String[] solution(String[] files) {
		File[] file = new File[files.length];
		for(int i = 0; i < files.length; i++) {
			file[i] = new File(files[i], i);
		}
		Arrays.sort(file);
		
		for(int i = 0; i < files.length; i++) {
			files[i] = file[i].fileName;
		}
		return files;
	}

}
