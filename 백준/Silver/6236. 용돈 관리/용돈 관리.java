import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] money;

    public static void main(String[] args) throws IOException {

        initInput();
        System.out.println(getMinCost());
    }

    static int getMinCost() {

        int start = 0;
        int end = 1000000000;
        int min = 0;

        for(int i = 0 ; i < N ; i++){
            if(start < money[i]) start = money[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossibleMoney(mid)) {
                min = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return min;
    }

    static boolean isPossibleMoney(int target) {

        int count = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (sum + money[i] > target) {
                count++;
                sum = money[i];
            } else sum += money[i];
        }

        return count <= M;
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        br.close();
    }
}
