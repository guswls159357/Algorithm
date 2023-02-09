import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 0;

        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                min = i;
                sum += i;
                break;
            }
        }

        for (int i = sum + 1; i <= N; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }

        if (min != 0) {
            System.out.println(sum);
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }

    static boolean isPrime(int num) {
        
        if(num == 1) return false;

        double sqrt = Math.sqrt(num);

        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
