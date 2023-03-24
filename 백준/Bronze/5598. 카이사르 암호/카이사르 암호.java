import java.io.*;
import java.util.*;

public class Main {

    static String s;
    static char[] chars = new char[26];

    public static void main(String[] args) throws IOException {

        initInput();
        getAns();

    }

    static void getAns(){

        StringBuilder sb = new StringBuilder();

        int length = s.length();
        for(int i = 0 ; i < length ; i++){
            int idx = s.charAt(i) - 'A' - 3;
            if(idx < 0) sb.append(chars[26 + idx]);
            else sb.append(chars[idx]);
        }

        System.out.println(sb);
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        char c = 'A';
        for(int i = 0 ; i < 26 ; i++){
            chars[i] = c++;
        }

        br.close();
    }

}
