import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int N;
    public static char[][] arr;
    public static boolean[][] isVisit;
    public static int region = 0;

    public static int[] directionX = {1, -1, 0, 0};
    public static int[] directionY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new char[N + 1][N + 1];
        isVisit = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                arr[i][j] = s.charAt(j - 1);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (isVisit[i][j]) continue;
                move(i, j, arr[i][j]);
                region++;
            }
        }

        sb.append(region + " ");

        region = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 'G') arr[i][j] = 'R';
                isVisit[i][j] = false;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (isVisit[i][j]) continue;
                move(i, j, arr[i][j]);
                region++;
            }
        }

        sb.append(region);

        System.out.println(sb);


    }

    public static void move(int x, int y, char color) {

        isVisit[x][y] = true;

        for (int i = 0; i < 4; i++) {

            int moveX = x + directionX[i];
            int moveY = y + directionY[i];

            if (isPossible(moveX, moveY) && arr[moveX][moveY] == color) {
                move(moveX, moveY, color);
            }
        }

    }


    public static boolean isPossible(int x, int y) {

        if (x < 1 || x > N || y < 1 || y > N) return false;

        if (isVisit[x][y]) return false;

        return true;
    }
}
