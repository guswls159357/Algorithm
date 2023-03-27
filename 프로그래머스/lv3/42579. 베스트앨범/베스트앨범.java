import java.util.*;

class Solution {
    
    static class Song implements Comparable<Song>{
        int idx;
        int play;
        
        public Song(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song s){
            if(this.play == s.play) return this.idx - s.idx;
            return s.play - this.play;
        }
        
        @Override
        public String toString(){
            return String.valueOf(this.play);
        }
    }
    
    // 장르의 우선 순위를 알기 위해
    Map<String, Integer> genreCountMap = new HashMap();
    
    Map<String, List<Song>> genreMap = new HashMap();
    
    public int[] solution(String[] genres, int[] plays) {
        
        int length = genres.length;
        for(int idx = 0 ; idx < length ; idx++){
            
            String genre = genres[idx];
            int play = plays[idx];
            addToGenreCountMap(genre, play);
            addToGenreMap(genre, play, idx);
        }
        
        List<Integer> resultList = new ArrayList();
        List<Map.Entry<String, Integer>> entryList = new LinkedList(genreCountMap.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        
        for(Map.Entry<String, Integer> entry : entryList){
            List<Song> songs = genreMap.get(entry.getKey());
            Collections.sort(songs);
            
            resultList.add(songs.get(0).idx);
            if(songs.size() >= 2){
                resultList.add(songs.get(1).idx);
            }
        }

        int[] answer = new int[resultList.size()];
        for(int i = 0 ; i < resultList.size() ; i++){
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
    
    public void addToGenreCountMap(String genre, int play){
        
        genreCountMap.put(genre, genreCountMap.getOrDefault(genre, 0) + play);
    }
    
    public void addToGenreMap(String genre, int play, int idx){
        
        if(genreMap.containsKey(genre)){
            genreMap.get(genre).add(new Song(idx, play));
        }else{
            List<Song> tmp = new ArrayList();
            tmp.add(new Song(idx, play));
            genreMap.put(genre, tmp);
        }
    }
}