import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<Character, Integer> map = new TreeMap<>();
        
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            
            if(map.get(c) == null)
            {
                map.put(s.charAt(i), i);
                answer[i] = -1;
            }
            else
            {
                int ori_idx = map.get(c);
                answer[i] = i - ori_idx;
                map.replace(c, i);
            }
        }
        
        return answer;
    }
}