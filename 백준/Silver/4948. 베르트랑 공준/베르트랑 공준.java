import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 123456 * 2;
    // -1 : 소수가 아닌 것 , 0 : 아직 판별되지 않은 것, 1 : 소수인 것
    static int[] isPrime = new int[MAX + 1];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 1은 소수가 아니다
        isPrime[1] = -1;

        // 입력값이 0이 아닐때까지
        String input;
        while (!(input = br.readLine()).equals("0")) {

            int primeCount = getPrimeCount(Integer.parseInt(input));
            result.append(primeCount).append("\n");
        }

        System.out.println(result);

        br.close();
    }

    static int getPrimeCount(int N) {

        // N + 1 ~ 2 * N 까지 소수 판별
        int startNumber = N + 1;
        int endNumber = 2 * N;
        int count = 0;

        while (startNumber <= endNumber) {
            if (isPrime(startNumber)) {
                count++;
            }
            startNumber++;
        }

        return count;
    }

    static boolean isPrime(int number) {

        int primeStatus = isPrime[number];

        // 아직 판별되지 않은 경우
        if (primeStatus == 0) {
            double lastNumber = Math.sqrt(number);
            for (int i = 2; i <= lastNumber; i++) {
                if (number % i == 0) {
                    isPrime[number] = -1;
                    return false;
                }
            }
            return true;

        } // 이미 판별된 경우
        else return primeStatus == 1;
    }

}
