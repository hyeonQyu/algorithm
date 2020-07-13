import java.io.*;

public class CroatiaAlphabet {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'c'){
                try{
                    char c2 = s.charAt(i + 1);
                    if(c2 == '=' || c2 == '-')
                        i++;
                }
                catch(Exception e){}
            }
            else if(c == 'd'){
                try{
                    char c2 = s.charAt(i + 1);
                    if(c2 == '-')
                        i++;
                    else if(c2 == 'z'){
                        char c3 = s.charAt(i + 2);
                        if(c3 == '=')
                            i += 2;
                    }
                }
                catch(Exception e){}
            }
            else if(c == 'l'){
                try{
                    char c2 = s.charAt(i + 1);
                    if(c2 == 'j')
                        i++;
                }
                catch(Exception e){}
            }
            else if(c == 'n'){
                try{
                    char c2 = s.charAt(i + 1);
                    if(c2 == 'j')
                        i++;
                }
                catch(Exception e){}
            }
            else if(c == 's' || c == 'z'){
                try{
                    char c2 = s.charAt(i + 1);
                    if(c2 == '=')
                        i++;
                }
                catch(Exception e) {}
            }
            count++;
        }
        System.out.println(count);
    }
}
