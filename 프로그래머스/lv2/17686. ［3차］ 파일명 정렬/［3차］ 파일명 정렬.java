import java.util.*;

class Solution {
    
    static class File implements Comparable<File>{
        
        int idx;
        String head;
        int number;
        
        public File(int idx, String head, int number){
            this.idx = idx;
            this.head = head;
            this.number = number;
        }
        
        @Override
        public int compareTo(File f) {
            String thisHead = this.head.toUpperCase();
            String fHead = f.head.toUpperCase();
            if(this.head.toUpperCase().equals(f.head.toUpperCase())){
                
                if(this.number == f.number){
                    return this.idx - f.idx;
                }
                return this.number - f.number;
            }
            return thisHead.compareTo(fHead);
        }
    }
    
    public String[] solution(String[] files) {
        
        List<File> list = new ArrayList();
        int length = files.length;
        String[] answer = new String[length];
        for(int i = 0 ; i < length ; i++){
            String file = files[i];
            list.add(stringToFile(file, i));
        }
        
        Collections.sort(list);
        
        for(int i = 0 ; i < length ; i++){
            File f = list.get(i);
            answer[i] = files[f.idx];
        }
        
        
        return answer;
    }
    
    public File stringToFile(String file, int idx){
        
        StringBuilder sb = new StringBuilder();
        String head;
        String number;
        int length = file.length();
        int count = length - 1;
        for(int i = 0 ; i < length ; i++){
            char c = file.charAt(i);
            if('0' <= c && c <= '9') {
                count = i;
                break;
            }else sb.append(c);
        }
        head = sb.toString();
        
        sb = new StringBuilder();
        for(int i = count ; i < length ; i++){
            char c = file.charAt(i);
            if('0' <= c && c <= '9'){
                sb.append(c);
            }else break;
        }
        number = sb.toString();
        
        return new File(idx, head, Integer.parseInt(number));
    }
}