import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int[][] input;

    public static void main(String[] args) throws IOException {

        StringBuilder result = new StringBuilder();
        initInput();

        for (int i = 0; i < T; i++) {
            result.append(getPossiblePositionCount(i)).append("\n");
        }

        System.out.println(result);
    }

    static int getPossiblePositionCount(int T) {

        int x1 = input[T][0];
        int y1 = input[T][1];
        int r1 = input[T][2];
        int x2 = input[T][3];
        int y2 = input[T][4];
        int r2 = input[T][5];

        if(x1 == x2 && y1 == y2){
            if(r1 == r2){
                if(r1 == 0) return 1;
                return -1;
            }
        }

        // 원의 중심끼리의 거리
        double distance = Math.sqrt(
                Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)
        );

        // 내접하거나 외접할 때
        if (distance == r1 + r2 || distance == Math.abs(r1 - r2)) {
            return 1;
        }// 한 원이 다른 원의 내부에 있거나 아예 각자 외부에 존재할 때
        else if (distance > r1 + r2 || distance < Math.abs(r1 - r2)) {
            return 0;
        } else return 2;
    }


    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        input = new int[T][6];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            input[i][2] = Integer.parseInt(st.nextToken());
            input[i][3] = Integer.parseInt(st.nextToken());
            input[i][4] = Integer.parseInt(st.nextToken());
            input[i][5] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

}
