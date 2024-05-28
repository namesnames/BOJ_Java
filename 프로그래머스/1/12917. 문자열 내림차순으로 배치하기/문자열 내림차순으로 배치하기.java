import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] list = s.split("");
        Arrays.sort(list, Collections.reverseOrder());
        
        for(String l:list){
            answer += l;
        }
        return answer;
    }
}