import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        TreeMap<String,Integer> map = new TreeMap<>();
        
        for(int i=0; i<id_list.length; i++)
        {
            map.put(id_list[i], i);
        }
        
        TreeSet<String>[] list = new TreeSet[id_list.length];
        
        for(int i=0; i<id_list.length; i++)
        {
            list[i] = new TreeSet<>();
        }
        
        StringTokenizer st;
        
        for(int i=0; i<report.length; i++)
        {
            st = new StringTokenizer(report[i]);
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            
            list[map.get(str2)].add(str1);
        }
        
        for(int i=0; i<list.length; i++)
        {
            if(list[i].size() >= k)
            {
                for(String str : list[i])
                {
                    if(map.get(str) != null)
                    {
                        answer[map.get(str)]++;
                    }
                }
            }
        }
        
        return answer;
    }
}