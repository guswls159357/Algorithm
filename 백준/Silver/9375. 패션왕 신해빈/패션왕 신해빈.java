import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int N;
        String clothes[];
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < T ; i++){
            N = Integer.parseInt(br.readLine());
            clothes = new String[N];

            for(int j = 0 ; j < N ; j++){
                clothes[j] = br.readLine().split(" ")[1];
            }

            if(i == T - 1){
                sb.append(comb(N, clothes));
            }else{
                sb.append(comb(N, clothes)).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int comb(int N, String[] clothes){

        Map<String, Integer> countMap = new HashMap<>();

        for(int i = 0 ; i < N ; i++){
            if(countMap.containsKey(clothes[i])){
                countMap.put(clothes[i], countMap.get(clothes[i]) + 1);
            }else{
                countMap.put(clothes[i], 1);
            }
        }

        int result = 1;
        for(String key : countMap.keySet()){
            result *= countMap.get(key) + 1;
        }

        return result - 1;
    }

}
