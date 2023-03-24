import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        Map<String, Integer> map1 = new HashMap();
        Map<String, Integer> map2 = new HashMap();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        int length1 = str1.length();
        int length2 = str2.length();
        
        // 각 문자열을 2글자로 나누어 맵에 넣는다.
        for(int i = 1 ; i < length1 ; i++){
            String tmp1 = str1.substring(i-1, i+1);
            
            char c1 = tmp1.charAt(0);
            char c2 = tmp1.charAt(1);
            if('A' <= c1 && c1 <= 'Z' && 'A' <= c2 && c2 <= 'Z'){
                map1.put(tmp1, map1.getOrDefault(tmp1, 0) + 1);
            }
        }
        
        for(int i = 1 ; i < length2 ; i++){
            String tmp2 = str2.substring(i-1, i+1);
            
            char c3 = tmp2.charAt(0);
            char c4 = tmp2.charAt(1);
            if('A' <= c3 && c3 <= 'Z' && 'A' <= c4 && c4 <= 'Z'){
                map2.put(tmp2, map2.getOrDefault(tmp2, 0) + 1);
            }
        }
        
        
        if(map1.isEmpty() && map2.isEmpty()) return 65536;
        
        int sum = 0;
        int disjoint = 0;
        
        // 합집합, 교집합의 갯수를 구한다.
        for(String key : map1.keySet()){
            if(map2.containsKey(key)){
                int cnt1 = map1.get(key);
                int cnt2 = map2.get(key);
                sum += Math.max(cnt1, cnt2);
                disjoint += Math.min(cnt1, cnt2);
            }else sum += map1.get(key);
        }
        
        for(String key : map2.keySet()){
            if(!map1.containsKey(key)){
                sum += map2.get(key);
            }
        }
        
        //System.out.println(65536 * disjoint / sum);
        
        
        return (int)(65536 * disjoint / sum);
    }
}