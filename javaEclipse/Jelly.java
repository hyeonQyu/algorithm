package javaEclipse;
import java.util.Scanner;

public class Jelly {

	static int range;
	static int[][] board;
	static boolean answer;

	static void findPath(int x, int y) {
		if (x == range - 1 && y == range - 1)
			answer = true;

		else {
			if (x + board[x][y] < range)
				findPath(x + board[x][y], y);
			if (y + board[x][y] < range)
				findPath(x, y + board[x][y]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		range = scanner.nextInt();
		board = new int[range][range];

		for (int i = 0; i < range; i++) {
			for (int j = 0; j < range; j++)
				board[i][j] = scanner.nextInt();
		}

		answer = false;
		findPath(0, 0);
		
		if (answer)
			System.out.print("HaruHaru");
		else
			System.out.print("Hing");

		scanner.close();
	}

}
