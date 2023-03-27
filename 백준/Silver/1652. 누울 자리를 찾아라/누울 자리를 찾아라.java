import java.io.*;
import java.util.*;

public class Main {

    static int N, rowCnt, colCnt;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {

        initInput();
        for (int i = 0; i < N; i++) {
            checkRow(i);
            checkCol(i);
        }

        System.out.print(rowCnt + " " + colCnt);
    }

    static void checkRow(int row) {

        int totalCount = 0;
        int count = 0;
        for (int col = 0; col < N; col++) {
            if (map[row][col]) {
                count++;
            } else {
                if (count >= 2) totalCount++;
                count = 0;
            }
        }
        if (count >= 2) totalCount++;
        rowCnt += totalCount;
    }

    static void checkCol(int col) {

        int totalCount = 0;
        int count = 0;
        for (int row = 0; row < N; row++) {
            if (map[row][col]) {
                count++;
            } else {
                if (count >= 2) totalCount++;
                count = 0;
            }
        }
        if (count >= 2) totalCount++;
        colCnt += totalCount;
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) == '.';
            }
        }

        br.close();
    }

}

