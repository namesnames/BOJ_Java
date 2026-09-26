import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int N = elements.length;
        
        TreeSet<Integer> ts = new TreeSet<>();
        
        for(int len=1; len<=N; len++)
        {
            for(int i=0; i<N; i++)
            {
                int sum = 0;
                int idx = i;
                
                for(int j=0; j<len; j++)
                {
                    //System.out.print(idx%N + " ");
                    sum += elements[idx%N];
                    idx++;
                }
                //System.out.println();
                ts.add(sum);
            }
        }
        
        answer = ts.size();
        return answer;
    }
}