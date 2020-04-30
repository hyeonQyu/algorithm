import java.util.Scanner;

public class Plus123 {
	
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] test = new int[n];
        
        int max = 0;
        for(int i = 0; i < n; i++){
            test[i] = sc.nextInt();
            if(max < test[i]){
                max = test[i];
            }
        }
        
        int[] d = new int[max + 4];
        d[0] = 0;
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for(int i = 4; i <= max; i++){
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }
        
        for(int i = 0; i < n; i++){
            System.out.println(d[test[i]]);
        }
    }
	
}
