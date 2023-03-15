import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        int beforeArr[] = new int[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                if(i==0){
                    arr[0] = Integer.parseInt(st.nextToken());
                }
                else if(j==0){
                    arr[0] = beforeArr[0] + Integer.valueOf(st.nextToken());
                }
                else if(j==i){
                    arr[j] = beforeArr[j-1] + Integer.valueOf(st.nextToken());
                }
                else{
                    arr[j] = Math.max(beforeArr[j-1],beforeArr[j]) + Integer.valueOf(st.nextToken());
                }
            }
            beforeArr = arr.clone();
        }

        int max = -11;
        for(int i=0;i<N;i++){
            if(max<arr[i]) max = arr[i];
        }

        System.out.println(max);

    }
}
