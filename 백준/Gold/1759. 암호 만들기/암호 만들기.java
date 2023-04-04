import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // L - 암호의 길이 , C - 가능한 문자들
    static int L, C;
    static char[] chars;
    static StringBuilder sb = new StringBuilder();


    // 최소 1개의 모음, 최소 2개의 자음
    // a c i
    public static void main(String[] args) throws IOException {

        initInput();

        dfs(0, 0, 0, new char[L]);
        System.out.println(sb);
    }

    static void dfs(int depth, int idx, int moumCnt, char[] result) {

        if (depth == L) {
            if (moumCnt >= 1 && L - moumCnt >= 2) {
                for (char c : result) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        if (idx == C) return;

        // 현재 글자 선택
        result[depth] = chars[idx];
        if (isMoum(chars[idx])) dfs(depth + 1, idx + 1, moumCnt + 1, result);
        else dfs(depth + 1, idx + 1, moumCnt, result);
        // 현재 글자 선택 안함
        dfs(depth, idx + 1, moumCnt, result);
    }

    static boolean isMoum(char c) {

        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);
       // System.out.println(chars);

        br.close();
    }
}
