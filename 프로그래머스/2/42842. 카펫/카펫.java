class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1; i<= yellow; i++)
        {
            if(yellow % i == 0)
            {
                int b = yellow / i;
                
                if((2 * (b + i)) + 4 == brown)
                {
                    if(i >= b)
                    {
                        answer[0] = i + 2;
                        answer[1] = b + 2;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}