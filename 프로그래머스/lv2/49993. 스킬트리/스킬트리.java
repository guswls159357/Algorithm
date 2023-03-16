import java.util.*;

class Solution {
    
    // 현재 스킬들을 검색하기 위한 용도
    HashSet<Character> skillSet = new HashSet();
    // 현재 스킬들을 순서대로 체크하기 위한 용도
    char[] skills;
    
    public int solution(String skill, String[] skill_trees) {
        
        int result = 0;
        init(skill);
        
        for(String skillTree : skill_trees){
            if(isPossible(skillTree)) result++;
        }
        
        return result;
    }
    
    public boolean isPossible(String skillTree){
        
        int length = skillTree.length();
        int curSkillIdx = 0;
        char curC;
        for(int i = 0 ; i < length ; i++){
            curC = skillTree.charAt(i);
            
            if(skillSet.contains(curC)){
                if(skills[curSkillIdx] == curC){
                    curSkillIdx++;
                }else{
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public void init(String skill){
        int length = skill.length();
        skills = new char[length];
        
        char c;
        for(int i = 0 ; i < length ; i++){
            c = skill.charAt(i);
            skills[i] = c;
            skillSet.add(c);
        }
    }
}