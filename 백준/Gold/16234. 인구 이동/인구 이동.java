import java.io.*;
import java.util.*;

// G가 모두 0일때 stop
// bfs로 그룹 탐색

public class Main{
    static int N, L, R;
    static int[][] matrix, G;
    static int[] dr = new int[]{0,-1,0,1};
    static int[] dc = new int[]{1,0,-1,0};

    static boolean bfs(int x, int y){
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{x,y});

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{x,y});
        while(!dq.isEmpty()) {
            int[] temp = dq.poll();
            int r = temp[0];
            int c = temp[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (0 <= nr && nr < N && 0 <= nc && nc < N && G[nr][nc] == 0){
                    int val = Math.abs(matrix[nr][nc] - matrix[r][c]);
                    if(L <= val && val <= R) {
                        G[nr][nc] = 1;
                        dq.add(new int[]{nr, nc});
                        list.add(new int[]{nr,nc});
                    }
                }
            }
        }
        int total = 0;
        if(list.size() >= 2){
            for(int[] node : list){
                //System.out.println("r:" + node[0] + " c:"+node[1]);
                total += matrix[node[0]][node[1]];
            }
            int set = total / list.size();
            for(int[] node : list){
                matrix[node[0]][node[1]] = set;
            }
        }

        if(list.size() >= 2) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while(true){
            G = new int[N][N];
            int cnt = 0;
            // 그룹이 한 개라도 묶였다면 dont stop
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(G[r][c] == 0){
                        G[r][c] = 1;
                        if(bfs(r,c)) cnt++;
                    }
                }
            }
            if(cnt == 0) break;
            day++;
        }
        System.out.println(day);
    }
}