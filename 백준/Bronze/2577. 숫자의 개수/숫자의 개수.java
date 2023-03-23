import java.io.*;
import java.util.*;

public class Main {

    static int[] number = new int[3];
    static int[] count = new int[10];

    public static void main(String[] args) throws IOException {

        initInput();
        count();
        print();
    }

    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int cnt : count){
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void count(){

        String multyply = String.valueOf(number[0] * number[1] * number[2]);
        int length = multyply.length();

        for(int i = 0 ; i < length ; i++){
            char c = multyply.charAt(i);
            count[c - '0']++;
        }
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 3 ; i++){
            number[i] = Integer.parseInt(br.readLine());
        }

        br.close();
    }

}

