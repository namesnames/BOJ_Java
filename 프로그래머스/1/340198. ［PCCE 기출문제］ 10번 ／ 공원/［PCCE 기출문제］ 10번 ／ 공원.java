import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        
        Arrays.sort(mats);
        
        for(int t=mats.length-1; t>=0; t--)
        {
            int L = mats[t];

            for(int r=0; r<park.length; r++)
            {
                for(int c=0; c<park[0].length; c++)
                {
                    //탐색 시작부분이 -1가 아니면 pass
                    if(!park[r][c].equals("-1")) continue;
                    
                    int cnt = 0;

                    for(int i=r; i<r+L; i++)
                    {
                        for(int j=c; j<c+L; j++)
                        {
                            if(   i < park.length 
                               && j < park[0].length
                               && park[i][j].equals("-1")) 
                            {
                                cnt++;
                            }
                        }                            
                    }
                    if(cnt == L * L && L > answer) answer = L; 

                }
            }
            
            if(answer > 0) break;
        }
        
        if(answer == 0) answer = -1;
        
        return answer;
    }
}