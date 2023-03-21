class Solution {
    public int[] solution(String[] wallpaper) {
        
        return getPoint(wallpaper);
    }
    
    public int[] getPoint(String[] wallpaper){
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int up = Integer.MAX_VALUE;
        int down = Integer.MIN_VALUE;
        
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        for(int i = 0 ; i < row ; i++){
            String s = wallpaper[i];
            for(int j = 0 ; j < col ; j++){
                if(s.charAt(j) == '#'){
                    up = Math.min(up, i);
                    down = Math.max(down, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }
        
        return new int[]{up, left, down + 1, right + 1};
    }
}