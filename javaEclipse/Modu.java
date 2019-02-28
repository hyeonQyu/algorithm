package javaEclipse;
import java.util.Scanner;
import java.util.LinkedList;

public class Modu {

	static LinkedList<Integer> listCards;
	static int gold;

	static int getMaxIndex() {
		int max, index;
		max = index = 0;

		for (int i = 1; i < listCards.size() - 1; i++) {
			if (max < listCards.get(i)) {
				max = listCards.get(i);
				index = i;
			}
		}
		return index;
	}

	static void newCard(int index) {
		while (listCards.get(index - 1) != 0) {
			gold = gold + listCards.get(index) + listCards.get(index - 1);
			listCards.remove(index - 1);
			index--;
		}
		while (listCards.get(index + 1) != 0) {
			gold = gold + listCards.get(index) + listCards.get(index + 1);
			listCards.remove(index + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		listCards = new LinkedList<Integer>();
		gold = 0;

		listCards.add(0);
		for (int i = 0; i < n; i++)
			listCards.add(scanner.nextInt());
		listCards.add(0);

		newCard(getMaxIndex());
		System.out.print(gold);
		scanner.close();
	}

}
