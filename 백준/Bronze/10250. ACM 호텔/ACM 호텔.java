import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int[][] input;

    public static void main(String[] args) throws IOException {

        initInput();
        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < T ; i++){
            result.append(getRoomNumber(i)).append("\n");
        }

        System.out.println(result);
    }

    static int getRoomNumber(int T) {

        int height = input[T][0];
        int target = input[T][2];

        int up = target % height == 0
                ? height
                : target % height;
        int right = target % height == 0
                ? target / height
                : target / height + 1;

        return 100 * up + right;
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        input = new int[T][3];

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken()); // 높이
            input[i][1] = Integer.parseInt(st.nextToken()); // 너비
            input[i][2] = Integer.parseInt(st.nextToken()); // 타겟
        }

        br.close();
    }

}
