import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static int N;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        arr = new int[N];

        dfs(0);
        System.out.println(count);

    }

    public static void dfs(int depth) {

        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (check(arr, depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean check(int arr[], int depth) {

        for (int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth]) return false;
            else if (Math.abs(i-depth)==Math.abs(arr[i]-arr[depth])) {
                return false;
            }
        }
        return true;
    }
}
