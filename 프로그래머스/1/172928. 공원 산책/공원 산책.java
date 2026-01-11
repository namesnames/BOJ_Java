import java.util.*;

class Solution {
    int R, C;
    int H, W;
    String[] P;
    
    
     void check(String D, int N)
        {
            int nr = R;
            int nc = C;
            
            if(D.equals("E")) nc = C + N;
            else if(D.equals("W")) nc = C - N;        
            else if(D.equals("S")) nr = R + N;
            else if(D.equals("N")) nr = R - N;
        
            if(0<= nr && nr < H && 0<= nc && nc<W 
               && P[nr].charAt(nc) != 'X')
            {
                if(D.equals("E"))
                {
                    nr = R;
                    nc = C + N;
                    for(int i=C; i<=nc; i++)
                    {
                        if(P[nr].charAt(i) == 'X') return;
                    }
                }
                else if(D.equals("W"))
                {
                    nr = R;
                    nc = C - N;
                    for(int i=nc; i<=C; i++)
                    {
                        if(P[nr].charAt(i) == 'X') return;
                    }
                }
                else if(D.equals("S"))
                {
                    nr = R + N;
                    nc = C;
                    for(int i=R; i<=nr; i++)
                    {
                        if(P[i].charAt(nc) == 'X') return;
                    }
                }
                else if(D.equals("N"))
                {
                    nr = R - N;
                    nc = C;
                    for(int i=nr; i<=R; i++)
                    {
                        if(P[i].charAt(nc) == 'X') return;
                    }
                }
                
                R = nr;
                C = nc;
            }
        }
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        H = park.length;
        W = park[0].length();
        
        P = Arrays.copyOf(park, H);
        
        for(int r=0; r<park.length; r++)
        {
            for(int c=0; c<park[r].length(); c++)
            {
                if(park[r].charAt(c) == 'S')
                {
                    R = r;
                    C = c;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++)
        {
            StringTokenizer st = new StringTokenizer(routes[i]);
            String direction = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            check(direction, num);
        }
    
        
        answer[0] = R;
        answer[1] = C;
        
        return answer;
    }
}