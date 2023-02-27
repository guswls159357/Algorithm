import java.io.*;
import java.util.*;

public class Main {

    static char[] dna = {'A', 'C', 'G', 'T'};
    static Map<Character, Integer> count = new HashMap<>();
    static Map<Character, Integer> minCount = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        init();

        // 총 문자열 길이
        int S = Integer.parseInt(st.nextToken());
        // 연속 문자열 길이
        int P = Integer.parseInt(st.nextToken());
        // 문자열
        char[] DNAs = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i++){
            minCount.put(dna[i], minCount.get(dna[i]) + Integer.parseInt(st.nextToken()));
        }

        int startIdx = 0;
        int endIdx = P - 1;
        int result = 0;

        // 첫 번째 부분 문자열 계산
        for(int i = startIdx ; i <= endIdx ; i++){
            char dnaa = DNAs[i];
            count.put(dnaa, count.get(dnaa)+1);
        }

        boolean over = true;

        for(int i = 0 ; i < 4 ; i++){
            if(count.get(dna[i]) < minCount.get(dna[i])) {
                over = false;
                break;
            }
        }

        if(over) result++;


        // 두 번째 부분 문자열 이후로 계산
        while(endIdx < S - 1){
            char curStartChar = DNAs[startIdx++];
            char addedChar = DNAs[++endIdx];

            count.put(curStartChar, count.get(curStartChar) - 1);
            count.put(addedChar, count.get(addedChar) + 1);

            over = true;
            for(int i = 0 ; i < 4 ; i++){
                if(count.get(dna[i]) < minCount.get(dna[i])) {
                    over = false;
                    break;
                }
            }
            if(over) result++;
        }

        System.out.println(result);

        br.close();
    }

    static void init(){
        count.put('A', 0);
        count.put('C', 0);
        count.put('T', 0);
        count.put('G', 0);

        minCount.put('A', 0);
        minCount.put('C', 0);
        minCount.put('T', 0);
        minCount.put('G', 0);
    }

}
