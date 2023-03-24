import java.io.*;
import java.util.*;

public class Main {

    static int[] mushroom = new int[10];

    public static void main(String[] args) throws IOException {

        initInput();
        System.out.println(getClosedScoreTo100());
    }

    static int getClosedScoreTo100() {

        int score = mushroom[0];
        for (int i = 1; i < 10; i++) {
            if (Math.abs(score - 100) >= Math.abs(score + mushroom[i] - 100)) {
                score += mushroom[i];
            } else break;
        }

        return score;
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            mushroom[i] = Integer.parseInt(br.readLine());
        }

        br.close();
    }

}
