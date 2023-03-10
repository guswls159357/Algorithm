class Solution {
    
    static int[] visited;
    
    public int solution(String[][] book_time) {
        
        int maxMinute = 60 * 24 + 11;
        visited = new int[maxMinute];
        
        String start, end;
        int length = book_time.length;
        for(int i = 0 ; i < length ; i++){
            start = book_time[i][0];
            end = book_time[i][1];
            
            checkVisited(convertToMinute(start), convertToMinute(end) + 9);
        }
        
        int max = 0;
        for(int i = 0 ; i < maxMinute ; i++){
            if(visited[i] > max) max = visited[i];
        }
        
        return max;
    }
    
    public int convertToMinute(String time){
        String[] split = time.split(":");
        
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    public void checkVisited(int start, int end){
        
        for(int i = start ; i <= end ; i++){
            visited[i]++;
        }
    }
}