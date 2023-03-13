import java.io.*;
import java.util.*;

public class Main {

    static int[][][] w = new int[21][21][21];
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        initMap();

        int a, b, c;
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if ((a == -1 && b == -1 && c == -1)) break;
            writeToResult(a, b, c);
        }

        System.out.println(result);

        br.close();
    }

    static void writeToResult(int a, int b, int c) {

        int resultVal = 0;

        if (a <= 0 || b <= 0 || c <= 0) {
            resultVal = 1;
        } else if (a > 20 || b > 20 || c > 20) {
            resultVal = w[20][20][20];
        } else resultVal = w[a][b][c];

        result.append("w(")
                .append(a)
                .append(", ")
                .append(b)
                .append(", ")
                .append(c)
                .append(") = ")
                .append(resultVal)
                .append("\n");
    }

    static void initMap() {



        for (int a = 0; a <= 20; a++) {
            for (int b = 0; b <= 20; b++) {
                for (int c = 0; c <= 20; c++) {
                    int result = 0;
                    if(a == 0 || b == 0 || c == 0){
                        result = 1;
                    }else if (a < b && b < c) {
                        result = w[a][b][c - 1] + w[a][b - 1][c - 1] - w[a][b - 1][c];
                    } else {
                        result = w[a - 1][b][c] + w[a - 1][b - 1][c] + w[a - 1][b][c - 1] - w[a - 1][b - 1][c - 1];
                    }
                    w[a][b][c] = result;
                }
            }
        }

    }

}
