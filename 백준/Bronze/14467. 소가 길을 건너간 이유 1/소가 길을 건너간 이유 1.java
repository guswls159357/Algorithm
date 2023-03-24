import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        Map<String, String> map = new HashMap<>();

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            String cowNum = st.nextToken();
            String pos = st.nextToken();

            if(map.containsKey(cowNum) && !map.get(cowNum).equals(pos)){
                count++;
            }

            map.put(cowNum, pos);
        }

        System.out.println(count);

        br.close();
    }

}
