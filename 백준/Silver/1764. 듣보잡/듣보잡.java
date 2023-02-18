import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        Set<String> notListen = new HashSet<>();
        Set<String> resultSet = new TreeSet<>();

        for(int i = 0 ; i < N ; i++){
            notListen.add(br.readLine());
        }

        String tmp;
        for(int i = 0 ; i < M ; i++){
            tmp = br.readLine();
            if(notListen.contains(tmp)){
                count++;
                resultSet.add(tmp);
            }
        }

        sb.append(count).append("\n");
        for(String s : resultSet){
            sb.append(s).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
