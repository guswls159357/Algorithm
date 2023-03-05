import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {

        initInput();
        initPrimes();
        printAnswers();
    }

    static void printAnswers(){
        StringBuilder result = new StringBuilder();

        for(int i = M ; i <= N ; i++){
            if(isPrime[i]) result.append(i).append("\n");
        }

        System.out.println(result);
    }

    static void initPrimes(){

        isPrime[1] = false;

        double end = Math.sqrt(N);

        for(int i = 2 ; i <= end ; i++){
            int tmp = 2 * i;
            while(tmp <= N){
                isPrime[tmp] = false;
                tmp += i;
            }
        }
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        br.close();
    }

}
