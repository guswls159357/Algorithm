import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 포켓몬 갯수
        int M = Integer.parseInt(st.nextToken()); // 문제 갯수

        Map<String, String> pokemon = new HashMap<>();

        String name;
        String idx;
        for(int i = 1 ; i <= N ; i++){
            name = br.readLine();
            idx = String.valueOf(i);
            pokemon.put(idx, name);
            pokemon.put(name, idx);
        }

        for(int i = 0 ; i < M ; i++){
            sb.append(pokemon.get(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }
}
