import java.util.*;

class Solution {
    static int[] dr = new int[]{0,1,0,-1};
    static int[] dc = new int[]{-1,0,1,0};
    static int R;
    static int C;
    
    static int[][] matrix;
    
    static int bfs(int i, int j)
    {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{i,j});
        
        int[][] V = new int[R][C];
        // 시작점 방문표시
        V[i][j] = 1;
        
        while(!dq.isEmpty())
        {
            int[] temp = dq.pollFirst();
            
            for(int d=0; d<4; d++)
            {
                int nr = temp[0] + dr[d];
                int nc = temp[1] + dc[d];
                if(0<=nr && nr<R && 0<=nc && nc<C 
                   && V[nr][nc] == 0 && matrix[nr][nc] ==1)
                {
                    dq.add(new int[]{nr,nc});
                    V[nr][nc] = V[temp[0]][temp[1]] + 1;
                }
            }
        }
        
        
        if(V[R-1][C-1] == 0) return -1;
        else return V[R-1][C-1];
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        R = maps.length;
        C = maps[0].length;
        
        matrix = new int[R][C];
        
        // 깊은복사 연습
        for(int r=0; r<R; r++)
        {
            matrix[r] = maps[r].clone();
        }
        
        answer = bfs(0,0);
        
        return answer;
    }
}