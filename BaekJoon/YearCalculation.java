import java.io.*;

public class YearCalculation {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int[] years = new int[3];
        for(int i = 0; i < 3; i++)
            years[i] = Integer.parseInt(ss[i]);
        int[] arr = {15, 28, 19};
        
        int n = years[0];
        boolean isYear = false;
        while(true){
            for(int i = 1; i < 3; i++){
            	if((n % arr[i] != years[i]) && !(n % arr[i] == 0 && arr[i] == years[i]))
                    break;
                if(i == 2)
                    isYear = true;
            }
            if(isYear)
                break;
            n += arr[0];
        }
        System.out.println(n);
    }
}
