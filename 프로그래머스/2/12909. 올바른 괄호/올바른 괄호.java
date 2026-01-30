import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> dq = new ArrayDeque<>();
        dq.add(s.charAt(0));
        
        for(int i=1; i<s.length(); i++)
        {    
            if(!dq.isEmpty())
            {
                char c = dq.getLast();
                if(c == '(')
                {
                    if(s.charAt(i) == ')') 
                    {
                        dq.pollLast();
                        continue;
                    }
                }
            }
            
            dq.add(s.charAt(i));
        }
        
        if(dq.size() == 0) answer = true;
        else answer = false;

        return answer;
    }
}