import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int max = Integer.MIN_VALUE;
    static int[][] map;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        initInput();
        dfs(0, map);
        System.out.println(max);
    }

    static void dfs(int depth, int[][] map) {

        if (depth == 5) {
            updateMax(map);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            dfs(depth + 1, move(map, dir));
        }

    }

    // 상, 하, 좌, 우
    static int[][] move(int[][] origin, int dir) {

        int[][] tmpMap = cloneMap(origin);
        queue.clear();

        if (dir == 0) {
            // 상
            for (int col = 0; col < N; col++) {
                for (int row = 0; row < N; row++) {
                    if (tmpMap[row][col] != 0) {
                        queue.add(tmpMap[row][col]);
                        tmpMap[row][col] = 0;
                    }
                }

                int row = 0;
                while (!queue.isEmpty()) {
                    int poll = queue.poll();

                    if (tmpMap[row][col] == 0) {
                        tmpMap[row][col] = poll;
                    } else if (tmpMap[row][col] == poll) {
                        tmpMap[row++][col] *= 2;
                    } else {
                        tmpMap[++row][col] = poll;
                    }
                }
            }
        } else if (dir == 1) {
            // 하
            for (int col = 0; col < N; col++) {
                for (int row = N - 1; row >= 0; row--) {
                    if (tmpMap[row][col] != 0) {
                        queue.add(tmpMap[row][col]);
                        tmpMap[row][col] = 0;
                    }
                }

                int row = N - 1;
                while (!queue.isEmpty()) {
                    int poll = queue.poll();

                    if (tmpMap[row][col] == 0) {
                        tmpMap[row][col] = poll;
                    } else if (tmpMap[row][col] == poll) {
                        tmpMap[row--][col] *= 2;
                    } else {
                        tmpMap[--row][col] = poll;
                    }
                }
            }
        } else if (dir == 2) {
            // 우
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (tmpMap[row][col] != 0) {
                        queue.add(tmpMap[row][col]);
                        tmpMap[row][col] = 0;
                    }
                }

                int col = 0;
                while (!queue.isEmpty()) {
                    int poll = queue.poll();

                    if (tmpMap[row][col] == 0) {
                        tmpMap[row][col] = poll;
                    } else if (tmpMap[row][col] == poll) {
                        tmpMap[row][col++] *= 2;
                    } else {
                        tmpMap[row][++col] = poll;
                    }
                }
            }

        } else {
            // 좌
            for (int row = 0; row < N; row++) {
                for (int col = N - 1; col >= 0; col--) {
                    if (tmpMap[row][col] != 0) {
                        queue.add(tmpMap[row][col]);
                        tmpMap[row][col] = 0;
                    }
                }

                int col = N - 1;
                while (!queue.isEmpty()) {
                    int poll = queue.poll();

                    if (tmpMap[row][col] == 0) {
                        tmpMap[row][col] = poll;
                    } else if (tmpMap[row][col] == poll) {
                        tmpMap[row][col--] *= 2;
                    } else {
                        tmpMap[row][--col] = poll;
                    }
                }
            }
        }

        return tmpMap;
    }

    static int[][] cloneMap(int[][] map) {

        int[][] tmpMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            tmpMap[i] = Arrays.copyOf(map[i], N);
        }

        return tmpMap;
    }

    static void updateMax(int[][] map) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > max) max = map[i][j];
            }
        }

    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
    }
}
