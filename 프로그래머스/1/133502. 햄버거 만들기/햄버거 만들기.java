import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int g : ingredient){
            list.add(g);
            
            while(list.size() >= 4){
                int N = list.size()-1;
                
                if(!(list.get(N) == 1 && list.get(N-1) == 3
                   && list.get(N-2) == 2 && list.get(N-3) == 1)){
                    break;
                }
                list.remove(N-3);
                list.remove(N-3);
                list.remove(N-3);
                list.remove(N-3);
                answer++;
            }
        }
        return answer;
    }
}