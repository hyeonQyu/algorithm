package javaEclipse;
import java.util.Arrays;
import java.util.Scanner;

class GirlQuiz {
	int option;
	String teamOrMem;
}

public class GirlGroup {

	static void setTeamMembers(int nGirlGroups, String[] nameOfTeam, String[][] nameOfMember, Scanner scanner) {

		int nMembers;

		for (int i = 0; i < nGirlGroups; i++) {

//			System.out.print("팀의 이름? ");
			nameOfTeam[i] = scanner.next();
			while (nameOfTeam[i].length() > 100) {
//				System.out.print("팀의 이름 ");
				nameOfTeam[i] = scanner.next();
			}

//			System.out.print("걸그룹 인원 수 ");
			nMembers = scanner.nextInt();
			nameOfMember[i] = new String[nMembers];

//			System.out.println("멤버 이름");
			for (int j = 0; j < nMembers; j++) {
				nameOfMember[i][j] = scanner.next();
				if (nameOfMember[i][j].length() > 100) {
//					System.out.println("글자수 초과. 다시 입력");
					j--;
				}

				for (int k = 0; k < j; k++) {
					if (nameOfMember[i][k].equals(nameOfMember[i][j])) {
//						System.out.println("이름 중복. 다시 입력");
						j--;
						break;
					}
				}
			}
		}
	}

	static void makeQuiz(int nQuiz, GirlQuiz[] quiz, Scanner scanner) {
//		System.out.println("퀴즈 입력");
		for (int i = 0; i < nQuiz; i++) {
			quiz[i] = new GirlQuiz();
			quiz[i].teamOrMem = scanner.next();
			quiz[i].option = scanner.nextInt();
		}
	}
	
	static void showMembers(String[] members) {
		for (int i = 0; i < members.length; i++) {
			Arrays.sort(members, String.CASE_INSENSITIVE_ORDER);
			System.out.println(members[i]);
		}
	}

	static void showAnswer(GirlQuiz[] quiz, String[] nameOfTeam, String[][] nameOfMember, Scanner scanner) {
		for (int i = 0; i < quiz.length; i++) {
			if (quiz[i].option == 0) {
				for (int j = 0; j < nameOfTeam.length; j++) {
					if (nameOfTeam[j].equals(quiz[i].teamOrMem))
						showMembers(nameOfMember[j]);
				}
			}
			else {
				for (int j = 0; j < nameOfMember.length; j++) {
					for (int k = 0; k < nameOfMember[j].length; k++) {
						if (nameOfMember[j][k].equals(quiz[i].teamOrMem))
							System.out.println(nameOfTeam[j]);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		int nGirlGroups, nQuiz;
		String[] nameOfTeam;
		String[][] nameOfMember;
		GirlQuiz[] quiz;

		nGirlGroups = 0;
		nQuiz = 0;

		while (1 > nGirlGroups || nGirlGroups > 99 || nQuiz < 1 || nQuiz > 99) {
	//		System.out.print("걸그룹 수 / 문제의 수(1 ~ 99 사이의 수) ");
			nGirlGroups = scanner.nextInt();
			nQuiz = scanner.nextInt();
		}

		nameOfTeam = new String[nGirlGroups];
		nameOfMember = new String[nGirlGroups][];
		quiz = new GirlQuiz[nQuiz];

		setTeamMembers(nGirlGroups, nameOfTeam, nameOfMember, scanner);
		makeQuiz(nQuiz, quiz, scanner);
		showAnswer(quiz, nameOfTeam, nameOfMember, scanner);

		scanner.close();
	}

}
