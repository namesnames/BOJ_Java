import java.io.*;
import java.util.*;


public class Main {
    static int[] dr = new int[]{2,1,-1,-2,-2,-1,1,2};
    static int[] dc = new int[]{1,2,2,1,-1,-2,-2,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];
            int[][] V = new int[N][N];

            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int wr = Integer.parseInt(st.nextToken());
            int wc = Integer.parseInt(st.nextToken());

            Deque<int[]> dq = new ArrayDeque<>();
            dq.add(new int[]{sr,sc});
            V[sr][sc] = 1;

            while(!dq.isEmpty()){
                int[] cur = dq.poll();
                int r = cur[0];
                int c = cur[1];
                if(r == wr && c == wc){
                    break;
                }
                for(int d=0; d<8; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(0<=nr && nr<N && 0<=nc && nc<N && V[nr][nc] == 0){
                        dq.add(new int[]{nr,nc});
                        V[nr][nc] = V[r][c] + 1;
                    }
                }
            }
            System.out.println(V[wr][wc] - 1);
        }
    }
}
