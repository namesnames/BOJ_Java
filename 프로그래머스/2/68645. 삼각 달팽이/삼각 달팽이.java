import java.util.*;

class Solution {
    int[] dr = new int[]{-1,1,0};
    int[] dc = new int[]{-1,0,1};
    
    public int[] solution(int n) {
        
        int[][] matrix = new int[n][n];
        
        int cnt = 1;
        for(int r=0; r<n; r++)
        {
            matrix[r][0] = cnt;
            cnt++;
        }
        for(int c=1; c<n; c++)
        {
            matrix[n-1][c] = cnt;
            cnt++;
        }
        
        int W = n-2; // loop당 이동횟수
        int R = n-1;
        int C = n-1;
        
        int loop = 0;
        while(W > 0)
        {
            for(int i=0; i<W; i++)
            {
                R += dr[loop % 3];
                C += dc[loop % 3];

                matrix[R][C] = cnt;
                cnt++;
            }
            
            W--;
            loop++;
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int r=0; r<n; r++)
        {
            for(int c=0; c<n; c++)
            {
                if(matrix[r][c] != 0) list.add(matrix[r][c]); 
            }
        }
        
        int[] answer = new int[list.size()];
        for(int idx=0; idx<list.size(); idx++)
        {
            answer[idx] = list.get(idx);
        }
        
        return answer;
    }
}