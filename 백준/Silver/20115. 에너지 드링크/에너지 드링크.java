import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;

    static double arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        double max = Integer.MIN_VALUE;
        double tmp = 0;

        double sum = 0;

        for(int i = 0 ; i < N ; i++){
            tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            if(tmp > max) max = tmp;
            sum += tmp;
        }

        double result = (sum + max) / 2;

        System.out.println(result);
    }
}
