import java.io.*;

public class Change {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = 1000 - Integer.parseInt(br.readLine());
        int count = 0;
        int[] coins = {500, 100, 50, 10, 5, 1};
        for(int i = 0; i < 6; i++){
            if(change >= coins[i]){
                count += (change / coins[i]);
                change %= coins[i];
            }
        }
        System.out.println(count);
    }
}
