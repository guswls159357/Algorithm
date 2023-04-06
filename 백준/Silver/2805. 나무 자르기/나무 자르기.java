import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        initInput();
        System.out.println(getUpperbound(0, 1000000000));
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 1, N + 1);

        br.close();
    }

    static int getUpperbound(int start, int end) {

        int maxHeight = start - 1;

        while (start <= end) {

            int mid = (start + end) / 2;
            // mid 높이로 잘랐을때의 합
            long sum = getSum(mid);

            if(sum >= M){
                maxHeight = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return maxHeight;
    }

    static long getSum(int height) {

        long sum = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i] > height) sum += arr[i] - height;
        }

        return sum;
    }
}
