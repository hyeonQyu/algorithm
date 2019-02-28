package javaEclipse;
import java.util.Scanner;

class House {
	int red;
	int green;
	int blue;
	int[] expense = new int[3];
}

public class RgbStreet {
	
	public static int getMinimum(int expense1, int expense2) {
		if(expense1 > expense2)
			return expense2;
		else
			return expense1;
	}
	
	public static int getMinimum(int expense1, int expense2, int expense3) {
		if(expense1 <= expense2 && expense1 <= expense3)
			return expense1;
		else if(expense2 <= expense1 && expense2 <= expense3)
			return expense2;
		else
			return expense3;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int numberOfHouse = scanner.nextInt();
		House[] houses = new House[numberOfHouse+1];
		houses[0] = new House();
		for(int i = 1; i < numberOfHouse+1; i++) {
			houses[i] = new House();
			houses[i].red = scanner.nextInt();
			houses[i].green = scanner.nextInt();
			houses[i].blue = scanner.nextInt();
		}
		
		for(int i = 1; i < numberOfHouse+1; i++) {
			houses[i].expense[0] = getMinimum(houses[i-1].expense[1], houses[i-1].expense[2]) + houses[i].red;
			houses[i].expense[1] = getMinimum(houses[i-1].expense[0], houses[i-1].expense[2]) + houses[i].green;
			houses[i].expense[2] = getMinimum(houses[i-1].expense[0], houses[i-1].expense[1]) + houses[i].blue;
		}
		
		System.out.println(getMinimum(houses[numberOfHouse].expense[0], houses[numberOfHouse].expense[1], houses[numberOfHouse].expense[2]));
		
		scanner.close();
	}

}
