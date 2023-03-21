import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 상, 우, 하, 좌
    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, 1, 0, -1};
    static int curDir = 1;
    static int N, K, L;
    static int curTime;
    static Deque<Point> deque = new LinkedList<>();
    static boolean[][] visited;
    static boolean[][] apple;
    static Map<Integer, Character> timeMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        apple = new boolean[N][N];
        deque.add(new Point(0, 0));

        // 사과 위치 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            apple[row][col] = true;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char rotateDir = st.nextToken().charAt(0);
            timeMap.put(time, rotateDir);
        }

        move();

        br.close();
    }

    static void move() {

        while (curTime < 10000000) {

            // 머리 부분
            Point head = deque.peekLast();
            int nextX = head.x + dirX[curDir];
            int nextY = head.y + dirY[curDir];

            // 다음 위치가 갈 수 있는 위치인지 체크
            if (!rangeCheck(nextX, nextY)) {
                System.out.println(curTime + 1);
                System.exit(0);
            }

            // 다음 위치로 몸을 늘린다.
            deque.addLast(new Point(nextX, nextY));
            visited[nextX][nextY] = true;

            // 다음 위치에 사과가 있었다면
            if (apple[nextX][nextY]) apple[nextX][nextY] = false;
            else {
                Point tail = deque.pollFirst();
                visited[tail.x][tail.y] = false;
            }

            curTime++;
            if (timeMap.containsKey(curTime)) {
                rotate(timeMap.get(curTime));
            }
        }

    }

    static boolean rangeCheck(int x, int y) {
        if (x < 0 || y < 0 || N <= x || N <= y) return false;
        return !visited[x][y];
    }

    static void rotate(char rotateDir) {

        if (rotateDir == 'L') {
            curDir = curDir == 0 ? 3 : curDir - 1;
        } else {
            curDir = curDir == 3 ? 0 : curDir + 1;
        }
    }

}

