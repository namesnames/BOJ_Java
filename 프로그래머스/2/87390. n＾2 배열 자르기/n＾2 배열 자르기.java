import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        List<Integer> list = new ArrayList<>();
        int Left = (int)left;
        int Right = (int)right;
        
        for(long i=left; i<=right; i++)
        {
            long R = i / (long)n;
            long C = i % (long)n;
            
            // if(R >= C) list.add(R + 1);
            // else list.add(C + 1);
            list.add((int)Math.max(R+1, C+1));
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++)
        {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}