import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(getNumber(N));
    }

    static int getNumber(int N) {

        Set<Integer> numbers = new HashSet<>();

        int cnt = 0;

        int[] divideNumbers1 = {1000, 10000, 100000, 1000000, 10000000, 100000000};
        int[] divideNumbers2 = {1, 10, 100, 1000, 10000, 100000};

        for (int i = 666; i <= 100000000; i++) {

            int iterCnt = 0;

            if(i < 1000) iterCnt = 1;
            else if(i < 10000) iterCnt = 2;
            else if(i < 100000) iterCnt = 3;
            else if(i < 1000000) iterCnt = 4;
            else if(i < 10000000) iterCnt = 5;
            else iterCnt = 6;

            for (int j = 0; j <= iterCnt; j++) {

                if ((i % divideNumbers1[j]) / divideNumbers2[j] == 666) {
                    if (numbers.contains(i)) break;
                    else {
                        numbers.add(i);
                        cnt++;
                        if (cnt == N) return i;
                    }
                }
            }
        }

        return -1;
    }

}
