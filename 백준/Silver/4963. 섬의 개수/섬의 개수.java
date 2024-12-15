import java.io.*;
import java.util.*;

public class Main {
    static int R,C;
    static int[] dr = new int[]{1,1,0,-1,-1,-1,0,1};
    static int[] dc = new int[]{0,1,1,1,0,-1,-1,-1};

    static boolean[][] V;
    static int[][] matrix;
    static void bfs(int i, int j){
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{i,j});
        while(!dq.isEmpty()){
            int[] temp = dq.poll();
            int r = temp[0];
            int c = temp[1];
            for(int d=0; d<8; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(0<=nr && nr<R && 0<=nc && nc<C && matrix[nr][nc] == 1 && !V[nr][nc]){
                    dq.add(new int[]{nr,nc});
                    V[nr][nc] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(c == 0 && r == 0) break;

            R = r;
            C = c;
            matrix = new int[r][c];
            V = new boolean[r][c];
            for(int i=0; i<r; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<c; j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    if(matrix[i][j] == 1 && !V[i][j]){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
