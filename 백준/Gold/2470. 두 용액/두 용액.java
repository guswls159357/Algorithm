import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    static int[] result = new int[2];

    public static void main(String[] args) throws IOException {

        initInput();
        getResult();
        System.out.println(result[0] + " " + result[1]);
    }

    static void getResult() {

        int start = 0;
        int end = N - 1;
        int sum = 0;

        while(start < end){
            sum = arr[start] + arr[end];

            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                result[0] = arr[start];
                result[1] = arr[end];
            }

            if(sum < 0) start++;
            else if(sum > 0) end--;
            else{
                break;
            }
        }
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        br.close();
    }
}
