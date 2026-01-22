import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 0 -> 48
        // 공백 -> 32
        // 대문자 65~90
        // 소문자 97~122
        // 그냥 Char배열에 넣기
        
        Character[] list = new Character[s.length()];
        for(int i=0; i<list.length; i++)
        {
            list[i] = s.charAt(i);
        }
        
        if(97 <= list[0] && list[0] <= 122)
        {
            list[0] = (char)(list[0] - 32);
        }
        
        for(int i=1; i<list.length; i++)
        {
            if(list[i-1] == 32 && 97 <= list[i] && list[i] <= 122)
            {
                list[i] = (char)(list[i] - 32);
            }
            else if(list[i-1] != 32 && 65 <= list[i] && list[i] <= 90)
            {
                list[i] = (char)(list[i] + 32);
            }            
        }
        
        for(Character c : list)
        {
            answer += c;
        }
        
        return answer;
    }
}