import java.util.Scanner;

class Computer {
	int grade;
	int workSpeed;
}

public class WorkTime {
	
	static Computer[] computers;

	static void sort(int l, int r) {
		int left = l;
		int right = r;
		int pivot = computers[(l + r) / 2].grade;

		do {
			while (computers[left].grade < pivot)
				left++;
			while (computers[right].grade > pivot)
				right--;
			if (left <= right) {
				Computer temp = computers[left];
				computers[left] = computers[right];
				computers[right] = temp;
				left++;
				right--;
			}
		} while (left <= right);

		if (l < right)
			sort(l, right);
		if (r > left)
			sort(left, r);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		computers = new Computer[n];

		for (int i = 0; i < n; i++) {
			computers[i] = new Computer();
			computers[i].grade = scanner.nextInt();
			computers[i].workSpeed = scanner.nextInt();
		}

		sort(0, computers.length - 1);

		scanner.close();
	}

}
