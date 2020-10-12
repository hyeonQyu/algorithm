package level2;

public class TriSnail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TriSnail().solution(1000);
	}
	
	public int[] solution(int n) {
        int size = n * (1 + n) / 2;
        int[] arr = new int[size];
        
        int index = 0;
        int prevIndex = index;
        int line = 1;
        int prevLine = line;
        int status = 1;
        for(int i = 1; i <= size;){
            try{
                if(arr[index] == 0)
                    arr[index] = i++;
                else {
                    status = changeStatus(status);
                    index = prevIndex;
                    line = prevLine;
                }
            } catch(Exception e) {
                status = changeStatus(status);
                index = prevIndex;
                line = prevLine;
            }
            
            prevIndex = index;
            prevLine = line;
            
            // line만큼 증가
            if(status == 1){
                index += line;
                line++;
            }
            // 1만큼 증가
            else if(status == 0)
                index++;
            // line만큼 감소
            else if(status == -1){
                index -= line;    
                line--;
            }
        }
        return arr;
    }
    
    int changeStatus(int status){
        if(status == 1)
            return 0;
        else if(status == 0)
            return -1;
        else
            return 1;
    }
}
