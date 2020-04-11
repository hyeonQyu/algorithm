package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SevenPigmy {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] pigmies = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++){
            pigmies[i] = Integer.parseInt(br.readLine());
            sum += pigmies[i];
        }
        
        boolean isFind = false;
        for(int i = 0; i < 9; i++){
            int p1 = pigmies[i];
            for(int j = 0; j < 9; j++){
                if(i == j)
                    continue;
                int p2 = pigmies[j];
                
                if(sum - (p1 + p2) == 100){
                    pigmies[i] = 0;
                    pigmies[j] = 0;
                    isFind = true;
                    break;
                }
            }
            if(isFind)
                break;
        }
        
        Arrays.sort(pigmies);
        
        for(int i = 2; i < 9; i++){
            bw.write(pigmies[i] + "\n");
        }
        
        bw.flush();
        bw.close();
	}

}
