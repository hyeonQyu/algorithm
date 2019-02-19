import java.util.Arrays;
import java.util.Scanner;

public class Size {
	
	public static class Person implements Comparable<Person> {
		
		public int weight;
		public int height;
		public int order;
		public int rank;
		
		Person() {
			order = 0;
			rank = 0;
		}
		
		@Override
		public int compareTo(Person person) {
			// TODO Auto-generated method stub
			if (weight > person.weight)
				return -1;
			else if (weight < person.weight)
				return 1;
			else {
				if (height > person.height)
					return -1;
				else if (height < person.height)
					return 1;
				else
					return 0;
			}
		}
		
	}
	
	public static class PersonInOrder implements Comparable<PersonInOrder> {
		
		public int order;
		public int rank;
		
		@Override
		public int compareTo(PersonInOrder personInOrder) {
			if (order < personInOrder.order)
				return -1;
			else
				return 1;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		Person[] person = new Person[num];
		PersonInOrder[] personInOrder = new PersonInOrder[num];
		
		int[] weight = new int[num];
		
		for (int i = 0; i < num; i++) {
			person[i] = new Person();
			person[i].weight = scanner.nextInt();
			person[i].height = scanner.nextInt();
			person[i].order = i;
		}
		
		Arrays.sort(person);
		
		int k = 1;
		int countK = 0;;
		for (int i = 0; i < num-1; i++) {
			if (person[i].height <= person[i+1].height || person[i].weight == person[i+1].weight) {	// 같은 등수
				if (person[i].rank == 0) {
					person[i].rank = k;
					countK++;
				}
				person[i+1].rank = k;
				countK++;
			}
			else {
				if (person[i].rank == 0) {
					person[i].rank = k;		// 앞에가 숫자가 작은 등수
					countK++;
				}
			}
			
			if (person[i+1].rank == 0) {
				k += countK;
				countK = 0;
			}
		}
		if (person[num-1].rank == 0)
			person[num-1].rank = k;
		
		for (int i = 0; i < num; i++) {
			personInOrder[i] = new PersonInOrder();
			personInOrder[i].order = person[i].order;
			personInOrder[i].rank = person[i].rank;
		}
		
		Arrays.sort(personInOrder);
		
		for(int i = 0; i < num; i++)
			System.out.print(personInOrder[i].rank + " ");
		
		scanner.close();
	}
	
}
