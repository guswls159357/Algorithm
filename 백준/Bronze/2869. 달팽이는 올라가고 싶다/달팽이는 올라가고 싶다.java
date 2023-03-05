import java.io.*;
import java.util.*;

public class Main {

    static int A, B, V;

    public static void main(String[] args) throws IOException {

        initInput();

        System.out.println(getDay());
    }

    static int getDay(){

        // 1일차 -> 0 ~ A / 마지막엔 A - B
        // 2일차 -> A ~ 2 * A - B / 마지막엔 2 * A - 2 * B
        // 3일차 -> 2 * A - B ~ 3 * A - 2 * B / 마지막엔 3 * A - 3 * B

        // 전체에서 A를 빼준다고 생각하자
        // 1일차 -> -A <=  <= 0
        // 2일차 -> 0 <  <= (A - B)
        // 3일차 -> (A - B) <  <= 2 * (A - B)

        if((V - A) % (A - B) == 0){
            return (V - A) / (A - B) + 1;
        } else return (V - A) / (A - B) + 2;
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        br.close();
    }

}
