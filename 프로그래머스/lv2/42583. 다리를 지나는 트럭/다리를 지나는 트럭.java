import java.util.*;

class Solution {
    
    static class Truck{
        int weight;
        int startTime;
        
        public Truck(int weight, int startTime){
            this.weight = weight;
            this.startTime = startTime;
        }
    }
    
    Queue<Truck> bQueue = new LinkedList();
    Queue<Integer> wQueue = new LinkedList();
    int maxWeight;
    int curWeight;
    int bLength;
    int time;
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        maxWeight = weight;
        bLength = bridge_length;
        initWQueue(truck_weights);
        
        return getMinTime();
    }
    
    public int getMinTime(){
        
        time = 0;
        
        while(time < 1000000){
            time++;
            
            // 시간이 지난 트럭을 제거
            removeIfTimeout();
            
            // 다리에 올라갈 트럭이 있다면 올림
            if(!wQueue.isEmpty()){
                int nextWeight = wQueue.peek();
                if(bQueue.size() < bLength &&
                   nextWeight + curWeight <= maxWeight){
                    curWeight += nextWeight;
                    wQueue.poll();
                    bQueue.add(new Truck(nextWeight ,time));
                }
            }else if(bQueue.isEmpty()) return time;
            
        }
        
        return time;
    }
    
    public void removeIfTimeout(){
        if(bQueue.isEmpty()) return;
        Truck t = bQueue.peek();
        
        if(time - t.startTime == bLength){
            bQueue.poll();
            curWeight -= t.weight;
        }
    }
    
    public void initWQueue(int[] trucks){
        int length = trucks.length;
        for(int i = 0 ; i < length ; i++){
            wQueue.add(trucks[i]);
        }
    }
}