import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        initInput();

        System.out.println(getMax());
    }

    static int getMax() {

        int max = Integer.MIN_VALUE;
        int startIdx = 0;
        int endIdx = K;
        int sum = 0;

        // 초기값 세팅
        for (int i = startIdx; i < endIdx; i++) {
            sum += arr[i];
        }
        if (sum > max) max = sum;

        // 두 번째 부터 반복
        while (endIdx < N) {
            sum -= arr[startIdx++];
            sum += arr[endIdx++];
            if (sum > max) max = sum;
        }
        return max;
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

}
