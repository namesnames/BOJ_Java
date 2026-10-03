import java.util.*;

class Solution {
    int R,C;
    int sr, sc, er, ec, lr, lc;
    String[] map;
    int[] dr = new int[]{0, 1, 0, -1};
    int[] dc = new int[]{-1, 0, 1, 0};
    int[][] V;
    
    int bfs(int r, int c, char dest)
    {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{r,c});
        V[r][c] = 1;
        
        while(!dq.isEmpty())
        {
            int[] temp = dq.pollFirst();
            if(map[temp[0]].charAt(temp[1]) == dest)
            {
                return V[temp[0]][temp[1]];
            }
                
            for(int d=0; d<4; d++)
            {
                int nr = temp[0] + dr[d];
                int nc = temp[1] + dc[d];
                if(0<=nr && nr<R && 0<=nc && nc<C 
                   && map[nr].charAt(nc) != 'X'
                   && V[nr][nc] == 0)
                {
                    dq.add(new int[]{nr,nc});
                    V[nr][nc] = V[temp[0]][temp[1]] + 1;
                }
            }
        }
        return 0;
    }
    public int solution(String[] maps) {
        int answer = 0;
        R = maps.length;
        C = maps[0].length();
        this.map = maps;
        
        for(int r=0; r<R; r++)
        {
            for(int c=0; c<C; c++)
            {
                if(map[r].charAt(c) == 'S')
                {
                    sr = r;
                    sc = c;
                }
                else if(map[r].charAt(c) == 'L')
                {
                    lr = r;
                    lc = c;
                }
                else if(map[r].charAt(c) == 'E')
                {
                    er = r;
                    ec = c;
                }
            }
        }
        
        // 출발지부터 레버까지 최소거리
        V = new int[R][C];
        int one = bfs(sr,sc, 'L');
        
        // 레버부터 출구까지 최소거리
        V = new int[R][C];
        int two = bfs(lr,lc, 'E');
        // for(int r=0; r<R; r++)
        // {
        //     for(int c=0; c<C; c++)
        //     {
        //         System.out.print(V[r][c] + " ");
        //     }
        //     System.out.println();
        // }
        
        if(one == 0 || two == 0) answer = -1;
        else answer = one + two -2;
        
        return answer;
    }
}