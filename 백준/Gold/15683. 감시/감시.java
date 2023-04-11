import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, M;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static List<Point> cctvs = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        initInput();
        dfs(0, map);

        System.out.println(min);
    }

    static void dfs(int depth, int[][] tmpMap) {

        if (depth == cctvs.size()) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tmpMap[i][j] == 0) cnt++;
                }
            }
            if (cnt < min) min = cnt;
            return;
        }

        Point p = cctvs.get(depth);
        int row = p.row;
        int col = p.col;

        for (int dir = 0; dir <= 3; dir++) {
            int[][] copyMap = copyMap(tmpMap);
            drawCCTV(row, col, map[row][col], dir, copyMap);
            dfs(depth + 1, copyMap);
        }

    }

    static void drawCCTV(int row, int col, int cctv, int dir, int[][] tmpMap) {

        if (cctv == 1) {
            draw(row, col, dir, tmpMap);
        } else if (cctv == 2) {
            draw(row, col, dir, tmpMap);
            draw(row, col, dir >= 2 ? dir - 2 : dir + 2, tmpMap);
        } else if (cctv == 3) {
            draw(row, col, dir, tmpMap);
            draw(row, col, dir == 3 ? 0 : dir + 1, tmpMap);
        } else if (cctv == 4) {
            for (int i = 0; i < 3; i++) {
                draw(row, col, dir + i > 3 ? dir + i - 4 : dir + i, tmpMap);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                draw(row, col, i, tmpMap);
            }
        }

    }

    // 해당 방향을 모두 칠한다.
    static void draw(int row, int col, int dir, int[][] tmpMap) {

        // 0, 1, 2, 3
        // 동, 남, 서, 북
        if (dir == 0) {
            for (int i = 1; i < M; i++) {
                int nextCol = col + i;
                if (nextCol >= M || tmpMap[row][nextCol] == 6) break;
                else if (tmpMap[row][nextCol] == 0) {
                    tmpMap[row][nextCol] = -1;
                }
            }
        } else if (dir == 1) {
            for (int i = 1; i < N; i++) {
                int nextRow = row + i;
                if (nextRow >= N || tmpMap[nextRow][col] == 6) break;
                else if (tmpMap[nextRow][col] == 0) {
                    tmpMap[nextRow][col] = -1;
                }
            }
        } else if (dir == 2) {
            for (int i = 1; i < M; i++) {
                int nextCol = col - i;
                if (nextCol < 0 || tmpMap[row][nextCol] == 6) break;
                else if (tmpMap[row][nextCol] == 0) {
                    tmpMap[row][nextCol] = -1;
                }
            }
        } else {
            for (int i = 1; i < N; i++) {
                int nextRow = row - i;
                if (nextRow < 0 || tmpMap[nextRow][col] == 6) break;
                else if (tmpMap[nextRow][col] == 0) {
                    tmpMap[nextRow][col] = -1;
                }
            }
        }

    }

    static int[][] copyMap(int[][] map) {
        int[][] tmp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        return tmp;
    }

    static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) cctvs.add(new Point(i, j));
            }
        }

        br.close();
    }


}
