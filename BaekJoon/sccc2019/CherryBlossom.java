package sccc2019;

import java.util.Scanner;

public class CherryBlossom {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] blossoms = new int[n];
		for(int i = 0; i < n; i++) {
			blossoms[i] = scanner.nextInt();
		}
		
		int[] group = new int[4];
		for(int i = 0; i < 4; i++) {
			group[i] = 1;
		}
		
		int total;
		int max = 0;
		for(int i = 1; i < n - 2; i++) {
			for(int j = i + 1; j < n - 1; j++) {
				for(int k = j + 1; k < n; k++) {
					
					for(int l = 0; l < 4; l++) {
						group[l] = 1;
					}
					
					for(int l = 0; l < i; l++)
						group[0] *= blossoms[l]; 
					for(int l = i; l < j; l++)
						group[1] *= blossoms[l];
					for(int l = j; l < k; l++)
						group[2] *= blossoms[l];
					for(int l = k; l < n; l++)
						group[3] *= blossoms[l];
					
					total = group[0] + group[1] + group[2] + group[3];
					if(total > max)
						max = total;
					total = 0;
				}
			}
		}
		
		System.out.println(max);
		scanner.close();
	}

}
