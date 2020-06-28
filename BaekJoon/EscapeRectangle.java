import java.io.*;

public class EscapeRectangle {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = s.split(" ");
        int[] coord = new int[4];
        for(int i = 0; i < 4; i++){
            coord[i] = Integer.parseInt(arr[i]);
        }
        
        int x = Math.min(coord[0], coord[2] - coord[0]);
        int y = Math.min(coord[1], coord[3] - coord[1]);
        System.out.println(Math.min(x, y));
    }
}
