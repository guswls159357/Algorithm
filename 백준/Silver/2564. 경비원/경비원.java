import java.io.*;
import java.util.*;

public class Main {

    static int width, height, round;
    static int N;
    static int[][] points;
    static int startDir;
    static int startLength;

    public static void main(String[] args) throws IOException {

        initInput();

        int sum = 0;
        for(int i = 0 ; i < N ; i++){

            sum += minDistance(startDir, startLength, points[i][0], points[i][1]);
        }

        System.out.println(sum);
    }


    static int minDistance(int dir1, int length1, int dir2, int length2){

        if(dir1 == dir2){
            return Math.abs(length1-length2);
        }else if(dir1 > dir2){
            int dirTmp = dir1;
            dir1 = dir2;
            dir2 = dirTmp;

            int lengthTmp = length1;
            length1 = length2;
            length2 = lengthTmp;
        }

        if(dir1 == 1){
            // 북쪽, 남쪽
            if(dir2 == 2){
                int first = height + length1 + length2;
                return Math.min(first, round - first);
            } // 북쪽, 서쪽
            else if(dir2 == 3){
                return length1 + length2;
            } // 북쪽, 동쪽
            else{
                return width - length1 + length2;
            }
        }else if(dir1 == 2){
            if(dir2 == 3){
                // 남쪽, 서쪽
                return length1 + height - length2;
            }else{
                // 남쪽, 동쪽
                return width - length1 + height - length2;
            }
        }else{
            // dir2 == 4
            // 서쪽, 동쪽
            int first = width + length1 + length2;
            return Math.min(first, round - first);
        }

    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        round = 2 * width + 2 * height;
        N = Integer.parseInt(br.readLine());
        points = new int[N][2];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());

            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        startDir = Integer.parseInt(st.nextToken());
        startLength = Integer.parseInt(st.nextToken());

        br.close();
    }

}
