import java.io.*;
import java.util.*;

public class Main {

    static class Point implements Comparable<Point>{
        int row;
        int col;
        int likeCount;
        int emptyCount;

        public Point(int row, int col, int likeCount, int emptyCount) {
            this.row = row;
            this.col = col;
            this.likeCount = likeCount;
            this.emptyCount = emptyCount;
        }


        @Override
        public int compareTo(Point o) {

            if(this.likeCount == o.likeCount){
                if(this.emptyCount == o.emptyCount){
                    if(this.row == o.row){
                        return this.col - o.col;
                    }else return this.row - o.row;
                }else return o.emptyCount - this.emptyCount;
            }

            return o.likeCount - this.likeCount;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", col=" + col +
                    ", likeCount=" + likeCount +
                    ", emptyCount=" + emptyCount +
                    '}';
        }
    }

    static int N;
    static int powerN;
    static int[][] map;
    static List<Integer> order = new ArrayList<>();
    static Map<Integer, Set<Integer>> likeMap = new HashMap<>();
    static int[] dirRow = {1, -1, 0, 0};
    static int[] dirCol = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        initInput();
        for(int sNum : order){
            choose(sNum);
        }
        //print();
        System.out.println(getScore());
    }

    static void choose(int sNum){

        Set<Integer> likeStudents = likeMap.get(sNum);
        PriorityQueue<Point> points = new PriorityQueue<>();

        for(int row = 0 ; row < N ; row++){
            for(int col = 0 ; col < N ; col++){
                if(map[row][col] == 0){
                    int likeCnt = 0;
                    int emptyCnt = 0;
                    for(int dir = 0 ; dir < 4 ; dir++){
                        int nextRow = row + dirRow[dir];
                        int nextCol = col + dirCol[dir];

                        if(checkRange(nextRow, nextCol)){
                            if(map[nextRow][nextCol] == 0) emptyCnt++;
                            if(likeStudents.contains(map[nextRow][nextCol])) likeCnt++;
                        }
                    }
                    points.add(new Point(row, col, likeCnt, emptyCnt));
                }
            }
        }

        Point insertedPoint = points.poll();
        //System.out.println(insertedPoint);
        map[insertedPoint.row][insertedPoint.col] = sNum;
        //while(!points.isEmpty()) System.out.println(points.poll());
    }

    static boolean checkRange(int row, int col){

        return row >= 0 && row < N && col >= 0 && col < N;
    }

    static int getScore(){
        int score = 0;

        for(int row = 0 ; row < N ; row++){
            for(int col = 0 ; col < N ; col++){
                Set<Integer> likeSet = likeMap.get(map[row][col]);
                int cnt = 0;
                for(int dir = 0 ; dir < 4 ; dir++){
                    int nextRow = row + dirRow[dir];
                    int nextCol = col + dirCol[dir];
                    if(checkRange(nextRow, nextCol)){
                        if(likeSet.contains(map[nextRow][nextCol])) cnt++;
                    }
                }
                if(cnt != 0) score += Math.pow(10, cnt - 1);
            }
        }

        return score;
    }

    static void print(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        powerN = N * N;
        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < powerN; i++) {
            st = new StringTokenizer(br.readLine());
            int sNum = Integer.parseInt(st.nextToken());
            order.add(sNum);
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0 ; j < 4 ; j++){
                set.add(Integer.parseInt(st.nextToken()));
            }
            likeMap.put(sNum, set);
        }

        br.close();
    }
}
