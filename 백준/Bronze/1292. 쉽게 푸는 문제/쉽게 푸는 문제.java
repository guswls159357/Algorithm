import java.io.*;
import java.util.*;

public class Main {

    // 1 -> 1까지의 합
    // 2 -> 2까지의 합
    static int[] sum = new int[1001];
    static int start, end;

    public static void main(String[] args) throws IOException {

        initInput();
        initSum();
        System.out.println(sum[end] - sum[start - 1]);
    }

    static void initSum(){

        int idx = 1;
        int number = 1;

        while(idx <= 1000){

            for(int repeat = 0 ; repeat < number &&  idx <= 1000; repeat++){
                sum[idx] = sum[idx - 1] + number;
                idx++;
            }
            number++;
        }
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        br.close();
    }

}
