import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] lines;
    static int maxWidth;
    static int maxHeight;
    static int fullArea;

    public static void main(String[] args) throws IOException {

        initInput();

        System.out.println(getMax());
    }

    public static int getMax() {

        // 서 -> 북 2 4
        // 남 -> 서 3 2
        // 북 -> 동 4 1
        // 동 -> 남 1 3

        for (int i = 0 ; i < 6; i++) {

            int curDir = 0;
            int beforeDir = 0;
            int curLength = 0;
            int beforeLength = 0;
            if(i == 0){
                curDir = lines[0][0];
                beforeDir = lines[5][0];
                curLength = lines[0][1];
                beforeLength = lines[5][1];
            }else{
                curDir = lines[i][0];
                beforeDir = lines[i - 1][0];
                curLength = lines[i][1];
                beforeLength = lines[i-1][1];
            }

            if ((beforeDir == 2 && curDir == 4) ||
                    (beforeDir == 3 && curDir == 2) ||
                    (beforeDir == 4 && curDir == 1) ||
                    (beforeDir == 1 && curDir == 3)) {
                return N * (fullArea - curLength * beforeLength);
            }
        }

        return -1;
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        lines = new int[6][2];

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());

            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());

            if(lines[i][0] == 1 || lines[i][0] == 2){
                if(maxWidth < lines[i][1]) maxWidth = lines[i][1];
            }else{
                if(maxHeight < lines[i][1]) maxHeight = lines[i][1];
            }
        }

        fullArea = maxHeight * maxWidth;

        br.close();
    }

}
