class Solution {
    public long[] solution(long n) {
        long tmp = n;
        int digit = 0;
        
        while(true){
            if(tmp==0) break;
            tmp/=10;
            digit++;
        }
        
        long arr [] = new long [digit];
        for(int i=0;i<digit;i++){
            arr[i] = n%10;
            n/=10;
        }
        return arr;
    }
}