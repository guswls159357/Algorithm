import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] max;

    public static void main(String[] args) throws IOException {

        initInput();
        System.out.println(getMax());

    }

    static int getMax(){

        max[0] = 1;

        for(int i = 1 ; i < N ; i++){
            int maxIdx = i;
            for(int before = i - 1 ; before >= 0 ; before--){
                if(arr[i] > arr[before] && max[maxIdx] < max[before]){
                    maxIdx = before;
                }
            }

            if(maxIdx == i) max[i] = 1;
            else max[i] = max[maxIdx] + 1;
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; i++){
            if(maxVal < max[i]) maxVal = max[i];
        }
        
        return maxVal;
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        max = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

}
