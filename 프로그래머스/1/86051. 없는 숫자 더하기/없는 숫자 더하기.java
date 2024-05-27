import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        
        int result = 45;
        int temp = 0;
        for(int n : numbers){
            temp += n;
        }
        
        answer = result - temp;
        return answer;
    }
}