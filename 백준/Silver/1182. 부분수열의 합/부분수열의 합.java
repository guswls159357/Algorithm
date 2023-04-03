import java.io.*;
import java.util.*;

public class Main {

    // N - 수열의 원소 갯수
    // S - 바라는 부분수열의 합
    static int N, S;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {

        initInput();
        dfs(0, 0);
        if(S == 0) count--;
        System.out.println(count);
    }

    // idx 번째 원소를 선택해야하는 시점
    static void dfs(int idx, int sum) {

        if(idx == N){
            if(sum == S) count++;
            return;
        }

        dfs(idx + 1, sum);
        dfs(idx + 1, sum + arr[idx]);
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }
}
