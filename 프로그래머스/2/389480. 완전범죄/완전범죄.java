import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;
        int N = info.length;
        
        // B갯수 3 | 2 | 1 별 갯수
        int one = 0;
        int two = 0;
        int three = 0;
        
        for(int i=0; i<N; i++)
        {
            int b_num = info[i][1];
            if(b_num == 1) one++;
            else if(b_num == 2) two++;
            else if(b_num == 3) three++;
        }
        System.out.println(one + ":" + two + ":"+three);
        

        
        Arrays.sort(info, (a,b) -> a[1] == b[1] ? b[0] - a[0]
                                                : b[1] - a[1]);
        
        for(int i=0; i<=three; i++)
        {
            for(int j=0; j<=two; j++)
            {
                for(int k=0; k<=one; k++)
                {
                    int[] V = new int[N];
                    
                    int pick_three = 0;
                    int pick_two = 0;
                    int pick_one = 0;
                    
                    for(int idx=0; idx<N; idx++)
                    {
                        if(pick_three < i && info[idx][1] == 3)
                        {
                            pick_three++;
                            V[idx] = 1;
                        }
                        
                        if(pick_two < j && info[idx][1] == 2)
                        {
                            pick_two++;
                            V[idx] = 1;
                        }
                        
                        if(pick_one < k && info[idx][1] == 1)
                        {
                            pick_one++;
                            V[idx] = 1;
                        }
                    }
                      
                     //체크
                    int a = 0;
                    int b = 0;
                    for(int v_idx=0; v_idx<N; v_idx++)
                    {
                        if(V[v_idx] == 0) a += info[v_idx][0];
                        else b += info[v_idx][1];
                    }

                    if(a < n && b < m) 
                    {
                        answer = Math.min(answer, a);
                        // System.out.println(a + " : " + b);
                        // System.out.println(pick_one + ":"+pick_two+":"+pick_three);
                    }
                }
            }
        }
        
        if(answer == Integer.MAX_VALUE) answer = -1;
        
        return answer;
    }
}