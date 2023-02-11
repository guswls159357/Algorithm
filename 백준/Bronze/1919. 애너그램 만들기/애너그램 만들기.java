import java.io.*;
import java.util.*;

public class Main {

    static int[] word1Count = new int[26];
    static int[] word2Count = new int[26];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word1 = br.readLine().toCharArray();
        char[] word2 = br.readLine().toCharArray();

        for(char c : word1){
            word1Count[c - 'a']++;
        }

        for(char c : word2){
            word2Count[c - 'a']++;
        }

        int result = 0;

        for (int i = 0; i < 26; i++) {
            result += Math.abs(word1Count[i] - word2Count[i]);
        }

        System.out.println(result);
    }

}
