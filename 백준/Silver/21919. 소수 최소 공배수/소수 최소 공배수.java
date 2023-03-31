import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static Set<Integer> primes = new HashSet<>();

    public static void main(String[] args) throws IOException {

        initInput();
        for(int i = 0 ; i < N ; i++){
            putToSetIfPrime(arr[i]);
        }

        if(primes.size() == 0) System.out.println(-1);
        else{
            long num = 1;
            for(int prime : primes){
                num *= prime;
            }
            System.out.println(num);
        }
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    static void putToSetIfPrime(int num){

        if(primes.contains(num) || num == 1) return;

        double sqrt = Math.sqrt(num);
        for(int i = 2 ; i <= sqrt ; i++){
            if(num % i == 0) return;
        }
        primes.add(num);
    }
}
