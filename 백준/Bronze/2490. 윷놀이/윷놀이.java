import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] count = new int[2];
        for(int i = 0 ; i < 3 ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 4 ; j++){
                count[Integer.parseInt(st.nextToken())]++;
            }
            if(count[0] == 0){
                sb.append("E");
            }else if(count[0] == 1){
                sb.append("A");
            }else if(count[0] == 2){
                sb.append("B");
            }else if(count[0] == 3){
                sb.append("C");
            }else{
                sb.append("D");
            }
            sb.append("\n");
            count[0] = 0;
            count[1] = 0;
        }

        System.out.println(sb);

        br.close();
    }


}
