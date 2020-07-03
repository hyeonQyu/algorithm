import java.io.*;

public class IntelTrain {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = 0;
        int headcount = 0;
        for(int i = 0; i < 4; i++){
            String[] arr = br.readLine().split(" ");
            int out = Integer.parseInt(arr[0]);
            int in = Integer.parseInt(arr[1]);
            headcount = headcount - out + in;
            if(max < headcount)
                max = headcount;
        }
        
        System.out.println(max);
    }
}
