import java.util.*;

class Solution {
    
    // 길이, 문자열, 반복 횟수
    Map<Integer, Map<String, Integer>> resultMap = new HashMap();
    List<String> result = new ArrayList();
    List<Character> charList;
    String[] orders;
    
    public String[] solution(String[] orderss, int[] course) {
        orders = orderss;
        init();
        for(int cnt : course){
            Map<String, Integer> tmp = new HashMap();
            resultMap.put(cnt, tmp);
            dfs(new char[cnt], 0, cnt, 0);
            
            int max = 0;
            Map<String, Integer> cntMap = resultMap.get(cnt);
            for(int value : cntMap.values()){
                if(max < value) max = value;   
            }
            
            for(String key : cntMap.keySet()){
                if(cntMap.get(key) == max) result.add(key);
            }
        }
        
        Collections.sort(result);
        
        String[] answer = new String[result.size()];
        int idx = 0;
        for(String s : result){
            answer[idx++] = s;
        }
        return answer;
    }
    
    void init(){
        Set<Character> set = new HashSet();
        for(String s : orders){
            int length = s.length();
            for(int i = 0 ; i < length ; i++){
                set.add(s.charAt(i));
            }
        }
        charList = new ArrayList(set);
    }
    
    void check(char[] chars){
        
        int length = chars.length;
        int count = 0;
        for(String s : orders){
            boolean flag = true;
            for(char c : chars){
                if(s.indexOf(c) == -1){
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        
        if(count >= 2){
            resultMap.get(length).put(String.valueOf(chars), count);
        }
    }
    
    void dfs(char[] chars, int start, int r, int depth){
        if(r == 0){
            check(chars);
            return;
        }
        
        for(int i = start ; i < charList.size() ; i++){
            chars[depth] = charList.get(i);
            dfs(chars, i + 1, r - 1, depth + 1);
            chars[depth] = '\u0000';
        }
    }
}