import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        initInput();

        System.out.println(getMax());
    }

    static int getMax(){

        int startIdx = 0;
        int max = 0;

        for(int i = 1 ; i < N ; i++){
            if(arr[i-1] >= arr[i]){
                if(max < arr[i-1] - arr[startIdx]){
                    max = arr[i-1] - arr[startIdx];
                }
                startIdx = i;
            }
        }

        if(startIdx != N - 1 && max < arr[N-1] - arr[startIdx]){
            max = arr[N - 1] - arr[startIdx];
        }

        return max;
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

}
