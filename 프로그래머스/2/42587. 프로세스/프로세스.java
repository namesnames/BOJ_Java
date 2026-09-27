import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        List<int[]> list = new ArrayList<>();
        
        for(int i=0; i<priorities.length; i++)
        {
            if(i == location) list.add(new int[]{priorities[i],1});
            else list.add(new int[]{priorities[i],0});
        }
        
        while(!list.isEmpty())
        {
            if(list.size() == 1)
            {
                answer++;
                break;
            }
            
            int now = list.get(0)[0];
            int tar = list.get(0)[1];
            
            //System.out.println(now + " " + tar);
            
            boolean isBig = false;
            for(int i=1; i<list.size(); i++)
            {
                if(list.get(i)[0] > now) 
                {
                    isBig = true;
                    break;
                }
            }
            
            if(isBig)
            {
                list.remove(0);
                list.add(new int[]{now,tar});
            }
            else
            {
                list.remove(0);
                answer++;
                if(tar == 1) return answer;
            }
        }
        
        return answer;
    }
}