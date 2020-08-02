import java.io.*;

public class CompetitionIntern {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int k = Integer.parseInt(arr[2]);
        
        int max = 0;
        for(int i = 0; i <= k; i++) {
        	int j = k - i;
        	int boy = m - i;
        	if(boy <= 0)
        		break;
        	int girl = n - j;  	
        	int team = girl >= boy * 2 ? boy : girl / 2;
        	if(max < team) {
        		System.out.println(girl + " " + boy + " " + team);
        		max = team;
        	}
        }
        
        System.out.println(max);
    }
}
