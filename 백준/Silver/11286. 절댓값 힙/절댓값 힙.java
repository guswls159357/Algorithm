import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (num1, num2) -> {
                    int diff = Math.abs(num1) - Math.abs(num2);
                    if (diff > 0) return 1;
                    else if (diff < 0) return -1;
                    else {
                        if (num1 < num2) return -1;
                        else return 1;
                    }
                }
        );

        String tmp;
        for(int i = 0 ; i < N ; i++){
            tmp = br.readLine();

            if(tmp.equals("0")){
                if(priorityQueue.isEmpty()){
                    result.append("0").append("\n");
                }else result.append(priorityQueue.poll()).append("\n");
            }else{
                priorityQueue.add(Integer.valueOf(tmp));
            }
        }

        System.out.println(result);

        br.close();
    }

}
