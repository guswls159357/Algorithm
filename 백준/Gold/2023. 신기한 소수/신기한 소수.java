import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        initInput();

        dfs(0, 0);

        System.out.println(result);
    }

    static void dfs(int depth, int number) {

        if (depth == N) {
            if (isPrime(number)) {
                result.append(number).append("\n");
            }
            return;
        }

        int nextNum = 0;

        if (depth == 0) {
            for (int i = 1; i <= 9; i++) {
                nextNum = number * 10 + i;
                if(isPrime(nextNum)) dfs(depth + 1, number * 10 + i);
            }
        } else if (depth == N - 1) {
                for (int i = 1; i <= 9; i += 2) {
                    nextNum = number * 10 + i;
                    if(isPrime(nextNum)) dfs(depth + 1, number * 10 + i);
                }
        } else {
            for (int i = 0; i <= 9; i++) {
                nextNum = number * 10 + i;
                if(isPrime(nextNum)) dfs(depth + 1, number * 10 + i);
            }
        }

    }

    static boolean isPrime(int num) {

        if (num == 1) return false;
        if (num == 2) return true;
        double sqrt = Math.sqrt(num);

        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        br.close();
    }

}
