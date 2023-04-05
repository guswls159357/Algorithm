import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        initInput();
        System.out.println(getAns());
    }

    static int getAns() {

        int target = 1;

        for (int i = 0; i < N; i++) {
            if (target < arr[i]) break;
            target += arr[i];
        }

        return target;
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        br.close();
    }
}