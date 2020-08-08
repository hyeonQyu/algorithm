import java.io.*;

public class Matrix{
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int rows = Integer.parseInt(arr[0]);
        int cols = Integer.parseInt(arr[1]);
        char[][][] mat = new char[2][][];
        for(int i = 0; i < 2; i++){
            mat[i] = new char[rows][];
            for(int j = 0; j < rows; j++){
                String s = br.readLine();
                mat[i][j] = new char[cols];
                for(int k = 0; k < cols; k++){
                    mat[i][j][k] = s.charAt(k);
                }
            }
        }
        
        // 두 행렬의 각 i,j에 대해 다른지 검사
        boolean[][] isDiff = new boolean[rows][];
        for(int i = 0; i < rows; i++){
            isDiff[i] = new boolean[cols];
            for(int j = 0; j < cols; j++){
                if(mat[0][i][j] != mat[1][i][j]){
                    isDiff[i][j] = true;
                    if(rows < 3 || cols < 3){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        if(rows < 3 || cols < 3){
            System.out.println(0);
            return;
        }
        
        // isDiff 행렬을 모두 false로 만듦
        int count = 0;
        int tmp = 1;
        int r = rows - 2;
        int c = cols - 2;
        while(tmp > 0){
            tmp = 0;
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(isDiff[i][j]){
                        tmp++;
                        for(int k = i; k < i + 3; k++){
                            for(int l = j; l < j + 3; l++){
                                isDiff[k][l] = !isDiff[k][l];
                            }
                        }
                    }
                }
            }
            count += tmp;
        }
        // 행렬이 변환할 수 없는지 확인
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(isDiff[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }
}