package javaEclipse;
import java.util.Scanner;

public class OthelloReassign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int time = scanner.nextInt();
		int[] workCount = new int[time];
		for(int i = 0; i < time; i++) {
			int numOfOthello = scanner.nextInt();
			String othelloAssign = scanner.next();
			String othelloReassign = scanner.next();
			
			String[] othello = othelloAssign.split("");
			String[] othello2 = othelloReassign.split("");
			
			int countW1 = 0;
			int countW2 = 0;
			int wrongCount = 0;
			for(int j = 0; j < othello.length; j++) {
				if(othello[j].equals("W"))
					countW1++;
				if(othello2[j].equals("W"))
					countW2++;
				if(!othello[j].equals(othello2[j]))
					wrongCount++;
			}
			if(countW1 == countW2) {
				if(wrongCount == 0)
					workCount[i] = 0;
				else
					workCount[i] = wrongCount / 2;
			}
			else {
				int tmp = Math.abs(countW1 - countW2);
				if(countW1 == 0 || countW2 == 0)
					workCount[i] = wrongCount;
				if(tmp % 2 == 0) {
					if(tmp < wrongCount)
						workCount[i] = 1 + tmp;
					else
						workCount[i] = tmp;
				}
				else {
					if(tmp < wrongCount) {
						if(tmp == 1)
							workCount[i] = 1 + tmp;
						else
							workCount[i] = 2 + tmp;
					}						
					else
						workCount[i] = tmp;
				}
			}
		}
		
		for(int i = 0; i < time; i++)
			System.out.println(workCount[i]);
		
		scanner.close();
	}

}
