import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int [] score;
    public static int [] max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        score = new int[N+1];
        max = new int[N+1];

        for(int i=1;i<=N;i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        max[1] = score[1];

        if(N>=2){
            max[2] = score[1]+score[2];
        }

        for(int i=3;i<=N;i++){
            max[i] = Math.max(max[i-2],max[i-3]+score[i-1]) + score[i];
        }

        System.out.println(max[N]);


    }
}
