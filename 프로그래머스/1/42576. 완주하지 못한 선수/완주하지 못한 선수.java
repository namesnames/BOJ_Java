import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        TreeMap<String,Integer> map = new TreeMap<>();
        
        for(int i=0; i<completion.length; i++)
        {
            if(map.get(completion[i]) == null)
            {
                map.put(completion[i], 1);  
            }
            else 
            {
                map.put(completion[i], map.get(completion[i]) + 1);    
            }
            
        }
        
        // for(Map.Entry<String,Integer> val : map.entrySet())
        // {
        //     System.out.println(val.getKey());
        // }
        
        for(int i=0; i<participant.length; i++)
        {
            // 아예 비었거나
            if(map.get(participant[i]) == null) 
            {
                answer = participant[i];
                break;
            }
            
            //이미 있는거면 -1
            if(map.get(participant[i]) > 0)
            {
               map.replace(participant[i], map.get(participant[i])-1); 
            }
            else // 값 0이면 답
            {
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
}