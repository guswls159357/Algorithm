import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Set<String> enteredSet = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if(status.equals("enter")){
                enteredSet.add(name);
            }else{
                enteredSet.remove(name);
            }
        }

        enteredSet.stream().sorted(Collections.reverseOrder())
                        .forEach(name -> result.append(name).append("\n"));

        System.out.println(result);

        br.close();
    }

}
