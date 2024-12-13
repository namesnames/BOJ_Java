import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int N = sizes.length;
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            int a = sizes[i][0];
            int b = sizes[i][1];
            if(a > b){
                list1.add(a);
                list2.add(b);
            }
            else{
                list1.add(b);
                list2.add(a);
            }
        }
        Collections.sort(list1, Collections.reverseOrder());
        Collections.sort(list2, Collections.reverseOrder());
        
        int answer = 0;
        answer = list1.get(0) * list2.get(0);
        return answer;
    }
}