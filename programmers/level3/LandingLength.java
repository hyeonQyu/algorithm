package level3;

import java.util.HashSet;

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// from, to 변수의 검사를 통해 객체의 동일여부 판단
class Path {
	Point from;
	Point to;
	
	Path(Point from, Point to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public int hashCode() {
		final int prime = 79;
		int result = 1;
		result = prime * result + (from.hashCode() + to.hashCode()); 
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// a -> b 와 b -> a 는 같은 경로
		Path other = (Path) obj;
		if(from.equals(other.from) && to.equals(other.to))
			return true;
		if(from.equals(other.to) && to.equals(other.from))
			return true;
		return false;
	}
}

public class LandingLength {
	
	public int solution(String dirs) {
		// 경로 중복여부 검사를 위해 HashSet 사용
		HashSet<Path> paths = new HashSet<>();
		Point[][] points = new Point[11][11];
		
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				points[i][j] = new Point(i, j);
			}
		}
		
		int count = 0;
		Point current = points[5][5];
		for(int i = 0; i < dirs.length(); i++) {
			Point next = current;
			
			try {				
				switch(dirs.charAt(i)) {
				case 'U':
					next = points[current.x][current.y - 1];
					break;
				case 'D':
					next = points[current.x][current.y + 1];
					break;
				case 'R':
					next = points[current.x + 1][current.y];
					break;
				case 'L':
					next = points[current.x - 1][current.y];
					break;
				}
				
				// 처음 가는 경로일 경우 count 증가
				if(paths.add(new Path(current, next)))
					count++;
			} catch(Exception e) {}
			
			current = next;
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LandingLength().solution("LRLRLRLRLRLRUUUUUDDDDDDDDDDUUUUUUD");
	}

}
