import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int[] distances;

    public static void main(String[] args) throws IOException {

        StringBuilder result = new StringBuilder();
        initInput();

        for (int i = 0; i < T; i++) {
            result.append(getMinDistance(i)).append("\n");
        }
        System.out.println(result);
    }

    static int getMinDistance(int T) {

        int distance = distances[T];

        double sqrt = Math.sqrt(distance);

        // 제곱수라면
        if (sqrt == (int) sqrt) {
            return (int) sqrt * 2 - 1;
        } else {
            int beforeSqrt = (int) sqrt * (int) sqrt;
            int nextSqrt = ((int)sqrt + 1) * ((int) sqrt + 1);

            // 거리가 이전 제곱수랑 더 가깝다면
            if (distance - beforeSqrt < nextSqrt - distance) {
                return ((int) sqrt) * 2;
            } else {
                return ((int) sqrt + 1) * 2 - 1;
            }
        }
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        distances = new int[T];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            distances[i] = (-1) * Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        }

        br.close();
    }

}
