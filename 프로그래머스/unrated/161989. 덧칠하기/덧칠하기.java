class Solution {
    
    public int solution(int n, int m, int[] section) {
        
        int count = 1;
        // 해당 값보다 작으면 구역에 포함
        int nextValue = section[0] + m;
        int length = section.length;
        for(int i = 1 ; i < length ; i++){
            if(section[i] >= nextValue) {
                count++;
                nextValue = section[i] + m;
            }
        }
        
        return count;
    }
    
    
}