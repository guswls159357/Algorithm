import java.io.*;

public class Main {

    public static int[][] arr;
    public static int[] values;
    public static int size;
    public static int maxIdx;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        values = new int[size];

        maxIdx=0;

        for(int i=0;i<size;i++){
            values[i] = Integer.valueOf(br.readLine());
            if(values[i]>maxIdx) maxIdx = values[i];
        }

        arr = new int[maxIdx+1][3];

        dp();

    }

    public static void dp() throws IOException {

        int index = 0;

        while (true) {

            if (index == 0) {
                arr[index][1] = 1;
                arr[index][2] = 0;
            }
            else if(index == 1){
                arr[index][1] = 0;
                arr[index][2] = 1;
            }
            else{
                arr[index][1] = arr[index-2][1]+arr[index-1][1];
                arr[index][2] = arr[index-2][2]+arr[index-1][2];
            }

            if(index==maxIdx){
                for(int i=0;i<size;i++){
                    bw.write(arr[values[i]][1]+" "+arr[values[i]][2]+"\n");
                }
                bw.flush();
                bw.close();
                return;
            }


            index++;

        }

    }
}
