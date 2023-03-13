import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String START = st.nextToken();
        String END = st.nextToken();
        String QEND = st.nextToken();

        Set<String> before = new HashSet<>();
        Set<String> after = new HashSet<>();
        Set<String> nameSet = new HashSet<>();
        String input = null;
        
        while((input = br.readLine()) != null) {
            String[] arr = input.split(" ");
            String time = arr[0];
            String name = arr[1];

            nameSet.add(name);
            if(START.compareTo(time) >= 0) {
                before.add(name);
            }else if(END.compareTo(time) <= 0 && QEND.compareTo(time) >= 0) {
                after.add(name);
            }
        }

        int ans = 0;
        for(String name : nameSet) {
            if(before.contains(name) && after.contains(name)) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}