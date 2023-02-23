import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long count = 0;

        // 숫자의 갯수
        int N = Integer.parseInt(st.nextToken());
        // 구간의 합을 나눌 나머지
        int M = Integer.parseInt(st.nextToken());

        // 구간합 저장
        long[] sum = new long[N + 1];
        // 나머지가 idx인 나머지 갯수 저장
        int[] remainsCnt = new int[1000];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        int remain;
        for(int i = 1 ; i <= N ; i++){
            remain = (int) (sum[i] % M);

            if(remain == 0) count++;
            remainsCnt[remain]++;
        }

        int cnt;
        for (int i = 0 ; i < 1000 ; i++){
            cnt = remainsCnt[i];
            if(cnt >= 2) count += (long) cnt * (cnt-1) / 2;
        }

        System.out.println(count);

        br.close();
    }
}

