import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        initInput();
        System.out.println(getMinValue());
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        br.close();
    }

    static int getMinValue(){

        int fiveCount = N / 5;
        int remain;

        while(fiveCount >= 0){

            remain = N - fiveCount * 5;

            if(remain % 3 == 0) return fiveCount + remain / 3;

            fiveCount--;
        }

        return -1;
    }

}