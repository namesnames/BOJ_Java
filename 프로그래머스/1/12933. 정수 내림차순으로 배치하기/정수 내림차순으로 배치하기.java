import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        long answer = 0;
        
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s2.compareTo(s1);
            }
        });
        for(String l : list){
            sb.append(l);
        }
        
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}