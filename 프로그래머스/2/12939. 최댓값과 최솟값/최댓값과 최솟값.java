class Solution {
    public String solution(String s) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        String[] numbers = s.split(" ");
        
        for(String number : numbers){
            int num = Integer.valueOf(number);
            
            if(num < min) min = num;
            if(num > max) max = num;
        }
        
        return min + " " + max;
        
            }
}