import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] A, B;

    // 1 1 3 7 8
    // 1 3 6
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int aIdx = 0 ; aIdx < N ; aIdx++){
                A[aIdx] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);

            int count = 0;
            st = new StringTokenizer(br.readLine());
            for(int bIdx = 0 ; bIdx < M ; bIdx++){
                int b = Integer.parseInt(st.nextToken());
                int lowerBound = getLowerBound(b + 1);
                if(lowerBound != -1) {
                    //System.out.println(b + " " + lowerBound);
                    count += N - lowerBound;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    // 해당 값보다 크거나 같은 인덱스중 가장 작은 인덱스 반환하도록
    static int getLowerBound(int target) {

        int start = 0;
        int end = N - 1;
        int mid = 0;
        int lowerBoundIdx = N;

        while (start <= end) {
            mid = (start + end) / 2;

            if (target <= A[mid]) {
                end = mid - 1;
                if (mid < lowerBoundIdx) lowerBoundIdx = mid;
            } else {
                start = mid + 1;
            }
        }

        if (lowerBoundIdx == N) return -1;
        return lowerBoundIdx;
    }

}
