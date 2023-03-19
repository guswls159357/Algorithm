import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static String[] pwds;

    public static void main(String[] args) throws IOException {

        StringBuilder result = new StringBuilder();
        initInput();
        for(int i = 0 ; i < T ; i++){
            result.append(getRawPwd(pwds[i])).append("\n");
        }
        System.out.println(result);
    }

    static String getRawPwd(String pwd){

        List<Character> list = new LinkedList<>();
        ListIterator<Character> iter = list.listIterator();

        int length = pwd.length();
        char c;
        for(int i = 0 ; i < length ; i++){
            c = pwd.charAt(i);
            if(c == '<'){
                if(iter.hasPrevious()) iter.previous();
            }else if(c == '>'){
                if(iter.hasNext()) iter.next();
            }else if(c == '-'){
                if(iter.hasPrevious()){
                    iter.previous();
                    iter.remove();
                }
            }else{
                iter.add(c);
            }
        }

        while(iter.hasPrevious()){
            iter.previous();
        }

        StringBuilder result = new StringBuilder();
        while(iter.hasNext()){
            result.append(iter.next());
        }
        return result.toString();
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        pwds = new String[T];

        for(int i = 0 ; i < T ; i++){
            pwds[i] = br.readLine();
        }
        br.close();
    }

}
