import java.util.*;

class Solution {
    
    Map<String, Integer> countMap = new HashMap();
    Map<String, Integer> wantedMap = new HashMap();
    int count = 0;
    
    public int solution(String[] want, int[] number, String[] discount) {
        
        initWantedMap(want, number);
        initCountMap(discount);
        checkMatch();
        
        int length = discount.length;
        int addedIdx = 10;
        String addedName;
        int removedIdx = 0;
        String removedName;
        
        while(addedIdx < length){
            
            addedName = discount[addedIdx++];
            removedName = discount[removedIdx++];
            
            if(addedName != removedName){
                putToCountMap(addedName);
                deleteToCountMap(removedName);
            }
            
            //printCountMap();
            //printWantedMap();
            checkMatch();
        }
        
        return count;
    }
    
    public void deleteToCountMap(String name){
        if(countMap.containsKey(name)){
            countMap.put(name, countMap.get(name) - 1);
        }
    }
    
    public void putToCountMap(String name){
        if(countMap.containsKey(name)){
            countMap.put(name, countMap.get(name) + 1);
        }else{
            countMap.put(name, 1);
        }
    }
    
    public void printCountMap(){
        System.out.println("countMap");
        for(String name : countMap.keySet()){
            System.out.println("name : " + name + " value : " + countMap.get(name));
        }
        System.out.println();
    }
    
    public void printWantedMap(){
        System.out.println("wantedMap");
        for(String name : wantedMap.keySet()){
            System.out.println("name : " + name + " value : " + wantedMap.get(name));
        }
        System.out.println();
    }
    
    public void checkMatch(){
        
        for(String name : wantedMap.keySet()){
            if(!countMap.containsKey(name)) return;
            else if(countMap.get(name) < wantedMap.get(name)) return;
        }
        
        count++;
    }
    
    public void initCountMap(String[] discount){
        
        // 1부터 10까지 미리 갯수를 세어놓는다.
        for(int i = 0 ; i < 10 ; i++){
            String name = discount[i];
            if(countMap.containsKey(name)){
                countMap.put(name, countMap.get(name) + 1);
            }else{
                countMap.put(name, 1);
            }
        }
    }
    
    public void initWantedMap(String[] want, int[] number){
        
        int length = number.length;
        for(int i = 0 ; i < length ; i++){
            wantedMap.put(want[i], number[i]);
        }
        
    }
}