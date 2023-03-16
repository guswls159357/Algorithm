import java.util.*;

class Solution {
    
    int curX = 0, curY = 0;
    int beforeX = 0, beforeY = 0;
    // U, D, R, L
    int[] dirX = {0, 0, 1, -1};
    int[] dirY = {1, -1, 0, 0};
    Set<String> pathSet = new HashSet();
    
    public int solution(String dirs) {
        
        int length = dirs.length();
        for(int i = 0 ; i < length ; i++){
            calcNextPoint(dirs.charAt(i));
            System.out.println(curX + " " + curY);
            addToSet();
        }
        
        return pathSet.size();
    }
    
    public void addToSet(){
        
        StringBuilder naturalOrder = new StringBuilder();
        naturalOrder.append(beforeX);
        naturalOrder.append(beforeY);
        naturalOrder.append(curX);
        naturalOrder.append(curY);
        
        StringBuilder reverseOrder = new StringBuilder();
        reverseOrder.append(curX);
        reverseOrder.append(curY);
        reverseOrder.append(beforeX);
        reverseOrder.append(beforeY);
        
        if(!pathSet.contains(naturalOrder.toString()) && 
           !pathSet.contains(reverseOrder.toString())){
            pathSet.add(naturalOrder.toString());
        }
    }
    
    public void calcNextPoint(char dir){
        
        
        int dirIdx;
        
        if(dir == 'U'){
            dirIdx = 0;
        }else if(dir == 'D'){
            dirIdx = 1;
        }else if(dir == 'R'){
            dirIdx = 2;
        }else{
            dirIdx = 3;
        }
        
        int nextX = curX + dirX[dirIdx];
        int nextY = curY + dirY[dirIdx];
        if(nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5) return;
        
        beforeX = curX;
        beforeY = curY;
        curX += dirX[dirIdx];
        curY += dirY[dirIdx];
        
    }
}