import java.io.*;

public class Main {

    static char[][] map = new char[5][15];

    public static void main(String[] args) throws IOException {

        initInput();
        printAnswer();

    }

    static void printAnswer() {

        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < 15; col++) {
            for (int row = 0; row < 5; row++) {
                if (map[row][col] != '\0') {
                    sb.append(map[row][col]);
                }
            }
        }
        System.out.println(sb);
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            int length = s.length();

            for (int j = 0; j < length; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        br.close();
    }

}