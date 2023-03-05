import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String s = br.readLine();
            int check = 0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j) == '(') check++;
                else check--;
                if(check<0){
                    sb.append("NO\n");
                    break;}
            }
            if(check==0) sb.append("YES\n");
            else if(check>0) sb.append("NO\n");

        }

        System.out.println(sb);
    }
}
