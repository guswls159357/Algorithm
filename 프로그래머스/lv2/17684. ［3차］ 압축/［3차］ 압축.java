import java.util.*;

class Solution {
    
    Map<String, Integer> wordMap = new HashMap();
    
    public int[] solution(String msg) {
        
        List<Integer> resultList = new ArrayList();
        initWordMap();
        
        int length = msg.length();
        int numIdx = 27;
        StringBuilder tmp = new StringBuilder();
        
        for(int i = 0 ; i < length ; i++){
            
            tmp.append(msg.charAt(i));
            if(!wordMap.containsKey(tmp.toString())){
                wordMap.put(tmp.toString(), numIdx++);
                tmp.deleteCharAt(tmp.length() - 1);
                resultList.add(wordMap.get(tmp.toString()));
                i--;
                tmp = new StringBuilder();
            }
        }
        
        if(wordMap.containsKey(tmp.toString())){
            resultList.add(wordMap.get(tmp.toString()));
        }else resultList.add(numIdx);
        
        int[] result = new int[resultList.size()];
        
        for(int i = 0 ; i < resultList.size() ; i++){
            result[i] = resultList.get(i);
        }
        
        return result;
    }
    
    public void initWordMap(){
        
        for(int i = 65 ; i <= 90 ; i++){
            wordMap.put(String.valueOf((char)i) , i - 64);
        }
        
    }
}