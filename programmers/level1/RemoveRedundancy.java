package level1;

import java.util.Scanner;

public class RemoveRedundancy {

	public static int[] solution(int[] arr) {
		int length = 1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] != arr[i - 1])
				length++;
		}
		System.out.println(length);
		
		int[] newArr = new int[length];
		int index = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] != arr[i + 1])
				newArr[index++] = arr[i];
		}
		
		if(index > 0) {
			if(newArr[index - 1] != arr[arr.length - 1])
				newArr[index] = arr[arr.length - 1];
		}
		else
			newArr[0] = arr[0];
		
		return newArr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		int[] newArr = solution(arr);
		
		for(int i = 0; i < newArr.length; i++)
			System.out.print(newArr[i] + " ");
	}

}
