import java.io.*;

public class AverageScore {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			int tmp = Integer.parseInt(br.readLine());
			sum += (tmp > 40 ? tmp : 40);
		}
		System.out.println(sum / 5);
	}

}
